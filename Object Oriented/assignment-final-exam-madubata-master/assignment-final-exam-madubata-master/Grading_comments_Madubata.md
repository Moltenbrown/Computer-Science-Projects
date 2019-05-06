# Grade Comments for the Final Exam

| Criterion                    | Points Earned / Total Points    | 
|:---------------              | -------------------------------:| 
| Problem 1 (a)   				           4/5                 | 
| Problem 1 (b)                |           10/10               | 
| Problem 1 (c)                |            5/5               | 
| Problem 2 (a)   				           18/20                 | 
| Problem 2 (b)                |            10/10               | 
| Problem 3 (a)                |            3/5               | 
| Problem 3 (b)                |            0/5               | 
| Problem 3 (c)                |            0/20               | 
| Problem 4                    |            0/20               | 
              | 
| **Grand Total**              |          **50/100**             | 

##Total Exam Points: 100
 
 ##Problem 1 TOTAL: 20
 
## Problem 1 (a) - 4 points 
	* Appropriate Javadoc - 2 points
	* Appropriate unit test - 2 points
		- Cases:
			- empty list of students - you didn't check this case (-0.5 point)
			- students have the same first letter - you also didn't check this case (-0.5 point)
			- all students have different last names
			
	Problem 1 (b) - 5 points 
		* No Javadoc -2 points
		* Nice job using helper method highGrades()
		* No unit test -3 points
		 	- Cases:
		 		- both HW and exam grades higher than 3.7
		 		- both HW and exam grades lowet that 3.7 - case missing
		 		- HW grade lower, exam grade higher
		 		- HW grade higher, exam grade lower
		 		
		* Appropriate implementation
			- simple code using foreach loop
			- preoperly returns list of first and last names
			
	Problem 1 (c) - 3 points
		* Again no Javadoc -2 points
		* Appropriate and simple implementation - 3 points    
     
##Problem 2 TOTAL: 30

## Problem 2 (a) - 18 points
	* Appropriate class TopicIndex, without any fields - 5 points
	* Develop a method to convert from one data structure into another
		- Static method, with an input argument
		- Includes the starting data collection as an input argument
		- No code to check that the given argument is not empty (-2 points)
		- Code to transform the given data collection into the TopicIndex
			- Makes sure to check if the topic already exists

## Problem 2 (b) - 10 points
	* An appropriate class TrendingTopics with appropriate fields (constants) - 4 points
	* An appropriate method countTopics() - 6 points
		- Makes sure to check whether or not topic already exists, and only then updated the counter
		- Be careful about magic numbers
	
##Problem 3 TOTAL: 30		

## Problem 3 (a) - 3 points
	* Appropriate Javadoc - 2 points
	* Unit test - tests not quite done
		- Some cases you probably want to consider: (-2 points) 
			- "CCISSeattle"
			- "NEUNEUNEUaaaSea";
			- "NEUNEUNEUCCISSea"
			- "CCIS"
			- "Sea";
			
## Problem 3 (b) - 0 points		
	* Not implemented
		
## Problem 3 (c) - 0 points
	* Not implemented
	
##Problem 4 TOTAL: 0
	* Not implemented
	