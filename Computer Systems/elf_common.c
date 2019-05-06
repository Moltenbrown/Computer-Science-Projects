#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <elf.h>
#include <unistd.h>
#include <fcntl.h>
#include <memory.h>
#include "elf_common.h"

#define mmapLength 40960
#define elfCheck 4
#define nameLength 100
#define sizeOfProgramHeader 56
#define sizeOfSectionHeader 64
#define amountOfSymbols 1000
#define sizeOfSymbolNames 1000

ElfData getELFData(char* executable) {
    // opening and mapping the file;
    int file = open(executable, O_RDONLY);
    if(file == -1) {
        perror("Issue opening the file");
        exit(1);
    }

    // determining whether the file is an ELF file by checking the first 4 bytes of the file
    char *elfCheckString = malloc(elfCheck * sizeof(char));
    int successCheck = pread(file, elfCheckString, elfCheck, 0);
    if(successCheck == NULL) {
        perror("Error getting first four bytes of file:");
        exit(2);
    }

    if(elfCheckString[0] != 0X7F || elfCheckString[1] != 'E' || elfCheckString[2] != 'L' || elfCheckString[3] != 'F') {
        printf("This file is not an ELF file. Closing the program.\n");
        exit(0);
    }

    void *mappedFile;
    if((mappedFile = mmap(NULL, mmapLength, PROT_READ, MAP_SHARED, file, 0)) == (void *)-1) {
        perror("Failure mapping");
        exit(1);
    }

    close(file);

    ElfData ret;

    // converting to uint16_t so I can get all the values in the ELF header
    //uint16_t *conversion = (uint16_t *)mappedFile;
    uint16_t sectionOffset = *(uint16_t *)(mappedFile + 0x28);
    uint16_t sectionSize = *(uint16_t *)(mappedFile + 0x3A);
    uint16_t sectionAmount = *(uint16_t *)(mappedFile  + 0x3C);
    uint16_t programHeaderLocation = *(uint16_t *)(mappedFile  + 0x20);
    uint16_t programHeaderSectionSize = *(uint16_t *)(mappedFile  + 0x36);
    uint16_t programEntryAmount = *(uint16_t *)(mappedFile  + 0x38);
    uint16_t headerSize = *(uint16_t *)(mappedFile + 0x34);

    // mallocing space for the ELF struct programHeader and sections
    ret.programHeader = malloc(programEntryAmount * sizeof(Elf64_Phdr));
    ret.sections = malloc(sectionAmount * sizeof(struct ElfSection));

//    int startOfElfPH = 0;
    //uint16_t sizeOfPH = programHeaderSectionSize * programEntryAmount;

    void *hdrStart = mappedFile;

    // copying ELF header into ELF struct
    memcpy(&ret.elfHeader, (Elf64_Ehdr *)hdrStart, headerSize);

    //program header is 56 bits
    //populating ElfData programHeader section.
    void *phdrStart = mappedFile + programHeaderLocation;

    ret.programHeader = (Elf64_Phdr *)malloc(programEntryAmount * sizeof(Elf64_Phdr));
    for(int i = 0; i < programEntryAmount; i++) {
        memcpy(&ret.programHeader[i], (Elf64_Phdr *)phdrStart, sizeOfProgramHeader);
        phdrStart += programHeaderSectionSize;
    }

    // copying section information into the ELF Section struct and saving that into ElfData sections symbolList
    void *sectionStart = mappedFile + sectionOffset;
    ret.sections = (ElfSection *)malloc(sectionAmount * sizeof(ElfSection));
    void *sectionNamesLocation = sectionStart + (ret.elfHeader.e_shstrndx * ret.elfHeader.e_shentsize);
    char *sectionNames = (char *)sectionNamesLocation;
    for(int i = 0; i < sectionAmount; i++) {
        memcpy(&ret.sections[i].sectionHeader, (Elf64_Shdr *)sectionStart, sizeOfSectionHeader);
        ret.sections[i].sectionName = malloc(nameLength * sizeof(char));
        uint32_t nameLocation = ret.sections[i].sectionHeader.sh_name;
        char holder = sectionNames[nameLocation];
        int locationInName = 0;
        while(holder != '\0') {
            ret.sections[i].sectionName[locationInName++] = holder;
            nameLocation++;
            holder = sectionNames[nameLocation];
        }

        sectionStart += sectionSize;
    }

    ret.dynSymbols.list = malloc(amountOfSymbols * sizeof(ElfSymbol));
    ret.dynSymbols.size = 0;


    void *symbolsCheckStart = mappedFile + sectionOffset;

    for (int i = 0; i < sectionAmount; i ++) {
        if(ret.sections[i].sectionHeader.sh_type == 0x0B) {
            uint32_t dynSymbolSize = ret.sections[i].sectionHeader.sh_entsize;
            void *dynSymbolSectionStart = symbolsCheckStart + (sectionSize * (i+1)); //getting where the dyn symbols section may start
            void *dynSymbolSectionEnd = dynSymbolSectionStart + sectionSize;// getting where the dyn symbols section may end
            void *dynSymbolStart = dynSymbolSectionStart + sizeOfSectionHeader ; //getting where the dyn symbols probably start
            uint32_t dynNamesLink = ret.sections[i].sectionHeader.sh_link; // finding the .dynstr table
            char *dynSymbolNameListStart = (char *)(symbolsCheckStart + (sectionSize * dynNamesLink));
            while(dynSymbolStart != dynSymbolSectionEnd) {
                memcpy(&ret.dynSymbols.list[ret.dynSymbols.size].symbol, dynSymbolStart, dynSymbolSize);
                ret.dynSymbols.list[ret.dynSymbols.size].name = malloc(nameLength * sizeof(char));
                uint32_t nameIndex = ret.dynSymbols.list[ret.dynSymbols.size].symbol.st_name;//getting dynsym name index
                strcpy(ret.dynSymbols.list[ret.dynSymbols.size++].name, dynSymbolNameListStart[nameIndex]);
                dynSymbolStart += dynSymbolSize;
            }

        }
    }

    ret.otherSymbols.list = malloc(amountOfSymbols * sizeof(ElfSymbol));
    ret.otherSymbols.size = 0;

    for (int i = 0; i < sectionAmount; i ++) {
        if(ret.sections[i].sectionHeader.sh_type == 0x2) {
            uint32_t otherSymbolSize = ret.sections[i].sectionHeader.sh_entsize;
            void *otherSymbolSectionStart = symbolsCheckStart + (sectionSize * (i+1)); //getting where the other symbols section may start
            void *otherSymbolSectionEnd = otherSymbolSectionStart + sectionSize;// getting where the other symbols section may end
            void *otherSymbolStart = otherSymbolSectionStart + sizeOfSectionHeader ; //getting where the other symbols probably start
            uint32_t otherNamesLink = ret.sections[i].sectionHeader.sh_link; // finding the .symstr table
            char *otherSymbolNameListStart = (char *)(symbolsCheckStart + (sectionSize * otherNamesLink));
            while(otherSymbolStart != otherSymbolSectionEnd) {
                memcpy(&ret.otherSymbols.list[ret.otherSymbols.size].symbol, otherSymbolStart, otherSymbolSize);
                ret.otherSymbols.list[ret.otherSymbols.size].name = malloc(nameLength * sizeof(char));
                uint32_t nameIndex = ret.otherSymbols.list[ret.otherSymbols.size].symbol.st_name;//getting dynsym name index
                strcpy(ret.otherSymbols.list[ret.otherSymbols.size++].name, otherSymbolNameListStart[nameIndex]);
                otherSymbolStart += otherSymbolSize;
            }

        }
    }

    munmap(mappedFile, mmapLength);
    return ret;
}

void destroyELFData(ElfData elfData)  {
    for (int i = 0; i < elfData.dynSymbols.size; i++){// freeing all the names in the dynSymbols list.
        free(elfData.dynSymbols.list[i].name);
    }

    free(elfData.dynSymbols.list);

    for (int i = 0; i < elfData.otherSymbols.size; i++) { //freeing all the names in the otherSymbols list
        free(elfData.otherSymbols.list[i].name);
    }

    free(elfData.otherSymbols.list);

    uint16_t sectionAmount = elfData.elfHeader.e_shnum; //freeing all the sections and section names
    for (int i = 0; i < sectionAmount; i++) {
        free(elfData.sections[i].sectionName);
    }

    free(elfData.sections);

    free(elfData.programHeader);
}



