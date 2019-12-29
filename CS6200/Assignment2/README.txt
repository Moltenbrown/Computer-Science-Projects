The most difficult part of the assignment was the useindex function. I kept running into an issue where I tried to filter out the result files to make sure only files that included all the search terms appeared. No matter what I did, I couldn't get it to filter correctly.

The easiest part of the assignment was creating the RunDataTransformer. Creating the Stats file made this very easy.

All three index files were done in a json format where the key to the information is either a term, in the case of TermID and InvertedIndex, and the relative document path in the case of DocumentID. 
In the case of TermID, the "token" is the term, the "documents" are all the documents that contain that term, and the "frequency" is the amount of documents the word is in.
For Document ID, the "name" if the relative path of the document and the "length" contains the length of the document.
For Inverted ID, the "document name" is the relative path of the document and "term frequency" is the term frequency.

The results are contained in UseIndexResults.txt. The query was "japanese writing system."

