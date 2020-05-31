# Analysis and brief notes for Contest 20

*Setter: Leaderboard*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-20

## Overall notes

The contest was disappointing in attendance. It is unclear why only six decided to attend. That being said, those who *did* attend did pretty well for the large part, which means that the statistics here are somewhat inflated compared to what I was expecting. This was the second contest where every question was equiscored, but partial marking was fully enabled.

## Statistics

Mean = 47.63/90 (52.9%) <br>
Median = 45/90 (50%) <br>
Mode = 30/90 (33.3%) <br>
Highest = 85.5/90 (95%) <br>
Lowest = 6.79/90 (7.54%) <br>
Number of participants = 6

## Q1: Frequency of names (30)

Mean = 26.13/30 (87.1%) <br>
Median = 30/30 (100%) <br>
Mode = 30/30 (100%) <br>
Highest = 30/30 (100%) <br>
Lowest = 6.79/30 (22.62%) <br>
Number of participants = 6 

*Difficulty: Easy*

This was intended to be a reasonably straightforward question that bore some similarities to [Q2 in Contest 10](https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-10/challenges/quarantining-passengers) in that both solutions would normally use hashing of some sort. While somewhat easier than that question, I was initially concerned that this could be somewhat challenging for Q1, which is usually pretty straightforward. However, nearly all aced this question, perhaps due to the average caliber of the contestants being higher than average. While the time limit was doubled for this question, most could do it within the original limit (my reference solution was a bit above the original time limit, perhaps due to the use of TreeMap).

Virtually all successful approaches used some variation of hashing, like these solutions:

```c++
#include <bits/stdc++.h>

using namespace std;

void frequency_of_names(vector<string> names) {
    // your code goes here!
    map< string, pair<int, int> > n;
    for (int i = 0; i < names.size(); i++) {
        string cn = "";
        for (int j = 0; j < names[i].size(); j++) {
            if (names[i][j] == '_') {
                n[cn].first++;
                cn = "";
            } else {
                cn += names[i][j];
            }
        }
        n[cn].second++;
    }
    for (auto const &it : n) {
        cout << it.first << " " << it.second.first << " " << it.second.second << "\n";
    }
}

int main () {
    int l;
    cin >> l;
    vector<string> names;
    for (int i = 0; i < l; i++) {
        string na;
        cin >> na;
        names.push_back(na);
    }
    frequency_of_names(names);
    return 0;
}
```
```python
# Enter your code here. Read input from STDIN. Print output to STDOUT

import collections

n = int(input().strip())
# [n,m] = list(map(int, input().strip().split()))

fDict = collections.defaultdict(int)
lDict = collections.defaultdict(int)

names = set()

for i in range(n):
    string = input().strip()
    [first, last] = string.split("_")

    fDict[first] += 1
    lDict[last] += 1

    names.add(first)
    names.add(last)

totalNames = list(names)
totalNames.sort()

for name in totalNames:
    print("{} {} {}".format(name, fDict[name], lDict[name]))
```
It should be noted that the code stub was initially incorrect, returning an int which made no sense for this problem, which did cause a bit of confusion. Fortunately, that was quickly fixed within two minutes of the contest.

## Q2: Nth depth sum (30)

Mean = 30/30 (100%) <br>
Median = 30/30 (100%) <br>
Mode = 30/30 (100%) <br>
Highest = 30/30 (100%) <br>
Lowest = 30/30 (100%) <br>
Number of participants = 3

*Difficulty: Medium*

This was a straightforward question that asked users to find the sum of all nodes at a particular depth given a particular root, and could be solved using either BFS (as we can "sweep" though all the nodes on reaching a particular depth), or DFS (keep track of the depth and sum when we reach the desired depth number). Only three made an attempt, but everyone who gave it a go got full credit (hence the 100% for Q2, which is perhaps the first ever time).

A DFS attempt is shown below:

```python
import collections


def solve(n, graph, r, d):
    ans = 0

    def dfs(curr, lvl):
        nonlocal ans

        if lvl == d:
            ans += curr

        for child in graph[curr]:
            dfs(child, lvl + 1)

    dfs(r, 0)

    return ans


n = int(input().strip())
# [n,m] = list(map(int, input().strip().split()))

graph = collections.defaultdict(list)

for i in range(n):
    [u, v] = list(map(int, input().strip().split()))

    graph[u].append(v)

r = int(input().strip())
d = int(input().strip())

print(solve(n, graph, r, d))
```

It is impressive that the same user got *both* Q1 and Q2 in under 7 minutes! Well done to Osama A Rehman for pulling this off, even though he ended up second in the end.

Similarly, a BFS attempt is given below:

```python
from collections import defaultdict, deque
num_edges = int(input())
graph = defaultdict(list)
for _ in range (num_edges):
    u, v = map(int, input().split())
    graph[u].append(v)

start_node = int(input())
depth = int(input())

curr_depth = 0
q = deque([(start_node, 0)])
ans = 0
while q and curr_depth <= depth:
    node, level = q.popleft()
    if level == depth:
        ans += node
    for neigh in graph[node]:
        q.append((neigh, level + 1))
print(ans)
```

## Q3: Fractional decomposition (30)

Mean = 19.5/30 (65%) <br>
Median = 19.5/30 (65%) <br>
Mode = null <br>
Highest = 25.5/30 (85%) <br>
Lowest = 13.5/30 (45%) <br>
Number of participants = 2

*Difficulty: Medium*

This was an unusual question, in which it seemed like conventional algorithms could be used to solve this (even with the reduced constraints), but the problem (Egyptian fractions with lowest sum of denominators) is actually NP-Complete, and hence the algorithm is exponential (technically O(N<sup>5</sup>) for this question). Hence the only way to get full score would be to carefully bruteforce - and to reduce the search space though careful optimisations (though not a lot of work needed to be done there in the end). 

Out of the two users, only one used the right approach, but unfortunately missed the case when only one term is needed (i.e, 2/4 = 1/2) but still got 85% of the points:

```python
def solve(m, n):
    # your code goes here!
    
    ans = float('inf')
    
    limit = 120
    for i in range (1, limit):
        for j in range (i + 1, limit):
            if (m * i * j) == (n * (i + j)):
                ans = min(ans, i + j)
            for k in range (j + 1, limit):
                if (m * i * j * k) == (n * (i*j + j*k + i*k)):
                    ans = min(ans, i + j + k)
                for l in range (k + 1, limit):
                    if (m * i * j * k * l) == (n * ((i * j * k) + (i * k * l) + (j * k * l) + (i * j * l))):
                        ans = min(ans, i + j + k + l)
    return ans
    

m, n = map(int, input().split())
print(solve(m, n))
```

Notice that while the upper bound of the constraints is 1000, in reality a bound of 120 would be enough, and that negates the need to perform additional optimisations that would otherwise be helpful, if not required.

The other approach, and the "expected" one, is to use a well-known greedy approach by repeatedly subtracing from the largest unit fraction possible. While many counterexamples exist, such a solution still did reasonably well with around 45% of the points.

```python
def fraction_decomposition(m, n):
    # your code goes here!
    dens = []

    def go(num, den):
        if num:
            res = ceil(den/num)
            dens.append(res)

            go(res * num - den, den*res)

    go(m, n)

    print(dens)

    if len(dens) > 5:
        return -1
    else:
        return sum(dens)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    [m, n] = list(map(int, input().strip().split()))

    result = fraction_decomposition(m, n)

    fptr.write(str(result) + '\n')

    fptr.close()
```