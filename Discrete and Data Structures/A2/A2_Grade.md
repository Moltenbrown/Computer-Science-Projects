Assignment 2
===
### Question 1: 6/8
For both question, n is a non-negative number, so the base case should be n = 0.
### Question 2: 7/8
(b) your second step went wrong. n = 2^i, so i = logn,<br>
so you will get the running time of n^2.
### Question 3: 6/6
### Question 4: 3/9
* For all the questions, you can make use of hash table, the run time will be O(n)<br>, for example (a)
  * Put all checks in a hash table (keyed by customer name) (O(n))<br>
  * For each invoice, check to see if the hash table has a related check (O(n)) <br>
  * If not, put the invoice in the “not paid” list. Runtime: O(n)<br>
(b) Go through each product in the list. Put the wholesaler in a hash table, with the key being the wholesaler<br>
name, and the value being the number of products (incrementing the value each time you put a new one<br>
into the hashtable). (O(n))
(c) For each invoice, put the customer name in a hash table. (O(n)) <br>
Return the number of keys in the final hash table.
### Question 5: 2/2
### Question 6: 13*0.9/15
(d) θ(nk + n lg(n/k))=θ(nlgn) <br>
nk = θ(nlgn) or nlg(n/k) =θ(nlgn) <br>
From above, the largest value for k is θ(lgn) <br>
(f) you should give a final answer for that, n ≤ 43 <br>

Due to late submission, you have a penalty on the last question.


Total: 35.7/48
---
