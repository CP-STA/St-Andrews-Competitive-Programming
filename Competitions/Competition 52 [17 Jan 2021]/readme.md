# Contest 52 Analysis

*Setter: Leaderboard*

Contest link: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-52

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

Only two solutions didn't make the cut, and one of them attempted to solve the problem in O(*n*) but didn't succeed because they were only considering "nearby" substrings. The other tried a traditional O(*n*<sup>2</sup>) solution that failed as well. 

## Q2: Randomised sorting (30)

*Difficulty: Medium*

### Solution sketch

Dynamic programming. Notice that when *n* = 1, there will be *m* sorted integers, each of which consists of the number itself. This represents the base case. Then a bit of pattern recognition would help. Suppose *m* = 3. Then the base cases would be

1 <br>
2 <br>
3 <br>

Suppose we insert 1 to the left of these numbers. Is 11 sorted? Yes. Is 12 sorted? Yes. Is 13 sorted? Yes. That means that there are 3 sorted numbers when the first digit is 1. Now let's go to the second number. Is 21 sorted? No. Is 22 sorted? Yes. Is 23 sorted? Yes. Now last one. Only 33 is sorted. Notice that the number of sorted numbers is 3 + 2 + 1 = 6. In particular, note that

3 = number of sorted numbers when *n* = 1 <br>
2 = number of sorted numbers when *n* = 1 AND the first digit being 2 <br>
1 = number of sorted numbers when *n* = 1 AND the first digit being 3

This means that we can utitlise a 2-D DP table, with (i, j) being the number of sorted numbers when *m* = *i* and *n* = *j*. To speed computation, we can maintain a variable ``sum`` that represents the number of sorted numbres when *n* = *j* - 1.
### Statistics

* Mean = 20.42/30 (68.1%)
* Median = 20.75/30 (69.2%)
* Mode = 30/30 (100%)
* Highest score = 30/30 (100%)
* Lowest score = 10.5/30 (35%)
* Number of users = 6

### Comments

As expected, this question separated most constantants. Nevertheless, half of the users that attempted got a full score:

```c++
#define MOD 1000000007
typedef long long int ll;


ll mem[501][501];

ll h(int m, int n) {
    if (n == 0) return 1;
    
    if (mem[m][n] != -1) return mem[m][n];
    
    ll a = 0;
    for (int i = m; i >= 1; i--) {
        a += h(i, n - 1);
        a %= MOD;
    }
    return mem[m][n] = a;
}

int randomised_sorting(int m, int n) {
    memset(mem,-1,sizeof(mem));
    
    return h(m, n);

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));

    int m = stoi(first_multiple_input[0]);

    int n = stoi(first_multiple_input[1]);

    int ans = randomised_sorting(m, n);

    fout << ans << "\n";

    fout.close();

    return 0;
}
```

Note that it's essential that the dynamic programming table is MODed. This is because the numbers quickly become illogically large (I've seen some go beyond 500 digits), and no integer datatype can handle it (not even Python's 64-bit int). Alternatively a large number library such as Java's BigInteger can be used (this was the approach taken by the reference solution). Users that didn't got no more than 35%.

One user (Jonathan Yim) came up with a very nice alternative (comments written by him):

```python3
def randomised_sorting(m, n):
    # edge cases: 
    if m == 1:
        return 1
    elif n == 1: 
        return m
    
    
    # when m=3, incrementing n gives us the triangle numbers
    # when m=4, incrementing n gives us the tetrahedral numbers
    # let's try looking into these: https://en.wikipedia.org/wiki/Figurate_number
    # it seems that this gives us essentially an nCr of (n+m-1, m-1)
    
    # define factorial with modulo
    def fac(num): 
        return math.factorial(num)
    
    # define nCr:
    def combinations(n, r):
        # print( fac(n) )
        # print( fac(r) * fac(n-r) )
        # print( fac(n) / (fac(r) * fac(n-r)) )
        return int( (fac(n) / (fac(r) * fac(n-r)))  % (pow(10, 9) + 7) )
    
    return (combinations(n+m-1, m-1))
 ```
 
This makes use of combinatorial properties to get the result. While his solution is mathematically accurate, the problem here is that ``math.factorial`` cannot properly handle very large integers, which was the thorn with this solution. Regardless, it's a very nice solution. I had thought of a connection with chromatic polynomials (or isomorphisms), but couldn't get a lead from there. The Figurate number was the key connection I was missing. Well done.

For those interested in an alternative path, a very interesting alternative is to make use of Python's ``lru_cache``, which is a clever way of memoization. While it is a bit slower than traditional DP, it's much simplier. The below solution got all but one case - this is a case where PyPy would get fewer points due to the stricter time limit.

```python3
from functools import lru_cache    

def randomised_sorting(m, n):
    c = 0
    mod = 10 ** 9 + 7
    @lru_cache(None)
    def helper (prev, index):
        if index >= n:
            return 1
        res = 0
        for i in range (prev, m + 1):
            res = res + helper(i, index + 1)
        return res % mod
    return helper(1, 0)
        
m, n = map(int, input().split())
print(randomised_sorting(m, n))
```

## Q3: Binary tree distribution (30)

*Difficulty: Medium*

### Solution sketch

BFS-based DP simulation, just do as the problem says.

### Statistics

* Mean = 27.3/30 (90.8%)
* Median = 30/30 (100%)
* Mode = 30/30 (100%)
* Highest score = 30/30 (100%)
* Lowest score = 19/30 (63.3%)
* Number of users = 4

### Comments

This problem was well done, with most effectively simulating the problem using BFS/DP (as with Q2, ``lru_cache`` would work as well and can get full points):

```c++
double left(double val, double d) {
    return val / d;
}

double right(double val, double d) {
    return val - left(val, d);
}

int binary_tree_distribution(int amt, int d, int ansdepth, int ansnode) {
    vector<vector<double>> tr(ansdepth + 1);
    tr[1].push_back(amt);
    for (int i = 2; i <= ansdepth; i++) {
        tr[i] = vector<double>(i);
        for (int j = 0; j < i; j++) {
            if (j > 0) {
                tr[i][j] += right(tr[i - 1][j - 1], d);
            }
            
            if (j < i - 1) {
                tr[i][j] += left(tr[i - 1][j], d);
            }
        }
    }
    
    return (int)tr[ansdepth][ansnode - 1];
}
```

However, here again we see an unorthodox solution by Jonathan Yim that (this time) got full marks:

```python3
def binary_tree_distribution(amt, d, ansdepth, ansnode):
    # we're looking at a binomial distribution here, where the probability of an occurrence is 1/d
    
    # define factorial with modulo
    def fac(num): 
        return math.factorial(num)
    
    # define nCr:
    def comb(n, r):
        return int( (fac(n) / (fac(r) * fac(n-r))) )
    
    p = 1/d
    depth = ansdepth - 1
    node = ansnode - 1
    
    # then, amt * (depth node) * p^(depth - node) * (1 - p)^(node)
    return int( amt * comb(depth, node) * pow(p, depth - node) * pow(1-p, node) )
```

This reminded me of the binomial distribution. What exactly is going on? This solution basically notices the pattern to Pascal's triangle, and uses that to deduce a relationship with the Binomial Distribution. In this words,

> in the diagrams you drew for the example questions i saw the 1-2-1, 1-3-3-1 and 1-4-6-4-1 distribution and that reminded me of pascal's triangle. then i kind of derived the connection as pascal's triangle is essentially binomial distribution where the probability is 0.5

A solution like this took me completely by surprise - well done again!
