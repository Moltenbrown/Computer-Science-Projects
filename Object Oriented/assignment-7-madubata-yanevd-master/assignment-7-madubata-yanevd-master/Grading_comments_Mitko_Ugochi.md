# Grade for assignment 7

| Criterion                    | Points Earned / Total Points    | 
|:---------------              | -------------------------------:| 
| General   				   |           10/10               | 
| Problem 1    				   |           40/40               | 
| Problem 2                    |           50/50               | 
| **Grand Total**              |          **100/100**             | 

## General issues
* Thank you for including both UML diagrams. They both look alright
* Nice job with your JavaDoc
* Nice job with your Checkstyle and PMD reports
* Great job with test coverage

## Problem 1
    
 * Media Design
   *  Nice job creating proper interface and abstract classes for multimedia and multimedia library
   *  Nice job including both concrete classes, for movies and TV Series
   *  The one think that I would change is your current implementation of an alias. As of right now, your code prevents 
 	someone from creating an exactly the same Media object, but as long as two objects with the same content
 	have a different alias, your implementation allows that. 
   - The easiest way to implement an alias is by relying on the hashcode of the instance fields, but any meaningful implementation 
      is acceptable.
  
 * Multimedia Library Design
   * Overall, nice job with the design of the multimedia library
   * Nice use of a Comparator to sort media by release year 
     
 * Correctness
   * Get all media given director  - nice job handling a non-existing director, and a director with no work
      - nice job using comparator
   * Add media - again, nice job, but please see my comment about aliases
   * Used a media - nice job
   * Get most used - nice job


## Problem 2

* Driver Registration Design
	* Nice job including a starting class (app) RideSharingApp, and the interface IRegistrationValidator
	* Nice organization of your code into separate packages 
	* Nice job with the package entity (especially the use of generics)
	* Very nice job with the package incident, and the way you handle traffic violations and crashes
		
* Driver Validation Design
	* Registration validator checks drivers license - nice job
		- Difference in names
		- Difference in birthdays
		- US issued drivers license - nice job checking several possible representations of the name of the country of issuance
		- License issued less than six months ago
		- Expired license
	* Registration validator checks vehicle information	- nice job
	* Registration validator checks insurance information - nice job
		- Insurance expired
		- Vehicle owner
		- Has the right to drive
	* Registration validator checks vehicle history - nice job
		- Moving violations
		* Registration validator checks prospective age - nice job

* Correctness
 	* The pool of existing accepted drivers is unique (no same driver with the same vehicle combinations) - nice job
 	* The same driver can be registered with multiple vehicles - nice job using a generic class Pair to achieve this
 	* The same vehicle could be registered with multiple drivers
 	* The app informs the prospective driver of the outcome - nice job
 	* Nice job with tests too
