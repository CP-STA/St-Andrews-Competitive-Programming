# Competition 23 Analysis

*Setter: Kanishk Ali Khanna*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-23/challenges
## Overall comments

The first 2 questions had a simple brute force solution and it was intended that all contestants
solve the 10 point test cases for both of these questions. Question 3 required a bit more
thought and understanding of graphs and only had 1 successful attempt during the contest.

### Statistics

* Number of contestants who made a submission: 9
* Highest score: 92.5/100
* Lowest score: 7/100
* Mean: 35.57/100
* Median: 30/100
* Mode: All scores were unique

All questions have solutions with comments in the hackerrank challenges editorial part.

The leaderboard can be found here: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-23/leaderboard

## Question 1: Maximised Power Digit Sum

Link to Challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-23/challenges/maximised-power-digit-sum

### Statistics

* Highest score: 29.5/30 (98.3%)
* Lowest score: 7/30 (23.3%)
* Mean: 19.94/30 (66.5%)
* Number of attempts: 8

*Difficulty: Easy* 

This question had the most attempts by far. However, no contestant made a successful
attempt during the contest. This was mainly due to a few edge cases in the problem, for
instance when k (the power each digit will be taken to) = 0. There were a few successful
submissions gaining a full 30/30 score after the contest. 

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-23/challenges/maximised-power-digit-sum/editorial

## Question 2: Previous Element Less Than Current

Link to challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-23/challenges/previous-element-less-than-current/problem

### Statistics

* Highest score: 30/30 (100%)
* Lowest score: 0.67/30 (2.2%)
* Mean: 17.23/30 (57.4%)
* Number of attempts: 7

*Difficulty: Medium*

The brute force version of this question with O(n<sup>2</sup>) was intended to be easy however this
question was a little tricky to optimise. One way to optimise the solution was to solve the
question using a stack (The complexity is O(n) as elements are pushed and popped upto 1
time each from the stack). There were a total of three users who solved this question
completely and gained 30 out of 30 points. As expected there were a few users who were able
to solve the brute force version of the problem and gained 10 points.

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-23/challenges/previous-element-less-than-current/editorial

## Question 3: LEU - KGX 4
Link to challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-23/challenges/leu-kgx-4

### Statistics

* Highest score: 40/40 (100%)
* Lowest score: 0/40
* Mean: 13.33/40 (33.3%)
* Number of attempts: 3

*Difficulty: Hard*

This question is part of the LEU KGX series and past version of the problem can be found
here.

[LEU KGX](https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-9/challenges/leu-kgx)		 	 	 	 	 	 	 	 	 [LEU KGX 2](https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-14/challenges/leu-kgx-2/editorial)
[LEU KGX 3](https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-18/challenges/leu-kgx-3/submissions)

This question had just one successful submissions during the contest. This question was
intended to have hard constraints and required thought. For instance it was worth noting that
the number of stations is low (the problem setter had used actual station codes in the test
cases). Hence considering that the number of edges in the graph would be more than a
number of stations squared it is reasonable to assume the different trains with a different
amount of times between the same two destinations. Storing the fastest between two stations
will enable this problem to be solved faster. Another optimisation is by disregarding longer
total train times once a total time from LEU to KGX (from then on the fastest time between
LEU to KGX will be considered before adding new elements onto the queue) has been
found.

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-23/challenges/leu-kgx-4/editorial