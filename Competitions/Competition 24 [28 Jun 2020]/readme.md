# Competition 24 Analysis

*Setter: Leaderboard*

## Overall notes

The participation in this one was disapponting again, with only 6 making a submission. Equally frustrating was that some users apparently made an effort but never submitted them (one giving an excuse that they thought it would be fun to do in C, while another trying to use a module that would work in PyCharm but not in HackerRank).

As with my last contest (Contest 20), this contributed to the statistics being simply brutal. Admittedly the contest was straightforward in that while Q2 and Q3 tested tricky concepts, it was a cakewalk for those who knew what to do.

### Statistics

* Mean = 62.4/100
* Median = 71.7/100
* Mode = null
* Highest score = 100/100
* Lowest score = 1.13/100
* Number of users with a submission = 6

## Q1: Converting number systems (30)

### Statistics

* Mean = 21.7/30 (72.3%)
* Median = 27.2/30 (90.6%)
* Mode = 30/30 (100%)
* Highest score = 30/30 (100%)
* Lowest score = 1.13/30 (3.8%)
* Number of users = 6

*Difficulty: Easy*

This was meant to be a straightforward and a useful real-life question (especially in the Indian subcontinent) that wouldn't require any specialist knowledge of data structures, but still ended up being tricky to work out (perhaps the trickiest for some). Most users did the expected way of trying to first determine the number format.

However a smarter idea (which is done by the reference solution) to determine the format is to check the 7th from the last character - as that's the earliest character where they are *sure* to differ:

```python3
def converting_number_systems(number):
    # your code goes here!
    if len(number) < 7:  # no difference
        return number
    indian = number[-7] == ','
    number = number.replace(',', '')
    if indian:
        i = len(number) % 3
        
        if i == 0:
            i = 3
            
        while i<len(number)-1:
            number = number[:i] + ',' + number[i:]
            i+=4
    else:
        i = (len(number)-3) % 2
        
        if i == 0:
            i = 2
        
        while i<len(number)-4:
            number = number[:i] + ',' + number[i:]
            i+=3
            
        number = number[:-3] + ',' + number[-3:]
        
    return number
```

That being said, a few users found this tricker than expected (partially due to the format perhaps being unfamiliar, though enough guidance was given to help them understand what precisely the differences were).

## Q2: Recursive mergesort (35)

### Statistics

* Mean = 26.3/35 (75%)
* Median = 35/35 (100%)
* Mode = 35/35 (100%)
* Highest score = 35/35 (100%)
* Lowest score = 0/35 (0%)
* Number of users = 4

*Difficulty: Medium*

This was intended to be a tricky recursion question that tested contestants' ability to understand a recursion algorithm for sorting properly, and apply that to sorting numbers in reverse. I expected this to be tricky partially because sorting is something which most would just use their language's library to do (like Collections.sort), and such an approach would fall flat for this question. However, all but one of the contestants that attempted this question got full score (which is partially due to the high average caliber of this contest).

As expected, most of them did classic mergesort as expected, and also knew how to adapt it to sort them in reverse:

```python
n = int(input())
arr = []
for i in range (n):
    arr.append(int(input()))
    
def mergeSort(arr): 
    if len(arr) != n:
        for i in range (len(arr)):
            print(arr[i], end = " ")
        print()
        print()
    if len(arr) > 1: 
        
        mid = len(arr)//2 
        L = arr[:mid] 
        R = arr[mid:] 
        mergeSort(L) 
        mergeSort(R) 
  
        i = j = k = 0
          
        while i < len(L) and j < len(R): 
            if L[i] > R[j]: 
                arr[k] = L[i] 
                i += 1
            else: 
                arr[k] = R[j] 
                j += 1
            k+= 1
          
        while i < len(L): 
            arr[k] = L[i] 
            i += 1
            k += 1
          
        while j < len(R): 
            arr[k] = R[j] 
            j += 1
            k += 1
        if len(arr) != n:
            for i in range (len(arr)):
                print(arr[i], end = " ")
            print()
            print()
mergeSort(arr)
for i in range (len(arr)):
    print(arr[i], end = " ")
```

Overall, a well-answered question, except for a poor contestant whose solution appeared to be incomplete as it was still printing debug information and segfaulted on all test cases but the sample.

## Q3: Q!bert Reloaded 1 (35)

* Mean = 34.9/35 (99.6%)
* Median = 35/35 (100%)
* Mode = 35/35 (100%)
* Highest score = 35/35 (100%)
* Lowest score = 34.4/35 (98.3%)
* Number of users = 4

*Difficulty: Medium*

Another question with insanely high statistics (at least for a Q3!), this question asked users to determine the most optimal path to traverse through a triangular board. All of them realised that plain DFS would not work at all for this problem, and hence they all used some form of dynamic programmming (genreally top-down tabulation). The implementation was also done well by all four users that attempted this problem and is straightforward to execute:

```c++
int dp[1505][1505];
int A[1505][1505];

int qbert_reloaded_1(vector<int> arr) {
    int n = arr.size();
    int ind = 0, c = 0;
    while (ind < n) {
        for (int i = 0; i <= c; i++) {
            A[c][i] = (arr[ind++]);
        }
        c++;
    }
    
    memset(dp, 0, sizeof(dp));
    int d = c;
    dp[0][0] = A[0][0];
    for (int i = 1; i < d; i++) {
        for (int j = 0; j <= i; j++) {
            if (j > 0) dp[i][j] = max(dp[i][j], dp[i-1][j-1] + A[i][j]);
            if (j < i) dp[i][j] = max(dp[i][j], dp[i-1][j] + A[i][j]);
        }
    }
    int ans = 0;
    for (int i = 0; i < d; i++) {
        ans = max(ans, dp[d-1][i]);
    }
    return ans;
}
```

The reference implementation used a N*(2N - 1) board to properly represent the triangular board (with spaces), but this can be reduced to N*N (or even N(N + 1)/2 if really needed, using a tree for example).

There was a small bug wherein the upper bound of the constraints was incorrectly mentioned as d = 1000 instead of d = 1500. A user alerted me in time as his code was segfaulting due to his hardcoding the array size. This minor bug is regretted.