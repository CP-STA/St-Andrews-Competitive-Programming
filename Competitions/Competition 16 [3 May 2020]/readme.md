# Analysis for Contest 15

*Setter: Leaderboard*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-15

## Overall notes

This contest went well, despite the disappointing number of users taking part (8) considering that many more took part in the last few contests. This was the first contest to disable partial marking, which was partially due to Q3's structure being unsuitable, and a minor penalty of 3 minutes was applied for any incorrect submission. That itself was close to making a difference in the ranks - a couple of minutes less and the second placed contestant would have won if their penalties were removed. <br> Unfortunately, a significant number of users got zeros as well, and this contributed to the average being in line with other contests despite the contest otherwise being very straightforward.

There was an error in the constraints for Q3. While that did not affect correctness, it did unfortunately cause a couple of users' submissions to go wrong, as they tended to separate by numbers. This error is regretted.

It should be noted that every question was equiscored regardless of the difficulty, and HackerRank gave one point for each question, and hence we only give percentages for the statistics below.
### Statistics

Mean: 37.5% <br>
Median: 50% <br>
Mode: 66.7% <br>
Highest score: 66.7% <br>
Lowest score: 0% <br>
Number of users: 8

## Q1: FizzBuzz Reloaded 2

Mean: 71.4% (5/7) <br>
Difficulty: Easy

This was a striaghtfoward question meant as a sequel to the [first version](https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-1/challenges/fizzbuzz-reloaded-a) that came in Contest 1. While this question is certanly harder than that, it was still meant to be straightforward, given that it could be finished off in a few lines. 

It seems however that this question was harder than expected, as it took quite a few attempts for some to get it. Most users did this by restricting the search range to (n, n - k), that is a top down approach:

```python
def fizzbuzz_reloaded_2(n):
    if n < 3:
        return n
    
    res, max_a_of_t_over_t = n, float('-inf')
    for i in range (n, n - 16, -1):
        if i < 3:
            break
        if i % 3 == 0 or i % 5 == 0:
            if a(i)/i > max_a_of_t_over_t:
                res = i
                max_a_of_t_over_t = a(i)/i
                
                
    return res
```

One user followed the approach of the reference solution and gave a bottom-up approach, brute-forcing for the first 15 numbers and giving a one-line solution for the rest:

```c++
long fizzbuzz_reloaded_2(long n) {
    // your code goes here!
    if (n < 15) {
        int l = 0;
        float m_at = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                l += 4;
            }
            if (i % 5 == 0) {
                l += 4;
            }
            float n_at = ((float) l) / ((float) i);
            if (n_at >= m_at) {
                m_at = n_at;
                ans = i;
            }
        }
        return ans;
    } else {
        return (15 * (n / 15));
    }
    //return max ((5 * (n / 5)), (3 * (n / 3)));
}
```

However, as one user demostrated, it's possible to hardcode even when (n < 15), effectively providing a constant-time solution irrespective of *n*:

```python
def fizzbuzz_reloaded_2(n):
    if n >= 15:
        return 15*(n//15)
    if n >= 6:
        return 6
    if n >= 5:
        return 5
    if n >= 3:
        return 3
    return n
```

It is worth understanding why exactly that works. Note that our goal is to maximise 4/n ([n/3] + [n/5]). Naturally the maximum value of [n/3] + [n/5] is n/3 + n/5, but that only works when [n/3] = n/3 and [n/5] = n/5. That means that *n* has to be a multiple of 3 and 5, that is 15. With that in mind, the maximum value becomes 4/n (n/3 + n/5) = 4 (1/3 + 1/5) = 32/15. And that's true for *all* multiples of 15, and hence we just need to find the closest *t* to *n* that is a multiple of 15.

## Q2: Rendering F-SQL

Mean: 50% (3/6) <br>
Difficulty: Medium

This is a straightforward problem that emulated a database and asked users to implement a simplified set of commands for it. The main challenge was getting all of what the question asked properly - and that hindered many from getting the points. 

Most users who did get it (a couple after the end of the contest) used some form of a list or dictionary and opted to sort separately for every SELECT query:

```python
n = int(input())

d = {}
for i in range(n):
    line = input().replace("::", ":")
    line = line.split(":")
    
    if line[0] == "ADDROW":
        if line[1] not in d:
            d[line[1]] = [line[2], line[3]]
        print("NULL")
    elif line[0] == "SELECT":
        for j in sorted(d, key=lambda x : int(x)):
            print("  ".join([j, d[j][0], d[j][1]]))
    elif line[0] == "REMOVE":
        if line[1] in d:
            del d[line[1]]
        
        print("NULL")
    elif line[0] == "QUERY":
        if line[1] not in d:
            print(-1)
        else:
            j = line[1]
            print("  ".join([j, d[j][0], d[j][1]]))
```

However, if we strictly look at time complexities, a better idea would have been to use a sorted data structure (like TreeMap in my reference solution) considering that we would avoid the O(n log n) sorting performed in every SELECT query. That being said, this wasn't a problem in the end, mainly because of the test case generator which meant that there were a lot of DELETE operations as well (which most did linear-time as well). Also it seems that the overhead of TreeMap was higher than expected, as I saw several Python solutions easily beat my Java reference solution.

## Q3: Equation basis

Mean: 33.3% (1/3) <br>
Difficulty: Medium

This was a problem that asked users to determine whether a series of equations is a basis or not, and even if MT2501 wasn't taken (where the concept of basis is taught), the question gave enough indication on what was needed to be done. One of the main challenges with this problem (which was intentional) was to handle the tricky input, which I would personally describe as "pesky". There were different approaches taken - those that separated irrespective of what the number went fine - unfortunately a typo in the constraints led some users to separate by the first digit of the number (as it was originally given as -5 to 5). Such answers ended up getting run-time errors on a few test cases.

There were a couple of approaches taken by users (again some of which came after the contest). The most common approach was to take determinants: if Ax = 0, then |A| = 0 implies that the system is <i>not </i>a basis. This is computationally intensive (hence the constraints), but my reference solution also did this and I did not require more efficient methods for this problem:

```java
import java.io.*;
import java.util.*;

public class Solution {

         public static void main(String[] args) {
          /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
          int[][] m = readInput();
          
          if(determinantOf(m) == 0)
               System.out.println("0");
          else
               System.out.println("1");
     }
     static int[][] readInput()
     {
         
              
               Scanner scanner = new Scanner(System.in);
               int length = scanner.nextInt();
               scanner.nextLine();
               int[][] m = new int[length][length];
               int r = 0, c = 0;
               while(scanner.hasNext())
               {
                    String inputStr = scanner.nextLine();
                    String[] splitted = inputStr.split("\\+|\\-|=");
                  
                   c = 0;
                    inner: for(int i = 0; i < splitted.length; i++)
                    {
                         
                         if(splitted[i].equals("") || splitted[i].equals("0"))
                              continue inner;
                         if(isNum(splitted[i].substring(0, splitted[i].length() - 1)))
                         {
                             
                              if(i == 0)
                                  m[r][c] = Integer.valueOf(splitted[i].substring(0, splitted[i].length() - 1));
                              else
                              {
                                   String sign = inputStr.substring(inputStr.indexOf(splitted[i].charAt(splitted[i].length() - 1)) - splitted[i].length(), inputStr.indexOf(splitted[i].charAt(splitted[i].length() - 1))  - splitted[i].length() + 1);
                                   if(sign.equals("+"))
                                        m[r][c] = Integer.valueOf(splitted[i].substring(0, splitted[i].length() - 1));
                                   else if(sign.equals("-"))
                                        m[r][c] = -1 * Integer.valueOf(splitted[i].substring(0, splitted[i].length() - 1));
                              }
                              c++;
                         }
                    }
                    r++;
               }
               return m;
          
     }
     static boolean isNum(String s)
     {
          try{
               int i = Integer.valueOf(s);
               return true;
          }
          catch(Exception e)
          {
               return false;
          }
     }
     static int determinantOf(int[][] input)
     {
          if(input.length == 2)
               return input[0][0] * input[1][1] - input[0][1] * input[1][0];
          int sum = 0;
          for(int i = 0; i < input.length; i++)
          {
               if(i % 2 == 0)
                    sum += input[0][i] * determinantOf(submatrix(input, i));
               else
                    sum -= input[0][i] * determinantOf(submatrix(input, i));
          }
          return sum;
     }
     static int[][] submatrix(int[][] input, int column)
     {
          int[][] toReturn = new int[input.length - 1][input.length - 1];
          int cTr = 0, rTr = 0;
          for(int r = 1; r < input.length; r++)
          {
               cTr = 0;
               for(int c = 0; c < input[r].length; c++)
               {
                    if(c == column)
                         continue;
                    toReturn[rTr][cTr] = input[r][c];                
                    cTr++;
               }
               rTr++;
          }
          return toReturn;
     }
    }
```

However, the highlight was one excellent submission during the contest, which used a different approach. Note that all we want is to find out whether the determinant is zero or not. Rather than finding |A|, it suffices to find rank(A). If rank(A) < n, then that implies that we could find a pair of linearly dependent rows (that is, |A| = 0). This is much more efficient as it does not require recursion.

```python
import re 

eps = 1e-9
def matrix_rank(A):
    n = len(A)
    rank = n
    row_used = [False for i in range(n)]
    for i in range(n):
        for j in range(n):
            if not row_used[j] and abs(A[j][i]) > eps:
                break
        else:
            rank -= 1
            continue
        row_used[j] = True
        for k in range(i+1, n):
            A[j][k] /= A[j][i]
        for k in range(n):
            if k!=j and abs(A[k][i]) > eps:
                for l in range(i+1, n):
                    A[k][l] -= A[j][l]*A[k][i]
    return rank
        
        
n = int(input())

terms = []
for i in range(n):
    eqn = input()[:-2]
    eqn = re.split(r"[a-z]", eqn)[:n]
    terms.append(list(map(int, eqn)))
    
if matrix_rank(terms) != n:
    print(0)
else:
    print(1)
```
