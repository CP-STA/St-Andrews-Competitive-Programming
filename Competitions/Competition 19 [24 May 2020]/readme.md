# Competition 18 Analysis  
Setter: Kanishk Ali Khanna 

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-18/challenges 

##Overall comments 
This competition had a total of 3 questions and it turned out to be harder than expected. Most contestants had only made submissions to the ﬁrst problem and that took longer than intended. It was good to see that one contestant was able to solve question 3 with the appropriate segment tree/fenwick tree optimization and a few more were able to solve it after the contest.  
## Statistics
Number of contestants who made a submission: 12 <br>
Highest score: 60/100 <br>
Lowest score: 1.4/100 <br>
Mean: 16.68/100 <br>
Median: 20/100 <br>
Mode: 20/100 (4 submissions) <br>
All questions have solutions with comments in the hackerrank challenges editorial part. The leaderboard can be found here: https://www.hackerrank.com/contests/competitiveprogramming-st-andrews-beta-contest-18/leaderboard/1 

## Question 1: Twin Primes Closest to N 

Link to Challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-18/challenges/twin-primes-closest-to-n <br>
Highest score: 20/20  <br>
Lowest score: 1.4/20 (7%)  <br>
Mean: 14.06/20 (70.3%) <br>
Number of attempts: 11 <br>
Difficulty: Easy 

This question had the most attempts by far. However, all contestants took longer than expected. This could be due to a few tricky elements within the question. Notably, n being up to 109. It is a bit slow to solve this question by generating a prime sieve starting from the ﬁrst primes. In most cases (especially for large N), starting at N and then looking at numbers below and above N will be faster than generating all primes. Solutions gaining 20 points implemented such an approach. It is worth noting that twin primes are far more common than one might expect when initially attempting the problem and even larger input sizes for instance 1012, can be solved with the default hackerrank time limit.
  
Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-18/challenges/twin-primes-closest-to-n/editorial 

## Question 2: LEU - KGX 3 

Link to challenge: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-18/challenges/leu-kgx-3 <br>
Highest score: 0/40  <br>
Lowest score: 0/40 <br>
Mean: 0/40 <br>
Number of attempts: 2 <br>
Difficulty: Medium  

This question is part of the LEU KGX series and past version of the problem can be found here: [LEU KGX](https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-9/challenges/leu-kgx) [LEU KGX 2](https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-14/challenges/leu-kgx-2).
This question had no successful submissions during the contest, however a few contestants solved it after the contest including one contestant who solved it just a few minutes after the contest had ended. The scoring in this question was binary as several test cases could be passed due to the nature of the problem and hence only a completely correct solution will be accepted. One possible approach (taken by the setter as well as by other successful contestants) was using dynamic programming.  <br>
The student has a few choices each day he/she is travelling. At a particular day a student can hold a single ticket, weekly, monthly or annual season ticket. Minimising cost at each day travelled after sorting the array passed into the function will result in the correct answer at the last day the student chooses to travel. The dp array will be storing the minimum cost of travel up until each day the student wanted to travel. 

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-18/challenges/leu-kgx-3/editorial 

A successful submission after the contest by a candidate that also used dynamic programming with memosiation is given below:

```python3
#!/bin/python3

import math
import os
import random
import re
import sys

from functools import lru_cache

def solve(planned_travel_days):
    # Write your code here
    daySet = set(planned_travel_days)
    costs = [100, 399, 999, 4999]

    @lru_cache(None)
    def dp(day):
        if day > 365:
            return 0
        elif day in daySet:
            best = float("inf")
            best = min(best, dp(day + 1) + costs[0])
            best = min(best, dp(day + 7) + costs[1])
            best = min(best, dp(day + 30) + costs[2])
            best = min(best, dp(day + 365) + costs[3])

            return best
        else:
            return dp(day + 1)

    return dp(1)
```

## Question 3: Palindrome Query Update  (2pts, 8pts, 30pts) 
Link to challenge: https://www.hackerrank.com/contests/competitive-programming-standrews-beta-contest-18/challenges/palindrome-query-update <br>
Highest score: 40/40  (100%) <br>
Lowest score: 1.4/40 (3.5%) <br> 
Mean: 11.35/40 (28.4%) <br>
Number of attempts: 4 <br>
Difficulty: Hard  

This question was intended to be easy to understand but difﬁcult to optimize for those who haven’t done segment tree problems before. It was designed to introduce people to segment trees in case they haven’t worked with them before. Only one contestant managed a perfect score on this question during the contest while other contestants only gained 2pts (for a brute force solution).  <br>
A segment/fenwick tree will ensure that query and update operations are carried out in O(log n) time. It is also worth noting that update can be optimised a bit more by only updating when a non-palindrome is replaced with a palindrome or vice versa. 

Solution with comments: https://www.hackerrank.com/contests/competitive-programmingst-andrews-beta-contest-18/challenges/palindrome-query-update/editorial

The only successful submission during the contest that used the segment tree approch is shown below:

```c++
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


bool is_palindrome(string S)
{
    int n = S.size();
    for (int i =0; 2*i <= n; i++)
        if (S[i] != S[n-i-1])
            return false;
    return true;
}

int n;
vector<int> segment_tree;


int sum(int l, int r, int x, int tl, int tr) {
    if (l > r) 
        return 0;
    if (l == tl && r == tr) 
    {
        return segment_tree[x];
    }
    int tm = (tl + tr) / 2;
    return sum(l, min(r, tm), x*2+1, tl, tm) + sum(max(l, tm+1), r, x*2+2, tm+1, tr);
}

void update(int pos, int new_val, int x, int tl, int tr) 
{
    if (tl == tr) 
    {
        segment_tree[x] = new_val;
    } 
    else 
    {
        int tm = (tl + tr) / 2;
        if (pos <= tm)
            update(pos, new_val, x*2+1, tl, tm);
        else
            update(pos, new_val, x*2+2, tm+1, tr);
        segment_tree[x] = segment_tree[2*x+1] + segment_tree[2*x+2];
    }
}

int main() {
    cin >> n;
    segment_tree.resize(4*n, 0);
    
    string t;
    for (int i =0; i<n; i++)
    {
        cin >> t;
        if (is_palindrome(t))
            update(i, 1, 0, 0, n);
    }
    int q;
    cin >> q;
    char query_type;
    int l, r, pos;
    for (int i =0; i<q; i++)
    {
        cin >> query_type;
        if (query_type == 'U')
        {
            cin >> pos;
            cin >> t;
            if (is_palindrome(t))
                update(pos, 1, 0, 0, n);
            else
                update(pos, 0, 0, 0, n);
        }
        else
        {
            cin >> l >> r;
            cout << sum(l, r, 0, 0, n) << "\n";
        }
    }
    return 0;
}
```