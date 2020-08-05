# Contest 28 Analysis

*Setter: Leaderboard*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-28
## Overall comments

While the participation was disappointing again, compared to previous contests of mine, two things that I wanted to change included

* an easier Q1
* a harder Q3 - the high average caliber makes this necessary

And I think both of these aims have been managed pretty well. Unfortunately Q2 had serious bugs, and I apologise for them.

### Statistics

* Mean = 36/100
* Median = 22.35/100
* Mode = null
* Highest score = 60/100
* Lowest score = 19/100
* Number of users with a submission = 7

## Q1 - The 1/N sum (20)

### Statistics

* Mean = 19.85/20 (99.3%)
* Median = 20/20 (100%)
* Mode = 20/20 (100%)
* Highest score = 20/20 (100%)
* Lowest score = 19/20 (100%)
* Number of users = 7

*Difficulty: Easy*

### Solution sketch

A straightforward loop that can easily be done in O(*n*) time (technically it's closer to exponential in *k* but the value is small enough so...).

### Comments

This question was intended to be very straightforward, and indeed it was, with people finishing off within two minutes:

```python
def the_1_by_N_sum(k):
    
    lim = pow(10, 7)
    s = 0
    for i in range (1, lim):
        s += 1/i
        if s >= k:
            return i
```
Well, all except one, who used a surprisingly convoluted solution that passed 95% of test cases with the rest running out of time:

```python
def the_1_by_N_sum(k):
    # your code goes here!
    n = int(2**((k-1)*2))
    x = math.log(n) + 0.5772156649015328606065120900824024310421 + 1/(2*n) - 1/(12*(n**2))
    while n>0:
        if x < k:
            return n+1
        else:
            x-=1/n
            n-=1
```

Turns out that user made use of bizzare techniques in real analysis. First off, how *x* is represented. 0.5772156649015328606065120900824024310421 is the *Euler-Mascheroni* constant γ (those who have taken MT2502 might be familiar with it). This is basically 

<img src="http://www.sciweavers.org/tex2img.php?eq=%20%5Cint_1%5E%5Cinfty%20%20%5Cfrac%7B1%7D%7Bx%7D%20dx%20-%20%20%5Csum_%7Bi%20%3D%201%7D%5E%5Cinfty%20%5Cfrac%7B1%7D%7Bx%7D&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0" align="center" border="0" alt=" \int_1^\infty  \frac{1}{x} dx -  \sum_{i = 1}^\infty \frac{1}{x}" width="129" height="51" />

That explains the approach used by the user, but was overkill for this one.

## Q2 - Nodes and rectangles (40)

### Statistics

* Mean = 0/20 (0%)
* Median = 0/20 (0%)
* Mode = 0/20 (0%)
* Highest score = 0/20 (0%)
* Lowest score = 0/20 (0%)
* Number of users = 3

*Difficulty: Medium*
### Solution sketch

Basically a H-tree. Hence the number of nodes in such a configuration would be 2<sup>2n - 3</sup>, and there are (2n - 1) nodes in each row and column, hence giving (2n - 1)<sup>2</sup> nodes in total. Hence the probability is 2<sup>2n - 3</sup>/(2n - 1)<sup>2</sup>.

### Comments

The question as given was arguably confusing, which led to confusion on how the conditions had to be applied (as one user claimed that a more optimal non-isomorphic configuration could be had than what was given). The confusion seemed from handling trees of depth 5 for instance, as it could be observed a H-tree of depth *n* has nodes in powers of 4. Hence the first three test cases had faulty data, but no one quite got headway into the others either. This confusion is regretted.

## Q3 - Search query rankings (40)

### Statistics

* Mean = 28.24/40 (70.6%)
* Median = 35.3/40 (88.3%)
* Mode = 40/40 (100%)
* Highest score = 40/40 (100%)
* Lowest score = 2.35/40 (5.9%)
* Number of users = 4

*Difficulty: Hard*

### Solution sketch

First use dynamic programming to calculate the Levenshtein/edit distance between a pair of words (the Wikipedia article linked in the question provides helpful pseudocode). Then use any appropriate data structure to sort them by edit distance and print the output (the reference solution used a max heap, but standard O(*n* log *n*) sorting would also suffice).

### Comments

Being the first "hard" question I have given in some time, I was expecting this to be tricky, but for a Q3, it was well done, with two perfect solutions and one that got 75% of the test cases. Nearly all employed a standard DP approach, including this C++ solution that shockingly took a reported 0.06 sec as the maximum time taken (not sure if this is a bug):

```c++
int ld(string s, string t) {
    int n = s.length();
    int m = t.length();
    if (n == 0) {
        return m;
    } else if (m == 0) {
        return n;
    }
    int matrix[m + 1][n + 1];
    for (int i = 0; i <= n; i++) {
        matrix[0][i] = i;
    }
    for (int i = 0; i <= m; i++) {
        matrix[i][0] = i;
    }
    for (int c = 1; c <= n; c++) {
        for (int r = 1; r <= m; r++) {
            int v_a = matrix[r-1][c] + 1;
            int v_b = matrix[r][c-1] + 1;
            int v_c = matrix[r-1][c-1] + ((s[c-1] != t[r-1]) ? 1 : 0);
            matrix[r][c] = min(v_a, min(v_b, v_c));
        }
    }
  /*  for (int i = 0; i < m + 1; i++) {
        for (int j = 0; j < n + 1; j ++) {
            cout << matrix[i][j] << " ";
        }
        cout << "\n";
    }*/
    return matrix[m][n];
}

struct calculatedStr {
    string s;
    int cd;
    bool operator<(calculatedStr cs) {
        if (cd < cs.cd) {
            return true;
        } else if (cd == cs.cd) {
            return (s < cs.s);
        }
        return false;
    }
};

vector<string> search_query_rankings(string target, vector<string> words) {
    // Find the distance for each one 
    vector<calculatedStr> all_cs;
    for (int i = 0; i < words.size(); i++) {
        calculatedStr new_cs;
        new_cs.s = words[i];
        new_cs.cd = ld(target, words[i]);
        all_cs.push_back(new_cs);
       // cout << "ld " << target << " " << new_cs.s << " = " << new_cs.cd << "\n";
    }
    sort(all_cs.begin(), all_cs.end());
    vector<string> ans;
    for (int i = 0; i < all_cs.size(); i++) {
        ans.push_back(all_cs[i].s);
    }
    return ans;
}
```

The only user that attempted and didn't get much tried to work it out using recursion, which while interesting had a horrible time complexity and would fail for all but the most trivial test cases.

