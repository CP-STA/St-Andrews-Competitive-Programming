# Contest 42 Analysis

*Setters: Leaderboard and Kanishk Ali Khanna*

Link to challenges: https://www.hackerrank.com/contests/competitive-programming-st-andrews-beta-contest-42

## Overall comments

This contest was historic in that it was the first ever contest to include prizes for the top three contestants (courtesy of STACS' Hack the Bubble contest). However, only 7 contestants attempted the contest, which was lower than expected.

Leaderboard (who is also writing this analysis) wrote Q1, and Kanishk wrote the other two, but those questions were independently tested to verify correctness.

### Overall statistics

Mean = 42.2/100 <br>
Median = 26.18/100 <br>
Mode = 20/100 <br>
Highest = 99/100 <br>
Lowest = 20/100 <br>
Number of participants = 7

### Cutoffs for prizes

Any score beyond 20 was enough, and a score of 20 would also enough with a very good tiebreak (which was important as the mode is 20).

## Q1: Matrix traces (19)

*Difficulty - Easy*

### Solution sketch

Loop around the main diagonal of the matrix, adding the values in the way.

### Statistics

* Mean = 19/19 (100%)
* Median = 19/19 (100%)
* Mode = 19/19 (100%)
* Highest score = 19/19 (100%)
* Lowest score = 19/19 (100%)
* Number of users = 7

### Comments

This was meant to be a "gimme" problem, considering that past contests (like Contest 38) often had Q1 that ended up being harder than usual, and I wanted everyone to get something right (to the extent of inserting a hint on the comments). This aim was achieved, as everyone got full points on the question.

All solutions just did what was asked on the tin, like the below:

```java
public static int matrix_traces(List<List<Integer>> arr) {
    
        int sum = 0;
        for(int i = 0 ; i < arr.size() ; i++) {
                sum += arr.get(i).get(i);
        }
        return sum;

    }
```

## Q2: True False Assignments (35)

*Difficulty - Medium*

### Solution sketch

The question is essentially asking to find all possible T/F combinations, and there are 2<sup>n</sup> combinations for given *n*. See the comments for more information. One way of doing it is to find the bitcount of each number from 0 to *n*, and assign F to '0' and T to '1'. Looping will get the desired result, with no need for sorting.

### Statistics

* Mean = 22.3/35 (63.5%)
* Median = 35/35 (100%)
* Mode = 35/35 (100%)
* Highest score = 35/35 (100%)
* Lowest score = 35/35 (100%)
* Number of users = 5

### Comments

This problem separated contestants well, that being said there were some very good attempts to the problem. Most solutions used a method to find the bitcount, dividing by 2 for instance, and then assign T/F as expected:

```java
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int rows = (int) Math.pow(2,n);
        
        for(int i =0; i < rows; i ++) {
            for(int j = n - 1; j >= 0; j--) {
                int value = (i/(int) Math.pow(2,j))%2;
                if(value == 0) {
                    System.out.print("F ");
                    
                }
                else {
                    System.out.print("T ");
                }
                    
            }
            System.out.println();
        }
    }
```

However, there is a somewhat more intuitive way of getting the bitcount of a number using library functions that are supported by most major languages, as our reference solutions did:

```java
public static void solver(int n)
    {
        // 00, 01, 10, 11
        for (int i = 0; i < Math.pow(2, n); i++)
        {
            String str = Integer.toBinaryString(i);
            for (int j = 0; j < n - str.length(); j++)
            {
                System.out.print("F" + '\t');
            }
            // print rest as default
            for (int j = 0; j < str.length(); j++)
            {
                System.out.print((str.charAt(j) == '1' ? "T" : "F") + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner keyboard = new Scanner(System.in);
        int n = Integer.parseInt(keyboard.nextLine());
        solver(n);
    }
```

Out of those that did not get full credit, one just hard-coded up to 6 (but got it right after the contest), and another attempt demonstrated some effort but was unfortunately not successful.

## Q3: LEU-KGX 8 (45)

*Difficulty - Medium*

### Solution sketch

Find the events with departure station LEU, and add the departure time into their corresponding bucket (so a train at 11:30 would come under bucket 11:00). Then merge the intervals and report them.
### Statistics

* Mean = 45/45 (100%)
* Median = 45/45 (100%)
* Mode = 45/45 (100%)
* Highest score = 45/45 (100%)
* Lowest score = 45/45 (100%)
* Number of users = 1

### Comments

There was only one attempt (Wang from CPSTA) who made short work on the problem, and another attempt right after the contest ended was close but had formatting issues. We did have a further correct attempt a few minutes later though.

```python
def leu_kgx_8(trains):
    s = set()
    for line in trains:
        st, ed, t = line.split()
        if st != 'LEU':
            continue
        
        h = t[0:2]
        s.add(h)
    
    list_t = list(map(int, s))
    list_t.sort()
    
    cur = list_t[0]
    end = cur + 1
    ans = []
    for i in range(1, len(list_t)):
        if list_t[i] == end:
            end+=1
        else:
            ans.append([cur, end])
            cur = list_t[i]
            end = cur+1
    
    ans.append([cur, end])
    res = "SUGGESTED OPENING HOURS: "
    for i in range(len(ans)):
        if i > 0:
            res += " + "
        res += (str(ans[i][0]) + ":00-" + str(ans[i][1]) + ":00")
    return res
```