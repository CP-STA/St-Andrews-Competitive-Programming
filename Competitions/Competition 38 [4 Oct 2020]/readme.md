# Contest 38 Analysis

*Setter: Leaderboard*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-38

## Overall comments

This contest was unexpectedly low scoring, with the median being 0, which is highly unusual (probably due to the lower average caliber compared to usual, but even then it was surprising). Also I expected more than 9 people to take part, given that this contest was fairly well publicised.

Only one user did well.

## Statistics

Mean = 14.37/100 <br>
Median = 0/100 <br>
Mode = 0/100 <br>
Highest = 96.91/100 <br>
Lowest = 0/100 <br>
Number of participants = 9

## Q1: Bitcoin hijacking (20)

*Difficulty - Easy*

### Solution sketch

Grab each word in the string, and check if it is a Bitcoin address. If it is, then perform the hijack, taking the substring of first 4 characters, and replacing the rest with the given attack string. 

### Statistics

* Mean = 9.78/20 (48.9%)
* Median = 0/20 (0%)
* Mode = 0/20 (0%)
* Highest score = 20/20 (100%)
* Lowest score = 0/20 (0%)
* Number of users = 9

### Comments

This was poorly done for Q1. There were only two correct answers, both of which involved straightforward string splitting:

```python3
def bitcoin_hijacking(text):
    result = []
    for word in text.split(' '):
        if len(word) == 26 and word.startswith('0'):
            result.append(word[:4] + 'rgtorjzwg21qyrwono56tl')
        else:
            result.append(word)
    return ' '.join(result)
```

Another solution was correct but got a lot of TLEs (and got only around 11% as a result) - this was unexpected since the test cases were not brutally high (but weren't trivial like Q2 either). A closer look uncovers the reason:

```java
public static String bitcoin_hijacking(String text) {
    // your code goes here!
        String[] words = text.split(" ");
        String blah = "";
        for(String word: words){
            if(word.length()==26 && word.charAt(0) == '0'){
                blah += word.substring(0,4);
                blah += "rgtorjzwg21qyrwono56tl ";
            }
            else{
                blah += word + " ";
            }
        }
        return blah;

    }
```

The main problem is the use of string addition. The main problem with this approach is that as strings are immutable, adding strings will *always* create a new copy, which is hugely inefficient compared to the reference solution's use of StringBuilder. This pattern also seen in some other solutions, including those that got no points (which were otherwise wrong as well).

One solution was hardcoded to solve only the sample test cases - the reason for that isn't clear.

## Q2: Graph paths (35)

*Difficulty - Medium*

### Solution sketch

DP-based recursion. The number of leaves of the parent include all the leaves of its children. Hence just recurse into an array using DFS from the root node, and then take a walk in the DP array, collecting all the paths along the process.

(An alternative would be to brute-force DFS along every reachable node, which is less efficient)

### Statistics

* Mean = 19.25/35 (55%)
* Median = null
* Mode = null
* Highest score = 35/35 (100%)
* Lowest score = 3.5/35 (10%)
* Number of users = 2

### Comments

There were very few attempts for the problem, and the only solution to get full points appeared to do an O(n<sup>2</sup>) iterative approach, which worked as the limits were very low (due to the recyclicing of test cases from a different problem).

```python3
from collections import defaultdict, deque
n = int(input())
graph = defaultdict(list)
all_nodes = set()
for i in range (n):
    u, v = map(int, input().split())
    graph[u].append(v)
    all_nodes |= {u, v}
leaves = set()
for node in all_nodes:
    if node not in graph:
        leaves.add(node)
root = int(input())
reachable = set()
q = deque([root])
while q:
    front = q.popleft()
    reachable.add(front)
    for neigh in graph[front]:
        if neigh not in leaves and neigh not in reachable:
            q.append(neigh)
            reachable.add(neigh)
ans = 0
for node in reachable:
    q = deque([node])
    while q:
        front = q.popleft()
        for neigh in graph[front]:
            if neigh in leaves:
                q.append(neigh)
                ans += 1
            else:
                q.append(neigh)
print(ans)
```

The reference solution used a more elegant recursive DFS approach, which is explained in the solution sketch.

## Q3: Minimising swaps (45)

*Difficulty - Medium*

### Solution sketch

Nearly all of the points can be done by a bubble-sort idea that involves finding a set of swaps to a particular position of the array (from last to first). To get 100% would involve looking into more advanced approaches.

## Statistics

* Mean = 20.96/45 (46.6%)
* Median = null
* Mode = null
* Highest score = 41.91/45 (93.1%)
* Lowest score = 0/35 (0%)
* Number of users = 2

### Comments

This was an interesting open-ended problem that I set inspired from the LeetCode problem on pancake sorting, with the constraints made harder and the focus changed into actually minimising the swaps. The question was designed in such a way that not a lot of work would be required to get >90% of the points, but some work would be required to get a perfect score (Bill Gates' sort falls below the 1.8n threshold as an example).

The only solution that got points did pretty well:

```python3
def minimising_swaps(arr):
    if len(arr) == 0:
        return []
    # your code goes here!
    sorted_arr = sorted(arr)
    ans = []
    n = len(arr)
    for i in range (n):
        max_arr = sorted_arr[-i - 1]
        idx = arr.index(max_arr)
        if idx != 0:
            ans.append(idx)
        arr = list(reversed(arr[:idx + 1])) + arr[idx + 1:]
        ans.append(n - i - 1)
        arr = list(reversed(arr[:n-i])) + arr[n - i: ]
        if arr == sorted_arr:
            return ans
    return ans
```

It is interesting that it did nearly, but not as well, as the reference solution, which got a 42/45 (so just a bit more). I actually wrote an inefficient solution before that appeared to be O(n<sup>2</sup>) in the length of the array, which caused a lot of swaps (> 1 million) and caused the custom checker to run out of time (that one got around 17%).