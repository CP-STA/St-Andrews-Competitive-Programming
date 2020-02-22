# Brief notes on Competition 5

*Setter: Nguyen Nguyen*<br>
*Validated by Wang Nguyen*<br>
*Reported by Leaderboard* (Nguyen really didn't want to write this for some reason)

Link to challenges: https://www.hackerrank.com/competitive-programming-st-andrews-beta-contest-4

Highest score: 124.44/600 (20.7%) - by Kanishk Ali Khanna <br>
Lowest score: 39.29/600 (6.6%) <br>
Mean: 62.9/600 (10.5%) <br>
Median: 50/600 (8.3%) <br>
Mode: 50/600 (8.3%) <br>
Number of users that made at least one submission: 5

## Overall comments

*All views are that of the reporter, not the setter*

This contest contained of four well-written fully original questions from the setter, made even better by the fact that he had decided to revolve all four questions based on some characterstic of each member of this group. However, on the other side, the number of participants were surprisingly low (only 5 users made a submission despite there being 18 signups), and the reporter would rate this contest as harder than average, especially on the lower side, and hence the average score was very low.

## Question 1 - Starbucks Spending Problem (50)

Highest score: 50/50 (100%)
Lowest score: 39.28/50 (78.6%)
Mean: 47.86/50 (95.7%)
Number of users that made an attempt: 5

*Difficulty - Medium*

This question was posed as a straightforward dynamic programing problem that asked users to find the maximum amount of money he can spend on four drinks within a budget, and is conceptually similar to LeetCode's Coin Change problem. While some users managed to spot this rightaway, it was (fortunately!) also possible to brute-force the solution in O(n<sup>4</sup>), which would also earn full points. Overall, if brute-force wasn't an option, then this question would be much harder than what one would expect for a Q1 (which is typically a "gimme").

The setter in his Editorial uses an interesting approach using a sieve sieve (in O(n)), but traditional DP methods would also work.

## Question 2 - Phillip's Running Routes

Highest score: 74.44/100
Lowest score: 0/100
Mean: 25/100
Number of users that made an attempt: 3

As can be inferred from the title, this question was dedicated to Philip Searcy, who did not show up for the contest but did it later. For a Q2, this question ended up being harder than expected again, with classic O(n<sup>3</sup>) (which would get zero points) and O(n<sup>2</sup>) soluions not working. The most common approach would be to look up on the internet: a closed-form expression would be ([n)/48); however ([n) in tihs case refers to the nearest integer function (and that is *not* equal to the greatest integer function which some mistook it for, though this would have still allowed gaining a substantial number of points). However, the setter expected an O(n) solution, which no-one did during the competition. Overall, this question was pretty difficult for Medium if one did not know (or look up) the O(1) solution for this problem.

## Question 3 - Sorting a Leaderboard

## Question 4 - The Longest Journey

No submissions were recorded for either problem.