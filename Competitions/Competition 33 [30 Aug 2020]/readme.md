# Contest 33 Analysis

*Setter: Leaderboard*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-33
## Overall comments

While not a lot took part again, the contest appeared to be overall harder compared to before, with Q3 surprisingly causing some to struggle. However, the averages were still stable, probably due to Q2 getting non-zero scores unlike the previous contest.

Also there were an unusually high number of runtime errors being reported, and the reason for that isn't very clear, but it did not appear to be a bug with the questions themselves.

### Statistics

* Mean = 33.18/90 (36.9%)
* Median = 30.5/90 (33.9%)
* Mode = null
* Highest score = 56.17/90 (62.4%)
* Lowest score = 8.17/90 (9.1%)
* Number of users with a submission = 7

## Q1 - Stonks (20)

### Statistics

* Mean = 16.83/20 (84.2%)
* Median = 20/20 (100%)
* Mode = 20/20 (100%)
* Highest score = 20/20 (100%)
* Lowest score = 1/20 (5%)
* Number of users = 6

*Difficulty: Easy*

### Solution sketch

Loop to check if we get a case where we get ``A[i] < A[i + 1] < A[i + 2] < A[i + 3]`` but not ``A[i] < A[i + 1] < A[i + 2] < A[i + 3] < A[i + 4]``.

### Comments

This question was meant to be an easy start with a fun twist (notice the work "stonks" which is a misspelling of "stocks"), and there were correct solutions within the first five minutes:

```python3
n = int(input())

for i in range(n):
    arr = list(map(int, input().split()))
    
    sz = len(arr)
    cur = arr[0]
    ma = 0
    cur_i = 0
    for j in range(1,sz):
        if (arr[j] > cur):
            cur_i+=1
        else:
            cur_i = 0
        ma = max(ma, cur_i)
        cur = arr[j]
    
    if ma == 3:
        print("NICE")
    else:
        print("NOT NICE")
```

Only one user was beset with weird runtime errors that wasn't clear looking at the code.

## Q2 - Linear systems (35)

### Statistics

* Mean = 6.53/35 (18.7%)
* Median = 8.17/35 (23.3%)
* Mode = null
* Highest score = 8.75/35 (25%)
* Lowest score = 1.17/20 (3.3%)
* Number of users = 5

*Difficulty: Medium*
### Solution sketch

First get x<sub>n</sub> and y<sub>n</sub> by multiplying the linear system. Then for small *k*, use iteration to get x<sub>n</sub> and y<sub>n</sub> and divide. 

This is understandably not going to work when *k* can be as large as 10<sup>16</sup>. In that case, note that we have

x<sub>n</sub> = ax<sub>n - 1</sub> + by<sub>n - 1</sub><br>
y<sub>n</sub> = cx<sub>n - 1</sub> + dy<sub>n - 1</sub>

Then using division, we get

(x<sub>n</sub>/y<sub>n</sub>) = (ax<sub>n - 1</sub> + by<sub>n - 1</sub>)/(cx<sub>n - 1</sub> + dy<sub>n - 1</sub>)

At this point it would help to realise that x<sub>n</sub>/y<sub>n</sub> would actually be a convergent sequence. With that in mind, divide both sides of the RHS by y<sub>n - 1</sub>. This gives us

(x<sub>n</sub>/y<sub>n</sub>) = (ax<sub>n - 1</sub>/y<sub>n - 1</sub> + by<sub>n - 1</sub>/y<sub>n - 1</sub>)/(cx<sub>n - 1</sub>/y<sub>n - 1</sub> + dy<sub>n - 1</sub>/y<sub>n - 1</sub>)

This can be simplied to

(x<sub>n</sub>/y<sub>n</sub>) = (ax<sub>n - 1</sub>/y<sub>n - 1</sub> + by<sub>n - 1</sub>/y<sub>n - 1</sub>)/(cx<sub>n - 1</sub>/y<sub>n - 1</sub> + dy<sub>n - 1</sub>/y<sub>n - 1</sub>)

or

(x<sub>n</sub>/y<sub>n</sub>) = (ax<sub>n - 1</sub>/y<sub>n - 1</sub> + b)/(cx<sub>n - 1</sub>/y<sub>n - 1</sub> + d)

Notice that since we're taking n to infinity, the limital value of x<sub>n</sub>/y<sub>n</sub> and x<sub>n - 1</sub>/y<sub>n - 1</sub> will be the same. Now make the substitution x<sub>n</sub>/y<sub>n</sub> = x<sub>n - 1</sub>/y<sub>n - 1</sub = t. Substituting in the previous equation, we get

t = (at + b)/(ct + d)

This can be simplified as a quadratic:

t(ct + d) = at + b <br>
ct<sup>2</sup> + dt = at + b <br>
ct<sup>2</sup> + (d - a)t - b = 0

The quadratic formula can be used to get t, and hence the limital value of x<sub>n</sub>/y<sub>n</sub> which would be the same irrespective of k after a certain point (which is pretty small in practice, around 15 - 30). We can check for validity by checking the discriminant (to prevent square root of negative number errors).

## Comments

This proved to be quite challenging though reasonably approaching, with no contestant getting the optimal solution which contriubted to the low maximum score for this question. Most submission either recursively or iteratively ran through x<sub>n</sub> and y<sub>n</sub>, which worked mostly for the lower test cases but crashed when going any higher:

```python3
def linear_systems(a, b, c, d, k):
    
    arr = [(1, 1)]
    for i in range (1, k + 1):
        next_x, next_y = (a * arr[-1][0] + b * arr[-1][1]), (c * arr[-1][0] + d * arr[-1][1])
        arr.append((next_x, next_y))
    return round(arr[-1][0]/arr[-1][1], 8)
```

Users of other languages usually did less well even after multiple attempts - as they used merely ``long`` which would not suffice for the large values being called for here (``long double`` is a better choice, or ``BigInteger`` for Java).

A user complained that requiring rounding is not easy and can introduce problems. In the future I'll consider using the custom checker to allow values within a certain range to avoid running into potential inaccuracy problems in the future.
## Q3 - Filling milk (35)

### Statistics

* Mean = 16.43/35 (46.9%)
* Median = 9.63/35 (27.5%)
* Mode = 4.67/35 (13.3%)
* Highest score = 35/35 (100%)
* Lowest score = 4.67/35 (13.3%)
* Number of users = 6

### Solution sketch

Fractional knapsack - greedy with ordering by (profit/capacity).

### Comments

Nearly all used the right idea, but many got stuck with weird wrong answer or runtime errors. Only two users got all the way to a full score:

```c++
int filling_milk(vector<int> capacities, vector<int> profit, int limit) {
    int n= profit.size();
    vector<pair<double, int>> A(n);
    for (int i = 0; i<n;i++) {
        A[i] = {(double)profit[i]/(double)capacities[i], i};
    }
    
    sort(A.rbegin(), A.rend());
    double re = 0;
    for (int i= 0; i < n; i++) {
        if (capacities[A[i].second] <= limit) {
            re += profit[A[i].second];
            limit -= capacities[A[i].second];
        }else {
            re += ((double)limit/(double)capacities[A[i].second]) * (double)profit[A[i].second];
            break;
        }
    }
    return (int) re;
}
```

However, one user used a one-line trap to get nearly half the points right - this wasn't something I had anticipated and it was surprising such a solution did so well consdering that the test cases are computer-generated. That user also thought it was DP - but that's for the 0 - 1 knapsack problem, not this (because taking a fraction of an item is allowed).

```python3
def filling_milk(capacities, profit, limit):
    return sum(profit)
```
