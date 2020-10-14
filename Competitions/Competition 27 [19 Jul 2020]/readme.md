# Contest 27 Analysis 

Setter: Kanishk Ali Khanna

## Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-27/challenges

## Overall comments

This contest had a lower turnout than usual and the setter did expect more submissions after the contest (hence the delay in the release of the analysis). It was good to see than 2/5 contestants managed to solve all 3 questions. 

* Number of contestants who made a submission: 5
* Highest score: 100/100
* Lowest score: 9/100
* Mean: 49.1
* Median: 26.5/100
* Mode: 100

All questions have solutions with comments in the hackerrank challenges editorial part. 

The leaderboard can be found here: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-27/leaderboard


## Question 1: Co - Prime Count

Link to Challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-27/challenges/co-prime-count

* Highest score: 30/30 
* Lowest score: 9/30 
* Mean: 21.37/30
* Number of attempts: 4
* Difficulty: Easy

This question had the most attempts and 2 contestants made a successful attempt during the contest. A brute force solution cannot get perfect 30 points. A more optimal solution will try looking at a key aspect of the question that the number is a product of two primes. Hence by finding the smaller prime we can find the larger one as we know n and in the average and worst case the Time Complexity is O(sqrt(n)).

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-27/challenges/co-prime-count/editorial


## Question 2:Longest Substring: Even Character Counts

Link to challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-27/challenges/longest-substring-even-character-counts


* Highest score: 30/30 
* Lowest score: 10/30
* Mean: 20
* Number of attempts: 4
* Difficulty: Medium  

All contestants managed to solve this question and 2 contestants managed to get the optimal solution. The optimal solution to this problem will make use of the fact that the number of characters in the character set is small.

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-27/challenges/longest-substring-even-character-counts/editorial



## Question 3: LEU - KGX 5

Link to challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-27/challenges/leu-kgx-5/problem

* Highest score: 40/40 
* Lowest score: 0/40
* Mean: 26.66/40
* Number of attempts: 3
* Difficulty: Medium 

The question had a total of 3 submissions and 2 of them achieved a perfect score. This problem can be solved using Backtracking. This will help us get the maximum amount of free tickets one can collect. One needs find a way to keep track of seats they have visited and the maximum amount of free tickets they have collected. At each cell/seat the person can move one cell/seat up/left/right/down only when that cell is within the bounds, has not been visited and contains some free tickets.

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-27/challenges/leu-kgx-5/editorial
