Assignment 3
===
Q1: 4/4 <br>
The key word in this question is “stable”. It means when merging the two subarrays together, mergesort should settle ties in the lists by choosing the lower indexed value.

Q2: 4/4

Q3: 0/3

	To begin:(a + b)(c + d) = ac + ad + bc + bd 
    So, we compute that product, we also compute ac and bd. This gets us that the product of the two polynomials is:
    (ax + b)(cx + d) = acx2 + adx + bcx + bd
    = acx2 + (ad + bc)x + bd
    = acx2 + ((a + b)(c + d) − ac − bd)x + bd
    Our three multiplications are (a + b)(c + d),(ac),(bd)

Q4: 13/14 <br>
The Θ sign means the upper bond and lower bond are the same. So your big O and Ω should be the same as Θ.

Q5: 8/9 <br>
	(b)2/3 you did not mention how to maintain the ratio, please see solution for details.
	
	Pair all the chips up. This gives us n/2 pairs. If there are an odd number of chips, leave the last one out. 
	For each of these pairs, test the chips. 
	If a test has a result where both chips say both are good, we discard one of them. 
	If a test has a result where at least one is bad, we discard both chips. That means we're 
	discarding one good chip and one bad chip

### Total: 29/34
Good job!
