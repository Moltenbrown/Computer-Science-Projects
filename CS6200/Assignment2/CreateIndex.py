from DocumentID import documentID
from TermID import termID
import sys

fileToIndex = sys.argv[1]

termID = termID()
termID.generateTermID(fileToIndex)

documentID = documentID()
documentID.generateDocumentID(fileToIndex)