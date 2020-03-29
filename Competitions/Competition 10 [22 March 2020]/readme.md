# Competition 9 Analysis

*Setter: Kanishk Ali Khanna* <br>
*Testers: Vinh Quang Nguyen and Philip Searcy*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-9/challenges

## Overall comments

This competition had a total of 3 questions and was conducted with prior testing of questions. No difficulties were reported by any of the participants. This contest was tested before in Java, C++ and Python. While, the contest was able to secure a relatively large number of sign ups (a total of 29 before the end of the contest), there were fewer than expected participants that made a submission.

While designing the contest it was expected that the first question will be easier than the other two. It was also expected that the top participants will be able to solve more 2-3 questions. 

The designer made a completely unique question in question 2. Question 3 was based on a situation that many St Andrews students will definitely have faced while travelling on British trains.

Another note to make is that the contest turned out to be harder than expected as no participants solved more than 1 question. However, It was pleasing to see that people continued submissions to the harder problems (Question 2 and Question 3) after the contest and multiple successful submissions were made.
### Statistics
Number of contestants who made a submission: 7 <br>
Highest score: 20/100 <br>
Lowest score: 20/100 <br>
Mean: 20/100 <br>
Median: 20/100 <br>
Mode: 20/100

All questions have solutions with comments in the HackerRank challenges editorial part.

## Question 1: Reverse Vowels

Highest score: 20/20 <br>
Lowest score: 20/20 <br>
Mean: 20/20 <br>
Number of attempts: 7 <br>
Difficulty: Easy

This question was relatively straightforward and did indeed turnout to be the highest scoring as it was the only question in the contest with successful submissions. A common approach to solve this problem involved placing the first vowel at the index where the last vowel occurs, second vowels is placed where the second last vowel occurs.

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-9/challenges/reverse-vowels-string/editorial

Successful submissions by contestants are given below:

```python
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'reverse_vowels' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def reverse_vowels(s):
    vowles = ["a", "e", "i", "o", "u"]
    s_vowles = []
    s = list(s)
    for idx, l in enumerate(s):
        if l in vowles:
            s[idx] = "0"
            s_vowles.append(l)
            
    for idx, l in enumerate(s):
        if l == "0":
            s[idx] = s_vowles.pop()
        
    return "".join(s)
        

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = reverse_vowels(s)

    fptr.write(result + '\n')

    fptr.close()
```

```c++
#include <bits/stdc++.h>

using namespace std;

/*
 * Complete the 'reverse_vowels' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

int check(char x){
    return (x=='a')||(x=='e')||(x=='i')||(x=='o')||(x=='u');
}

string reverse_vowels(string s) {
    string ret=s;
    string vowels="";
    for(auto it: s){
        if(check(it))
            vowels += it;
    }
    reverse(vowels.begin(),vowels.end());
    int curr=0;
    for(int i=0;i<s.length();i++){
        if(check(ret[i]))
            ret[i] = vowels[curr++];
    }
    return ret;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = reverse_vowels(s);

    fout << result << "\n";

    fout.close();

    return 0;
}
```

## Question 2: Slash Pattern 

Highest score: - <br>
Lowest score: - <br>
Mean: - <br>
Number of attempts: 0 <br>
Difficulty: Medium

This question was completely original and unique and was designed to assess people’s attention to detail while printing out the pattern. Several variables were needed to solve this question and one needed to analyse the sample outputs well before proceeding to write a good solution.

This problem was solved by considering how spaces have to be printed. The number of spaces printed before each line are changing (hence useful to keep a variable for that). The number of spaces between numbers and slashes also changes so again it is useful to have suitable variables for those spaces. It is important to keep track of the number being printed (c) and incrementing it after printing. The last line has a different format and requires printing of ‘-‘s. It is crucial to be printing the correct amount of '-'s.

Although this question did not have successful submissions during the contest, it was good to see multiple solutions passing all the test cases after the contest. 

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-9/challenges/slash-pattern/editorial

A successful submission by a contestant is shown below:

```python
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'slash_pattern' function below.
#
# The function accepts INTEGER n as parameter.
#
def slash_pattern(n):
    last_row = [i for i in range(2 * n, 3 * n + 1)]
    
    pyramid = []    
    s = ""
    
    for i, num in enumerate(last_row):
        if i != 0:
            s += "-" * (3 if 0 <= num <= 10 else 2)
            
        s += str(num)
    
    pyramid.append(s)
    
    i = 1
    side = True
    size = len(s) - 1
    
    c = 2 * n - 1
    
    if c != 1:
        size -= 1
    
    while not (c == 1 and not side):
        if side:
            s = (" " * i) + "/" + (" " * (size - 2 - i)) + "\\"
        else:
            s = (" " * i) + str(c - 1) + (" " * (size - len(str(c - 1)) - len(str(c)) - i + len(str(c)) - 1)) + str(c)
            c -= 2
        
        i += 1
        size -= 1
        side = not side
        
        pyramid.append(s)
     
    pyramid.append((" " * (size - 1)) + "1")
    
    for l in pyramid[::-1]:
        print(l)

if __name__ == '__main__':
    n = int(input().strip())

    slash_pattern(n)

```
## Question 3: LEU - KGX 

Highest score: 0/40 <br>
Lowest score: 0/40 <br>
Mean: 0/40 <br>
Number of attempts: 2 <br>
Difficulty: Medium 

This question aimed to test proficiency with graphs. It represents a situation that a lot of St Andrews students travel to London would have faced and the question seeks to give students information about all the possible unique routes from St Andrews (Leuchars) to London Kings Cross.

It is useful to use some form of graph representation like an adjacency list in order to solve this problem. DFS traversal was a common approach when trying to solve for all paths from the source to the destination. 

Although this question did not have successful submissions during the contest, it was good to see multiple solutions passing all the test cases after the contest.  There were 2 unsuccessful submissions during the contest and participants did not receive any points. It was expected that user(s) will try to write a print statement and get some points but those test cases were given a 0 weight. 

Designing the test cases for this question was super interesting as the designer had to insure that the graph is a directed acyclic graph. The designer (a train geek) spent time collecting the 3 digit station codes and all stations in all the test cases  are real stations on the Edinburgh - Aberdeen line and the well known East - Coast Main Line (From Edinburgh to London). The designer also ensured that there were no repeated routes when designing test cases and all routes were real stations. 

The larger test cases did have several 1000 different unique ways to get from Leuchars to London and it was good to see that several participants were able to pass all test cases including the large ones after the contest. 

This problem was inspired by the Code Con Challenger Series question "Travel to the West”: https://codecon.bloomberg.com/challenger-series/3902.

LeetCode 797: https://leetcode.com/problems/all-paths-from-source-to-target/ will also useful reference in order to generate all possible paths.

Solution with comments: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-9/challenges/leu-kgx/editorial 

A successful submission by a contestant in Python is given below:

```python
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'calculate_ways' function below.
#
# The function accepts STRING_ARRAY routes as parameter.
#
from collections import defaultdict
def calculate_ways(routes):
    graph = defaultdict(set)
    
    for r in routes:
        start, end = r.split()
        
        graph[start].add(end)
        #graph[end].append(start) #DIRECTED
        
    seen = set()
    
    def dfs(station):
        #print(path)
        ret = []
        
        if station == "KGX":
            return [["KGX"]]
        
        for option in graph[station]:
            if option not in seen:
                seen.add(option)
                
                for route in dfs(option):
                    ret.append([station] + route)
                
                seen.remove(option)
        
        return ret
    
    seen.add("LEU")
    ans = dfs("LEU")
                
    for l in sorted(ans):
        print("->".join(l))
    
    if not ans:
        print("NO ROUTES BETWEEN LEUCHARS AND LONDON KINGS CROSS")

if __name__ == '__main__':
    routes_count = int(input().strip())

    routes = []

    for _ in range(routes_count):
        routes_item = input()
        routes.append(routes_item)

    calculate_ways(routes)
```

As expected, one contestant fell into the expected trap of simply printing that there were no routes for every test case, but such submissions were rewarded with zero points:

```python
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'calculate_ways' function below.
#
# The function accepts STRING_ARRAY routes as parameter.
#

def calculate_ways(routes):
    print("NO ROUTES BETWEEN LEUCHARS AND LONDON KINGS CROSS")

if __name__ == '__main__':
    routes_count = int(input().strip())

    routes = []

    for _ in range(routes_count):
        routes_item = input()
        routes.append(routes_item)

    calculate_ways(routes)
```
