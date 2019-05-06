# Grade for assignment1

| Criterion                    | Points Earned / Total Points    | 
|:---------------              | -------------------------------:| 
| Problem 1    				   |             47/50               | 
| Problem 2                    |             43/50               | 
| **Grand Total**              |          **90/100**             | 


## Problem 1
* -1 for using magic number; declare constants instead.

* -2 for not checking that the required time range is valid (at least in the constructor)


## Problem 2
* -1 for using magic number; declare constants instead.

* -2 for not checking that the required cents range (at least in the constructor).

* Nice job including constructors in your UML diagram!

* -1 for missing types of parameters in Deposit() and Withdrawal()
* 	as well as in constructors in UML diagram. 

* -3 for dessigning methods deposit and withdraw to handle too much. Implementation of methods 
* 	should be split between Amount and Account classes. For example, adding methods such 
* 	as addMoney, or subtractMoney in the Amount class so that these methods can be called  
* 	in deposit and withdraw methods in the Account class. In this way, the Amount class is 
* 	not leaking implementation details to the Account class.

Well Done!
