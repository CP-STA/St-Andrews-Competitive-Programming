#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <numeric>
#include <math.h>
#include <utility>
#include <fstream>
#include </home/wang/Documents/GitHub/Learning-Cpp/wn.h>
#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;
// typedef vector<int> vi;
// typedef pair<int, int> pi;
#define FOR(i, a, b) for (int i = a; i <= b; i++)

/*

A fibonacci sequence have f0, f1, f2, ..., fn, ...
where k-th number can be calculated by the formula fk = fk-1 + fk-2

you are given 4 number f0 f1 n k. Return the k-th digit (start from the least significant number)
    of the n-th fibonacci number in the sequence started with given f0 and f1.

constrant:
0 < f0, f1 <= 1000
1 < n <= 10000
0 < k <= number of digits of fn
*/

int ith_digit_of_nth_fib(int f0, int f1, int n, int k) {
    vector<int> f[3];
    FOR(i,0,2) f[i] = vector<int>(k + 1);

    for (int i = 0; f0 > 0; i++, f0/=10)
        f[0][i] = f0%10;

    for (int i = 0; f1 > 0; i++, f1/=10)
        f[1][i] = f1%10;
    
    for (; n > 2; n--) {
        FOR (i, 0 ,k-1) {
            f[2][i] += f[1][i] + f[0][i];
            if (f[2][i] > 9) {
                f[2][i+1] += f[2][i]/10;
                f[2][i] %= 10;
            }
        }
        f[0] = f[1];
        f[1] = f[2];
        f[2] = vector<int>(k+1);

    }

    return f[1][k-1];
}


void checker() {
    //Don't print anything to STDOUT in this function
    //Enter your custom checker scoring logic here
    string path = "./input.txt";
    std::ifstream infile(path);
    std::string line;
    int f0, f1, n, k;
    try {
        std::getline(infile, line);
        std::istringstream iss(line);
        iss >> f0 >> f1 >> n >> k;
    } catch (...) {
        return;
    }
    // cout << wnlib::time_to_run(ith_digit_of_nth_fib, f0,f1,n,k) << " ms" << endl;
    cout << ith_digit_of_nth_fib(f0,f1,n,k) << endl;
}

void solution() {
    int f0, f1, n, k; cin >> f0 >> f1 >> n >> k;
    cout << wnlib::time_to_run(ith_digit_of_nth_fib, f0,f1,n,k) << endl;
}

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    //solution();
    checker();
    return 0;
}
