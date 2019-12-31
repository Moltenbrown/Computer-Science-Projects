import math

# class that generates a query token object for each query on the page.
class query_token:
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

    # sets the weighted frequencey of the token
    def setWeightedFrequency(self):
        if self.frequency > 0:
            self.weighted_frequency = 1 + math.log10(self.frequency)
        else:
            self.weighted_frequency = 0

    # creating query_tokens for each token in each query and storing the queries in an array by the location they initially were
    def generateListOfTokens(self, filename):
        location = []
        with open(filename, "r") as queryFile:
            for line in queryFile:
                results = {}
                for word in line:
                    try:
                        result[word].incrementFrequency()

                    except KeyError:
                        holder = query_token()
                        holder.setToken(word)
                        holder.incrementFrequency()
                        result[word] = holder

                for key in results:
                    results[key].setWeightedFrequency()

                location.append(results)

        return location
