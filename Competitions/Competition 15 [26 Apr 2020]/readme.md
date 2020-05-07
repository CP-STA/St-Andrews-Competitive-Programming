#Competition 14 Analysis
*Setter: Kanishk Ali Khanna*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-14/challenges

## Overall comments
This competition had a total of 3 questions and it was relatively easier than the past
contests as 4 contestants (for the first time) obtained a score of 100/100. The first
question was designed to be easy with thought needed on the 2 major types of
possibilities (all numbers are negative and at least one is positive). The 2nd/3rd
questions required some optimizations in order for contestants to pass all the test
cases. The 2nd question was another version of a question from a past contest but
this time it was designed to be a bit more realistic. The 3rd question described a
scenario where competitive programmers from all across the world are meeting and
trying to help develop software to fight the pandemic (without large gatherings).

Number of contestants who made a submission: 16 <br>
Highest score: 100/100 <br>
Lowest score: 10/100 <br>
Mean: 42.1/100 <br>
Median: 21.21/100 <br>
Mode: 20/100 and 100/100 (4 each)

All questions have solutions with comments in the hackerrank challenges editorial
part. The leaderboard can be found here: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-14/leaderboard/1

## Question 1: Maximum Subsequence Sum
Link to Challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-14/challenges/maximum-subsequence-sum

Highest score: 20/20 <br>
Lowest score: 10/20 <br>
Mean: 18.75/20 <br>
Number of attempts: 16 <br>
Difficulty: Easy

It was good to see that all participants managed to get some points on this
question. A few were not able to get 20 points and this was due to neglecting the
case when only negative integers will be in the array. 2 contestants managed to
solve this question in under 2 minutes.

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-14/challenges/maximum-subsequence-sum/editorial

## Question 2: LEU - KGX 2
Link to challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-14/challenges/number-of-robots/editorial

Highest score: 40/40 <br>
Lowest score: 0/40 <br>
Mean: 24.17/40 <br>
Number of attempts: 8 <br>
Difficulty: Medium <br>

This problem was a sequel to LEU - KGX which can be found [here](https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-9/challenges/leu-kgx). This problem received 4 submissions that were
perfect. A few other users did manage to write completely correct code but this was not
efficient enough. One optimization that was expected was that since the number of
stations in the problem statement is only 30, the number of edges in the graph will
not be very high (under 1000). It was important to note that although there can be
many trains between the same 2 stations there are only a total of 30 * 29 distinct
routes (870). Hence, while the graph is being created, storing only the fastest train
from the source to the destination results in the calculation of the solution to be
faster. <br>
This version of the problem was designed to be more realistic as St Andrews
students (excluding train geeks) wouldn't want to take routes that take too long and
would want to get to London as fast as possible.

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-14/challenges/leu-kgx-2/editorial
## Question 3: Number of Robots
Link to challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-14/challenges/number-of-robots

Highest score: 40/40 <br>
Lowest score: 0.97/40 <br>
Mean: 20.65/40 <br>
Number of attempts: 9 <br>
Difficulty: Medium

It was good to see that many participants attempted this question and 4 managed
to attempt it completely and gain 40 points. It is worth noting that participants
might have had correct completely correct solutions but because the complexity
wasn’t O(n) or O(n log n) it wouldn’t gain a lot of points. Most participants who
solved it correctly identified it to be a greedy interval problem, sorted the intervals
by start time and then proceeded.

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-14/challenges/number-of-robots/editorial