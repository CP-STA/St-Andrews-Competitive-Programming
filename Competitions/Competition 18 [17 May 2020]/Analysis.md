# Analysis and overall comments for Competition 12

*Setter: Philip Searcy*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-11/challenges

## Overall comments

This contest had a slightly lower than normal participation, perhaps
due to the end-of-semester exams occurring at the University of St Andrews
the same week. Two of the questions were written by myself, the problem setter,
and the third was obtained from the HackerRank archives.

Number of contestants who made a submission: 8 <br>
Highest score: 75/75 (100%)<br>
Lowest score: 13.64/75 (18.18%)<br>
Mean: 35.89/75 (47.98%)<br>
Median: 30.525/75 (40.7%) <br>
Mode: 20/75 (26.67%)

## Question 1 - Run Away (20)

Highest score: 20/20 <br>
Lowest score: 20/50 <br>
Mean: 20/20 <br>
Median: 20/20 <br>
Mode: 20/20 <br>
Number of contestants who attempted: 7

This question was an example of a classic problem in computational mathematics:
efficiently finding primes. It was intended to be solved with the Sieve of Erastosthenes. However, some successful solutions used efficient algorithms
for the primality testing of individual numbers.

## Question 2 - Silver Spoon (25)

Highest score: 25/25 <br>
Lowest score: 7.89/25 <br>
Mean: 19.21/25 <br>
Median: 25/25 <br>
Mode: 25/25 <br>
Number of contestants who attempted: 5

This question was very similar to a previous Question 3 from an earlier contest.
It required contestants to find the determinant of an nxn matrix given as input, a task intended to be done recursively. All successful solutions used this approach. In the first several minutes of the contest, this question had the
same test cases as Question 1 - this issue was fixed when spotted, and did not have a meaningful effect on the final results of the contest.

## Question 3 - Sam and substrings (30)

Highest score: 30/30 <br>
Lowest score: 0/30 <br>
Mean: 8.64/30 <br>
Median: 4.09/30 <br>
Mode: 0/30 <br>
Number of contestants who attempted: 6

This problem was obtained from the HackerRank archives, and was intended to
be solved with a dynamic programming approach. The constraints given were
slightly misleading, as it was possible to interpret '1 <= n <= 2 x 10^5' as the
'maximum' input being 200005, as opposed to maximum number of characters in the
input string being 2 x 10^5. The problem setter apologises for any inconveniences
caused by this.
