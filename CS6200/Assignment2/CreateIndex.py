from TermID import termID
import sys

fileToIndex = sys.argv[1]

termID = termID()
termID.generateTermID(fileToIndex)