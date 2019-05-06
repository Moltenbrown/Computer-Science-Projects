package edu.neu.ccs.cs5004;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorrespondenceCreaterApp {
  public static void main(String[] args) throws Exception {
    Scanner console = new Scanner(System.in);
    System.out.println("Please enter the following information, with spaces between each word,  in "
        + "whatever order you want unless"
        + "otherwise specified.\nType of document generated: --email or --letter\nType of template"
        + " to use, --email-template or --letter-template, followed by absolute path to the template"
        + ".\n--output-dir followed by the absolute path of the directory you want to send the"
        + "generated files to.\n--csv-file followed by the absolute path of the csv file containing"
        + " the client information.");

    String generationCode = console.nextLine();
    String[] info = generationCode.split("\\s");
    List<String> infoToUse = new ArrayList<String>();
    for(String s: info) {
      infoToUse.add(s);
    }
    console.close();
    if(infoToUse.size() < 7 || infoToUse.size() > 7) {
      System.out.println("Error - improper input. You've entered input outside of the number of "
          + "parameters requested.\nTo generate --email, you must use an"
          + "--email-template and provide the absolute path of the template.\nTo generate --letter"
          + "you must use --letter-template and provide the absolute path for the template.\nBoth"
          + "--email and --letter require you use --output-dir followed by the absolute path of"
          + "the folder to save your created files in\nand --csv-file followed by the absolute path "
          + "of the csv file containing the client information.\n\nExamples:\n--email "
          + "--email-template email-template.txt --output-dir /emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir /letter --csv-file "
          + "customer.csv");
    }

    if(!infoToUse.contains("--email") && !infoToUse.contains("--letter")) {
      System.out.println("Error - improper input. You've entered neither --email or --letter as "
          + "what you want to generate.\nTo generate --email, you must use an"
          + "--email-template and provide the absolute path of the template.\nTo generate --letter"
          + "you must use --letter-template and provide the absolute path for the template.\nBoth"
          + "--email and --letter require you use --output-dir followed by the absolute path of"
          + "the folder to save your created files in\nand --csv-file followed by the absolute path "
          + "of the csv file containing the client information.\n\nExamples:\n--email "
          + "--email-template email-template.txt --output-dir /emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir /letter --csv-file "
          + "customer.csv");
      System.exit(1);
    }
    System.out.println("email and letter check clear.");

    if(!infoToUse.contains("--email-template") && !infoToUse.contains("--letter-template")) {
      System.out.println("Error - improper input. You've entered neither --email-template or "
          + "--letter-template to make the template you are using.\nTo generate --email, you must "
          + "use an"
          + "--email-template and provide the absolute path of the template.\nTo generate --letter"
          + "you must use --letter-template and provide the absolute path for the template.\nBoth"
          + "--email and --letter require you use --output-dir followed by the absolute path of"
          + "the folder to save your created files in\nand --csv-file followed by the absolute path "
          + "of the csv file containing the client information.\n\nExamples:\n--email "
          + "--email-template email-template.txt --output-dir /emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir /letter --csv-file "
          + "customer.csv");
      System.exit(1);
    }
    System.out.println("template check clear.");

    if(!infoToUse.contains("--output-dir")) {
      System.out.println("Error - improper input. You've failed to use --output-dir to mark the"
          + "output directory.\nTo generate --email, you must use an"
          + "--email-template and provide the absolute path of the template.\nTo generate --letter"
          + "you must use --letter-template and provide the absolute path for the template.\nBoth"
          + "--email and --letter require you use --output-dir followed by the absolute path of"
          + "the folder to save your created files in\nand --csv-file followed by the absolute path "
          + "of the csv file containing the client information.\n\nExamples:\n--email "
          + "--email-template email-template.txt --output-dir /emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir /letter --csv-file "
          + "customer.csv");
      System.exit(1);
    }
    System.out.println("output check clear.");

    if(!infoToUse.contains("--csv-file")) {
      System.out.println("Error - improper input. You've failed to use --csv-file to mark the"
          + "csv file holding the names.\nTo generate --email, you must use an"
          + "--email-template and provide the absolute path of the template.\nTo generate --letter"
          + "you must use --letter-template and provide the absolute path for the template.\nBoth"
          + "--email and --letter require you use --output-dir followed by the absolute path of"
          + "the folder to save your created files in\nand --csv-file followed by the absolute path "
          + "of the csv file containing the client information.\n\nExamples:\n--email "
          + "--email-template email-template.txt --output-dir /emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir /letter --csv-file "
          + "customer.csv");
      System.exit(1);
    }
    System.out.println("csv check clear.");

    int outputCommandIndex = infoToUse.indexOf("--output-dir");
    Path potentialDirectory = Paths.get(infoToUse.get(outputCommandIndex+1));
    if(!Files.isDirectory(potentialDirectory)) {
      System.out.println("Error - improper input. You've entered a non-directory for an output "
          + "folder.\n Both --email and --letter require you to enter --output-dir followed by the "
          + "absolute path of the folder you want to save your created files in.\nTo generate "
          + "--email, you must use an"
          + "--email-template and provide the absolute path of the template.\nTo generate --letter"
          + "you must use --letter-template and provide the absolute path for the template.\n"
          + "You must enter --csv-file followed by the absolute path "
          + "of the csv file containing the client information.\n\nExamples:\n--email "
          + "--email-template email-template.txt --output-dir /emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir /letter --csv-file "
          + "customer.csv");
      System.exit(1);
    }
    System.out.println("directory check clear.");

    int templateIndex = 0;
    if(infoToUse.contains("--letter-template")) {
      templateIndex = infoToUse.indexOf("--letter-template");
    }

    if(infoToUse.contains("--email-template")) {
      templateIndex = infoToUse.indexOf("--email-template");
    }

    Path templatePath= Paths.get(infoToUse.get(templateIndex+1));
    if(!Files.exists(templatePath)) {
      System.out.println("Error - improper input. You've entered a non-existent file as a template."
          + "\nTo generate --email, you must use an"
          + "--email-template and provide the absolute path of the template.\nTo generate --letter"
          + "you must use --letter-template and provide the absolute path for the template.\nBoth"
          + "--email and --letter require you use --output-dir followed by the absolute path of"
          + "the folder to save your created files in\nand --csv-file followed by the absolute path "
          + "of the csv file containing the client information.\n\nExamples:\n--email "
          + "--email-template email-template.txt --output-dir /emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir /letter --csv-file "
          + "customer.csv");
      System.exit(1);
    }

    int csvMarkIndex= infoToUse.indexOf("--csv-file");
    Path csvFile = Paths.get(infoToUse.get(csvMarkIndex+1));
    if(!Files.exists(csvFile)) {
      System.out.println("Error - improper input. You've entered a non-existent file as a your csv."
          + "containing client information.\nBoth --email and --letter require you to enter "
          + "--csv-file followed by the absolute path of the csv file that contains your client "
          + "information.\nTo generate --email, you must use an"
          + "--email-template and provide the absolute path of the template.\nTo generate --letter"
          + "you must use --letter-template and provide the absolute path for the template.\n"
          + "You must enter --output-dir followed by the absolute path of the folder you want to "
          + "save your created documents in.\n\nExamples:\n--email "
          + "--email-template email-template.txt --output-dir /emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir /letter --csv-file "
          + "customer.csv");
      System.exit(1);
    }

    if(infoToUse.contains("--email") && infoToUse.contains("--letter-template")) {
      System.out.println("Error - improper input. You've entered that you only want to generate"
          + "--email, but no --email-template was given.\nTo generate --email, you must use an"
          + "--email-template and provide the absolute path of the template.\nTo generate --letter"
          + "you must use --letter-template and provide the absolute path for the template.\nBoth"
          + "--email and --letter require you use --output-dir followed by the absolute path of"
          + "the folder to save your created files in\nand --csv-file followed by the absolute path "
          + "of the csv file containing the client information.\n\nExamples:\n--email "
          + "--email-template email-template.txt --output-dir /emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir /letter --csv-file "
          + "customer.csv");
      System.exit(1);
    }

    if(infoToUse.contains("--letter") && infoToUse.contains("--email-template")) {
      System.out.println("Error - improper input. You've entered that you only want to generate"
          + "--letter, but no --letter-template was given.\nTo generate --email, you must use"
          + "--email-template and provide the absolute path of the template.\nTo generate --letter"
          + "you must use --letter-template and provide the absolute path for the template.\nBoth"
          + "--email and --letter require you use --output-dir followed by the absolute path of"
          + "the folder to save your created files in\nand --csv-file followed by the absolute path "
          + "of the csv file containing the client information.\n\nExamples:\n--email "
          + "--email-template email-template.txt --output-dir /emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir /letter --csv-file "
          + "customer.csv");
      System.exit(1);
    }

    String actualTemplatePath = infoToUse.get(templateIndex+1);
    String actualOutputPath = infoToUse.get(outputCommandIndex+1);
    String actualCsvPath = infoToUse.get(csvMarkIndex+1);

    CorrespondenceMaker correspondenceMaker = new CorrespondenceMaker();
    correspondenceMaker.Correspondence(actualTemplatePath, actualOutputPath, actualCsvPath);
    System.out.println("Success.");
    System.exit(0);
  }
}
