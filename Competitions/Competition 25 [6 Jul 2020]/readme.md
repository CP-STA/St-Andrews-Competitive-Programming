# Analysis and overall comments for Competition 25

*Setter: Philip Searcy*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-25/challenges

Number of contestants who made a submission: 6 <br>
Highest score: 26/55 (47.27%) <br>
Lowest score: 15/55 (27.27%)<br>
Mean: 16.83/55 (30.61%) <br>
Median: 15/55 (27.27%%) <br>
Mode: 15/55 (27.27%)

## A Note From The Problem Setter
This contest, like several of my previous contests,
was marred by several issues which made questions unsolvable
even with correct solutions. Before I go any further, I
very much apologise for this. During my time setting contests
at Competitive Programming St Andrews, I have gained a healthy
respect for what it takes to design and build a programming
competition which runs smoothly. I am well aware that the consistency
of mine will need to make a substantial improvement before
the we stop hosting 'beta contests' and starting hosting 'contests', and
I do have every intention of making this improvement. I thank
everyone who has been patient with me so far, and hope to repay this
in the future.


## Question 1 - The Bee Suit Build (15)

Highest score: 15/15 (100%) <br>
Lowest score: 15/15 (100%) <br>
Mean: 15/15 (100%) <br>
Median: 15/15 (100%) <br>
Mode: 15/15 (100%) <br>
Number of contestants who attempted: 6

This was an approachable 'ad hoc' question, where the objective was to decrypt a string given a key and an encryption algorithm. The clearest way of doing this was to just reverse the steps of the encryption algorithm, and this was how all successful solutions worked.

## Question 2 - Cannon Rush (20)
(All submissions got a score of 0) <br>
Number of contestants who attempted: 2

This question was intended to be a 'DP-esque' question in which
correct solutions would take advantage of the fact than the maximum 
number of Photon Cannons was much less than the maximum number
of buildable cells. Although there were no attempts at this method
of solving the question, the constraints made this problem unsolvable anyway.
This issue has since been fixed.

## Question 3 - Snowball Effect (20)
(All submissions got a score of 0 during the
contest, but when tested later after the
question was fixed, all got full marks.) <br>
Number of contestants who attempted: 3

This question was a classical problem which could be solved by
counting the number of inversions in the list of units (using
the unit type definitions to determine which unit types
had 'higher' values than others). All of the solutions but one did this
using an enhanced merge sort (which was used in the editorial solution, too).
The one solution which did not use this technique used a rolling hash, instead.