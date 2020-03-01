# Notes on Contest 7

*Setter: Leaderboard*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-6

**The official scoreboard for this contest is [here](standings.md) and NOT the one on HackerRank.**

## Overall notes

This contest went okay, however there were significant issues with this contest which did affect scoring and also the overall experience. It was the first contest where a question had to be removed in the middle of the contest, and Q1 was missing for a significant period of time while I raced to fix a last-minute bug with the testcases, and there was a minor typo in one testcase of Q2. The setter sincerely apologises for these issues.

On the statistics side of things, the removal of Q3 (which was not meant to be easy) was part of the mean being higher than expected, as the questions were intended to be harder compared to the last contest that I set (which was Contest 2).

### Statistics

* Highest scorer: divvijchandna (66.36/75) (88.5%)
* Lowest score: 10.77/75 (14.4%)
* Mean: 37.7/75 (50.3%)
* Median: 33.64/75 (44.9%)
* Mode: all scores were distinct
* Number of users who made at least one submission: 9

## Q1: Covering a table (20)

* Highest score: 20/20 (100%)
* Lowest score: 10.77/20 (50.4%)
* Mean: 18.97/20 (94.9%)
* Number of users that made an attempt: 9

This question was actually taken down just before the contest started upon the discovery of a last-minute bug during final routine checks. It was added back around 15 minutes into the contest.

Other than that, this was a very straightforward question, and nearly all contestants found it a cakewalk. The only submission that did not earn full points forgot to divide l and b by 2 as the radius of the circle.

## Q2: NP-Tiling (25)

* Highest score: 23.86/25 (95.4%)
* Lowest score: 0/25 (0%)
* Mean: 12.1/25 (48.3%)
* Number of users that made an attempt: 7

This was intended to be a reasonably straightforward DP question - other than the tricky base cases (which many fell under), all that one had to realise was the recursive relation T(n) = T(n - 1) + T(n - p), but however this question ended up getting a variety of interesting solutions. Some users tried to simply return 0; such submissions received only about a quarter right. Another user tried recursion, which didn't help due to TLE and also because the base cases were incorrect. Yet another user used an interesting string-based recursion approach, that mainly failed on the harder test cases only:

```c++
void recur (string cw, long n, long p) {
    //cout << cw << "\n";
    if (cw.length() > n)
        return;
    if (cw.length() == n)
        ways.push_back(cw);
    if (cw.length() <= n-1)
        recur(cw+"0",n,p);
    if (cw.length() <= n-p) {
        string ncw = cw;
        ncw += "1";
        for (int i = 0; i < p-1; i++) {
            ncw += "0";
        }
        recur(ncw,n,p);
    }
}
long np_tiling(int l, int b) {
    // your code goes here!
    long n = l;
    long p = b;
    recur("",n,p);
    return ways.size();
}
```
A couple of users came up with very nice combinatorial attempts (which would work as the constraints were low enough). The below submission was the highest scoring and only failed on the very last test case:
```python
def nCr(n,r):
    r = min(r, n-r)
    numer = reduce(op.mul, range(n, n-r, -1), 1)
    denom = reduce(op.mul, range(1, r+1), 1)
    return numer / denom

def np_tiling(l, b):
    n = l
    r = 0
    s = 0
    if l == 0:
        return 0
    if b == 0:
        return 0
    while (n >= r):
        s += nCr(n, r)
        n -= (b - 1)
        r += 1
    
    return int(s)
```

Of course, traditional DP approaches also worked, but the scores obtained mainly depended on how well the base cases were covered (as that directly impacts the other test cases). The below submission got about 70% of the points:
```python
def np_tiling(n, m):
    # probably dp
    # 1 - left
    # 2 - right
    # 3 - up
    # 4 - down
    
    # m - size of tile
    
#     grid = [[0] * l for _ in range(b)]
    
#     for i in range(b):
#         for j in range(l):
#             if i > 0 and grid[i - 1][j] == 3:
    
    if n == 0 or m == 0:
        return 0
    
    if m == 1:
        return 1
    
    dp = [0] * (n + 1)
      
    for i in range(1, n + 1):
        if (i > m): 
            dp[i] = dp[i - 1] + dp[i - m]           
        elif (i < m):
            # only one possible way when i is less than m
            dp[i] = 1  
        else:
            dp[i] = 2 if n >= m else 1
            
    return dp[n]
```

A small bug meant that one test case had a typo in its expected answer, but that did not affect the overall results of this question.

## Q3: Mystery functions 1 (0)

This question was meant to resemble a miniature Google HashCode-type question (where there is no 'correct' answer and the goal there is to gain the maximum you can), and it was also the very first question to make use of HackerRank's _approximation_ question type. The objective of the question was to find the missing value among a set of values given by an unknown function which could have been one of several different types.

However, there were issues with this question from the start. Firstly, a last-minute bug discovery meant that submissions had to be restricted to all but Java and Python. For some reason, the custom checker crashed for trivial code in C/C++. Unfortunately, it turned out that this issue occurred in other languages. A user tripped the checking system with this piece of fairly innocent-looking code:

 ```python
def mystery_function(x, f_x):
    print(len(f_x))
 ```

The checker was set to accidentally set to give full credit in case the checker itself crashed, which was not intended. As the checking system tripped for every test case, that user ended up accidentally getting full credit. I immediately removed the question upon seeing this (as the question is meant to be very difficult to get full credit in).

It is not clear at this time why the checker crashed, as no such issues were observed in Java when the question was being developed (which is where most of the testing was done). 

## Q4: Lifting Dumbbells (30)

* Highest score: 23.75/30 (79.1%)
* Mean = 14.68/30 (49%)
* Median = 16.25/30 (54.2%)
* Number of users that made an attempt: 4

*Source: https://purdue.kattis.com/problems/freeweights*

The only non-original question in this contest, this was intended to be the hardest question of the contest, and mostly lived to that expectation except for one submission that gamed the test cases.

A variety of approaches were seen for this problem. One user tried to use a list to keep track of the costs (but could only get around 35%):
 ```python
def liftingdumbells(n, row1, row2):
    # your code goes here!
    weights = set(row1 + row2)
    weights = sorted(weights)
    costs = [0]

    for weight in weights:
        if row1.count(weight) == 1:
            costs.append(weight)
            row2.pop(row2.index(weight))

    for weight in weights:
        if weight in row1:
            if row1.index(weight) + 1 < len(row1):
                if row1[row1.index(weight) + 1] is not weight:
                    costs.append(weight)
                    row1.pop(row1[::-1].index(weight))
                    
        if weight in row2:
            if row2.index(weight) + 1 < len(row2):
                if row2[row2.index(weight) + 1] is not weight:
                    costs.append(weight)
                    row2.pop(row2[::-1].index(weight))
                    
    return max(costs)
 ```
Another attempt using a set by another user did much better, getting around 80% of the points:
 ```python
def liftingdumbells(n, row1, row2):
    # your code goes here!
    weights = set()
    
    x = 0
    locations = collections.defaultdict(list)
    for i, x in enumerate(row1):
        weights.add(x)
        locations[x].append(i)
    
    for i, y in enumerate(row2):
        weights.add(y)
        locations[y].append(-i - 1)
        
    locations = dict(locations)
    weights = sorted(list(weights))
    print(weights, locations)
    ans = 0
    for loc in locations:
        y = locations[loc]
        if y[0] >= 0 and y[1] < 0:
            ans = max(ans, loc)
    return ans
 ```

However, the highlight was this submission that took me by surprise, which literally gamed the test cases and got over 75% of the points:
 ```python
def liftingdumbells(n, row1, row2):
    return max(row1)
 ```

I would have definitely added more test cases had I known that this was possible. Part of the reason this did so well was that it ended up passing the 'harder' test cases (i.e the ones that were most likely to return TLE).

