import math
import re
import curses.ascii
from stats import stats

replacement_value = ''

# class that generates a query token object for each query on the page.
class query_token:
    def __init__(self):
        self.token = None
        self.frequency = 0
        self.weighted_frequency = 0

    # returns the token the query_token is associated with.
    def getToken(self):
        return self.token

    # sets the token
    def setToken(self, token):
        self.token = token

    # returns the how often the token appears in the query
    def getFrequency(self):
        return self.frequency

    # increments the frequency of the token:
    def incrementFrequency(self):
        self.frequency += 1

    # returns the weighted frequency of the token
    def getWeightedFrequency(self):
        return self.weighted_frequency

    # sets the weighted frequency of the token
    def setWeightedFrequency(self):
        if self.frequency > 0:
            self.weighted_frequency = 1 + math.log10(self.frequency)
        else:
            self.weighted_frequency = 0

    # creating query_tokens for each token in each query and storing the queries in an array by the location they initially were
    def generateListOfTokens(self, filename, stat_list):
        location = []
        stat = stats()
        with open(filename, "r") as queryFile:
            for line in queryFile:
                stat.setQuery(line, stat_list)
                results = {}
                line = line.split(' ')
                for word in line:
                    # lowercasing all the words and trying to remove any and all punctuation to match the document token format.
                    word = word.casefold()
                    for letter in word:
                        if curses.ascii.ispunct(letter):
                            word = word.replace(letter, replacement_value)

                    try:
                        result = results[word]
                        result = result.incrementFrequency()


                    except KeyError:
                        holder = query_token()
                        holder.setToken(word)
                        holder.incrementFrequency()
                        results[word] = holder

                for key in results:
                    results[key].setWeightedFrequency()

                location.append(results)

        return location
