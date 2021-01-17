# Contest 52 Analysis

*Setter: Leaderboard*

## Overall comments

This contest was well done, despite a nasty bug in Q1 that caused confusion for the first 10 minutes, which is regretted. Q2 was the separator as expected. Two users got a perfect mark of 80/80, well done to them.

It's rare that I see solutions that are completely different to what I was expecting, but one user managed to do that for both Q2 and Q3. I'm going to call out Jonathan Yim for pulling that off, well done!

### Overall statistics

Mean = 37.5/80 (46.9%) <br>
Median = 25.3/100 (31.6%) <br>
Mode = 20/80 (25%) <br>
Highest = 80/80 (100%) <br>
Lowest = 4.44/80 (5.6%) <br>
Number of participants = 12

## Q1: Palindromic substrings (20)

*Difficulty: Easy*

### Solution sketch

Get each of the substring, and check whether it's the same as its reverse.

### Statistics

* Mean = 17.41/20 (87%)
* Median = 20/20 (100%)
* Mode = 20/20 (100%)
* Highest score = 20/20 (100%)
* Lowest score = 4.44/20 (22%)
* Number of users = 12

### Comments

First off, I must apologise for the nasty bug in some of the test cases for Q1, which took well over 10 minutes to fix. That was quite embarrassing. What could have happened? Well, my code had the string ``if (sb.toString().equals(sb.reverse().toString()))``. The problem here is that the StringBuilder ``sb`` reverses the entire string instead of simply making a copy, which was my intention. The fix is easy: make sure that a new StringBuilder instance is created: ``if (sb.toString().equals(new StringBuilder(sb.toString()).reverse().toString()))``. I made two contest-wide announcements in a bid to fix it, and fortunately everyone who was supposed to get full points managed to resubmit in time, but nevertheless this mistake of mine was not acceptable.

Back to the contest. This question was done quite well, with solutions that took a manual approach...

```python3
def palindromic_substrings(init_str):
    count = len(init_str)
    
    for i in range(len(init_str)):
        j = i - 1
        k = i + 1
        while j >= 0 and k <= len(init_str) -1:
            if init_str[j] == init_str[k]:
                count += 1
                j -= 1
                k += 1
            else:
                break
        
    
    for i in range(len(init_str)):
        j = i - 1
        k = i
        while j >= 0 and k <= len(init_str) -1:
            if init_str[j] == init_str[k]:
                count += 1
                j -= 1
                k += 1
            else:
                break
    
    return str(count)
 ```
 
... to short solutons that did the work:

```python3
def palindromic_substrings(s):
    # your code goes here!
    
    ans = 0
    
    n = len(s)
    
    for i in range (n):
        for j in range (i + 1, n + 1):
            sub = s[i:j]
            if sub == sub[::-1]:
                ans += 1
    return str(ans)
```

Only two solutions didn't make the cut, and one of them attempted to solve the problem in O(*n*) but didn't succeed because they were not considering "nearby" substrings. The other tried a traditional O(n<sup>2</sup>) solution that failed as well. 
