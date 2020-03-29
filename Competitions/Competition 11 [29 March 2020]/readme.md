# Analysis for Contets 10

*Setter: Leaderboard*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-10

Reference (i.e, setter's) solutions to the problems, along with their test case generators, can be found here as well.

## Overall notes

This contest went well. It is the first contest to ever be held in partnership (this time with HackQuarantine), and the scoreboard was streamed live on their Twitch channel was well (https://twitch.tv/hackquarantine).

As with the contest itself, we had a good set of scores, with Q2 being the question that separated most contestants. This contest also had a first in that it is the first ever contest to have a perfect score (90/90), congratulations to Nguyen Nguyen for achieving this.

Personally, I thought that the contest would be somewhat higher scoring than usual, but the statistics were in line with other contests, partially due to many people finding Q2 and Q3 tricky to get more than a few points.
### Statistics

Mean = 31.3/90 (34.8%) <br>
Median = 21.35/90 (23.7%) <br>
Mode = 21.35/90 (23.7%) <br>
Highest = 90/90 (100%) <br>
Lowest = 2/90 (2.2%) <br>
Number of users making an attempt during the contest: 17

## Q1: A (boring) game (20)

*Difficulty - Easy*

Mean: 18.71/20 (93.5%) <br>
Median: 20/20 (100%) <br>
Mode: 20/20 (100%) <br>
Highest: 20/20 (100%) <br>
Lowest: 2/20 (10%) <br>
Number of users making an attempt during the contest: 17


This was mostly straightforward for most contestants (as expected), with many getting the hint that the maximum value is the same irrespective of the ordering, though I suspect not all of them understood the mathematical logic behind this. The key idea to note is that the operation (a + b + ab) is *both* commutative and associative (whose proof we omit), and hence the final answer is the same no matter which number we pick (the commutative part) and the ordering (associative). Some contestants did variants of this, for example some used the idea of stacks:

```python
def a_boring_game(n):
    arr = [x for x in range(1, n+1)]
    arr = arr[::-1]
    sum = arr.pop()
    while(len(arr) != 0):
        next = arr.pop()
        tmp = sum
        sum = sum + next + sum * next 
    return sum
```

Most solutions however took the traditional approach of simply using a loop:

```python
def op(a, b):
    return a + b + a * b

def a_boring_game(n):
    # your code goes here!
    ans = n
    for i in range(n - 1, 0, -1):
        ans = op(ans, i)
    
    return ans
```

A small minority did not get full points on this problem, and one mostly tried to generate all permutations. Due to the low constraints, that solution still did pretty well, but ran into TLE issues on the last test case. Another submission forgot to change the data type into long, and yet another didn't even loop at all (hence passing only one test case). Overall though, this was very well done.

# Q2: Quarantining passengers (35)

*Difficulty: Medium*

Mean: 11/35 (31.4%) <br>
Median: 1.35/35 (3.9%) <br>
Mode: 1.35/35 (3.9%) <br>
Highest: 35/35 (100%) <br>
Lowest: 1.35/35 (3.9%) <br>
Number of users making an attempt during the contest: 12

This seemed to be a question where contestants either got it or didn't (barring a solution in the middle). For some reason, most contestants passed the three simple test cases (which were manually written), but passed none of the other hidden test cases (which were automatically generated), which made this question pseudo-binary in nature. It was clear that contestants *knew* how to do it, but couldn't figure out why their code wasn't working, and perhapes ended up being very frustrating. TLEs (along with the wrong answers) were also common.

Looking at the three successful submissions (which were all in Python), most opted to traverse the seat map and check the list of positive passengers for each seat; i.e, O(P) per query. 

```python
def quarantining_passengers(passengers, positive_passengers):
    pos = set(positive_passengers)
    ans = set(positive_passengers)
    
    for i, row in enumerate(passengers):
        for j, cell in enumerate(row):
            if cell in pos:
                for y, x in [(i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)]:
                    if 0 <= y < len(passengers) and 0 <= x < len(row) and passengers[y][x] not in {"empty", "aisle"}:
                        ans.add(passengers[y][x])
    
    return sorted(list(ans))
```

However my reference solution (in Java) employed a different approach. If we pre-compute the list of passengers with their seat location, we can then take each positive passenger and then, after extracting the coordinates (using a hashmap), we can add other passengers into the list in constant-time per query:

```java
public static List<String> quarantining_passengers(List<List<String>> passengers, List<String> positive_passengers) {
    // your code goes here!
     TreeSet<String> ans = new TreeSet<>();
      HashMap<String, Pair> core = new HashMap<>();
        // now add everyone into the hashmap
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < passengers.size(); j++)
            {
                if (passengers.get(j).get(i).equals("empty") || passengers.get(j).get(i).equals("aisle"))
                {
                    // don't add
                }
                else
                {
                    Pair P = new Pair(j, i);
                    core.put(passengers.get(j).get(i), P); // add into hashmap
                }
            }
        }
        // now check who all needs to be self-quarantined based on the list of positive cases

        for (String s:positive_passengers)
        {
            // get the coordinate
            Pair P = core.get(s);
            // now use the roster to find out who else should be in the list
            if (P.y != 0)
            {
                // leftward checking allowed
                if (!passengers.get(P.x).get(P.y - 1).equals("empty") && !passengers.get(P.x).get(P.y - 1).equals("aisle"))
                {
                    ans.add(passengers.get(P.x).get(P.y - 1));
                }
            }
            if (P.y < 6)
            {
                // rightward checking allowed
                if (!passengers.get(P.x).get(P.y + 1).equals("empty") && !passengers.get(P.x).get(P.y + 1).equals("aisle"))
                ans.add(passengers.get(P.x).get(P.y + 1));
            }
            if (P.x != 0)
            {
                // upward checking allowed
                if (!passengers.get(P.x - 1).get(P.y).equals("empty"))
                ans.add(passengers.get(P.x - 1).get(P.y));
            }
            if (P.x < passengers.size() - 1)
            {
                // downward checking allowed
                if (!passengers.get(P.x + 1).get(P.y).equals("empty"))
                ans.add(passengers.get(P.x + 1).get(P.y));
            }
            ans.add(s); // positive passenger must also self quarantine
        }
        List<String> res = new ArrayList<String>(ans);
        return res;
```

As noted above, one solution got a bit less than half the available points as its solution was a 'less-efficient' brute-force:
```python
def quarantining_passengers(passengers, positive_passengers):
    # your code goes here!
    avoid = ['aisle', 'empty']
    res = set(positive_passengers)
    #print(passengers)
    for i,row in enumerate(passengers):
        for j, p in enumerate(row):
            if p in positive_passengers:
                if i-1 >= 0:
                    res |= set([passengers[i-1][j]])
                if i+1 < len(passengers):
                    res |= set([passengers[i+1][j]])
                if j-1 >= 0:
                    res |= set([row[j-1]])
                if j+1 < 7:
                    res |= set([row[j+1]])
    return sorted([p for p in res if p not in avoid])
```

Unfortunately, every other solution got the same 1.35/35 score.

# Q3: Miniature Notepad (35)

*Difficulty - Medium*

Mean: 9.15/35 (26.2%) <br>
Median: 1.46/35 (4.2%) <br>
Mode: 0/35 (0%) <br>
Highest: 35/35 (100%) <br>
Lowest: 0/35 (0%) <br>
Number of users making an attempt during the contest: 9

This question, while not hard to code as such, required contestants to make use of linked lists in order to get a full score, which isn't usually expected. Only one contestant realised this, while a couple of others got some points with bruteforce, many didn't score anything at all. Again well-attempted though, and is it clear that contestants did put some thought into this. Like Q2, it ended up mostly being pseudo-binary in nature.

```python
s = input()

class Node:
    def __init__(self, value):
        self.val = value
        self.next = None
        self.prev = None
        
head = Node("")
tail = head

cursor = head

size = 0
best = 0

for c in s:
#     ans = ""

#     node = head
#     while(node.next):
#         node = node.next

#         ans += node.val

#     print(ans)
    if c in {"-", "+", "@", "#", "^"}:
        if c == "-":
            if cursor.prev != None:
                cursor = cursor.prev
                size -= 1
                
        elif c == "@":
            cursor = head
            size = 0
        elif c == "#":
            cursor = tail
            size = best
        elif c == "^":
            cursor = Node("")
            size = 0
            head = tail = cursor
    else:
        tmp = Node(c)
        if cursor.next:
            cursor.next.prev = tmp
            tmp.next = cursor.next
            
            
        cursor.next = tmp
        tmp.prev = cursor
            
        cursor = tmp
        size += 1
        
        if cursor.next == None:
            tail = cursor
        
ans = ""

node = head
while(node.next):
    node = node.next
    
    ans += node.val
    
print(ans)
```

The reason why linked lists are required is mainly because we can get constant-time addition and deletion at either end of the list (if doubly-linked), which is important in a question like this (where most of the operations were at the start or end of the list). Some contestants attempted to use string functions (akin to Java's StringBuilder). The issue with such methods is that methods like inserting are very time-consuming (often quadratic), and will fail here. Linked lists have linear insert overhead, and in many cases constant if at either end of the list.

However, most of the wrong answers ended up getting zero points unfortunately (like the 1.35/35 points in Q2). One interesting solution got about 80% of the points that involved maintaining two strings (a bit like prefix/postix):

```python
inp = input()
out_1 = ''
out_2 = ''
cursor_pos = 0
key_char = {'-', '+', '@', '#', '^'}
for i in inp:
    if i not in key_char:
        out_1 += i
    elif i == '-':
        try:
            out_2 = out_1[-1] + out_2
            out_1 = out_1[:-1]
        except:
            pass
    # elif i == '+':
    #     out_1 = out_1 + out_2[0]
    #     out_2 = out_2[1:]
    elif i == '@':
        out_2 = out_1 + out_2
        out_1 = ''
    elif i == '#':
        out_1 = out_1 + out_2
        out_2 = ''
    elif i == '^':
        out_1 = ''
        out_2 = ''
        
print(out_1 + out_2)
```

A brute-force solution would get nearly 30% of the points in Python (a Java solution I wrote got around 50%):
```python
def solve(string):
    cursor = 0
    result = []
    beginning = []

    for ch in string:
        if ch == '-':
            if cursor > 0:
                cursor -= 1
        elif ch == '+':
            continue
        elif ch == '@':
            cursor = 0
        elif ch == '#':
            cursor = len(result)
        elif ch == '^':
            result.clear()
            cursor = 0
        else:
            result.insert(cursor, ch)
            cursor += 1

    return "".join(result)


string = input().strip()

print(solve(string))
```

