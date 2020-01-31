# Analysis and overall comments for Competition 2

*Setter: Leaderboard*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-1/challenges

## Overall comments

This competition went well. While only a few contestants attempted the contest, those who did performed fairly well. Parial marking was enabled and ended up making a significant difference in the ranks.

Number of contestants who made a submission: 6 <br>
Highest score: 76/100 <br>
Lowest score: 20/100 <br>
Mean: 46.3/100 <br>
Median: 44.1/100 <br>
Mode: 40/100 
## Question 1 - FizzBuzz Reloaded A (20)

Highest score: 20/20 <br>
Lowest score: 20/20 <br>
Mean: 20/20 <br>
Number of attempts: 6

*Difficulty: Easy*

This is a straightfoward question that twisted the FizzBuzz game slightly and asked users to find the length of the concatenated FizzBuzz string. Every contestant got this right, with nearly all getting the O(1) solution nearly instantanously. I saw one solution that ran into TLE because their solution was O(N), but they quickly found the optimal solution. Most contestants (except the ones who used Python) got WA (wrong answer) on the last test case; this was because they didn't realise that the output would exceed the limit of int. 

## Question 2 - The Mysterious Chocolate Box (20)

Highest score: 20/20 <br>
Lowest score: 20/20 <br>
Mean: 20/20 <br>
Number of attempts: 5

*Difficulty: Easy to Medium*

This was a question that looked tricky from the outset, but was very straightfoward once the idea was understood, with every contestant getting this right again. Most correct solutions finished it off in one line as expected, with a couple of solutions doing it the manual way (which is also fine).

## Question 3 - Peaks and valleys of stocks (30)

Highest score: 30/30 <br>
Lowest score: 8.18/30 <br>
Mean: 19.09/30 <br>
Number of attempts: 2

*Difficulty: Medium* <br>
*Source: https://open.kattis.com/problems/upsanddownsofinvesting*

This question was originally anticipated to be a reasonable step up from Q2, but ended up being harder than anticipated. Only one submission scored full marks, with another coming very close (minus a runtime error). Both such solutions used an O(n) approach.

## Question 4 - Fruit Baskets 1 (30)

Highest score: 13.45/30 <br>
Lowest score: 6.21/30 <br>
Mean: 9.83/30 <br>
Number of attempts: 2

*Difficulty: Medium to Hard* <br>
*Source: https://purdue.kattis.com/problems/fruitbaskets*

This was anticipated to be the hardest question, and it mostly delivered up to that expectation. One user used a naive approach to the problem, but such solutions could get only about 44% of the points. There was an unfortunate bug in the test cases - formally some of them did not match the constraints - which would have made solving the problem very difficult. One user did manage to get this correct, but only after the competition ended.