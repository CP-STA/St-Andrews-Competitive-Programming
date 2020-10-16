# Analysis and overall comments for Competition 39

*Setter: Philip Searcy*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-39/challenges

Number of contestants who made a submission: 6 <br>
Highest score: 10/10 (100%) <br>
Lowest score: 0.5/10 (5%)<br>
Mean: 4.99/19 (49.9%) <br>
Median: 4.1/10 (41%) <br>
Mode: 10/10 (100%)

## Question 1 - The X Factor (3)

Highest score: 3/3 (100%) <br>
Lowest score: 0.5/3 (0%) <br>
Mean: 1.5/3 (50.00%) <br>
Median: 1/3 (33.33%) <br>
Mode: 3/3 (100%), 1/3 (33.33%), 0.5/3 (16.67%) <br>
Number of contestants who attempted: 6

This question was intended to be solved
using an O(sqrt(x)) algorithm to count the
number of factors of each a_i (where x in
the time complexity shown is a given a_i).
Both full-scoring submissions used this method. Solutions 
which did not score full marks had flawed factor 
counting functions (they either had too high of a 
time complexity as a result of testing more numbers 
for divisibility than were needed, or had
logical errors in the counting itself which caused
incorrect numbers to be returned).
 

## Question 2 - Division Query (3)

Highest score: 3/3 (100%) <br>
Lowest score: 0.75/3 (25%) <br>
Mean: 1.5/3 (50.00%) <br>
Median: 1.55/3 (33.33%) <br>
Mode: 3/3 (100%), 0.75/3 (25%) <br>
Number of contestants who attempted: 5

This question was most easily solved by selecting
a language that has built-in support for large integers
or high-precision division. The former enables the problem
to be solved by multiplying the dividend by a large factor
of 10 and treating the question as an integer division
problem (since multiplying by the factor of 10 does nothing
but move the decimal point, which can be accounted for
with general string manipulation techniques). The latter
enables the problem to be solved through directly calculating
the result of the division. Both approaches were used in
full-scoring solutions. Solutions which did not score full
marks either failed to account for the natural lack of
precision when dividing primitive data types, or
did not pad the quotient string with trailing zeroes
when required (causing a runtime error when the
final substring's indices were not within the
quotient string's length).

## Question 3 - Just Rhymes (5)

Highest score: 3/3 (100%) <br>
Lowest score: 3.2/4 (0%) <br>
Mean: 3.73/4 (93.33%) <br>
Median: 4/4 (100%) <br>
Mode: 4/4 (100%) <br>
Number of contestants who attempted: 3

This question can be solved in a relatively
straightforward manner with the use of in-built
hashing functions (which is how both full-scoring
solutions worked). However, another (potentially faster)
method would be to use a multidimensional array to store 
the frequency of each double-character suffix (this is 
further explained in the editorial). While either 
of these approaches would solve the problem,
it seemed to still be possible for a solution
to time out if the string was not parsed
in an efficient manner (for example, if
linear-time substring functions were used
when just retrieving exact indices would
have been suitable). Perhaps the most
impressive submission was given by the tester, 
who gave a full-scoring one-line solution.
