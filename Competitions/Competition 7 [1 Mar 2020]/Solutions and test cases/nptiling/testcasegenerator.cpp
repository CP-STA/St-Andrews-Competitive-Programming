#include <iostream>
#include <algorithm>
#include <fstream>
#include <string.h>
#include <limits.h>
using namespace std;
int main(int argc, char* argv[])
{
// arguments are two integers
int N = strtol(argv[1], nullptr, 0);
int P = strtol(argv[2], nullptr, 0);
int num = strtol(argv[3], nullptr, 0);
fstream f;
string s;
s.append("input");
if (num < 10)
s.append("0");
s.append(to_string(num));
s.append(".txt");
f.open(s.c_str(), ios::out);
f << N << " " << P;
f.close();
string t;
t.append("output");
if (num < 10)
t.append("0");
t.append(to_string(num));
t.append(".txt");
// recurrence relation T(n) = T(n - 1) + T(n - p). To find: T(n)
    if (N == 0 || P == 0 || N < P)
    {
        // no way to tile
        cout << 0;
         f.open(t.c_str(), ios::out);
    f << 0;
    f.close();
        return 0;
    }
    unsigned long long arr[N + 1];
    // arr[0] = 0; arr[N], N < P = 1
    arr[0] = 0;
    for (int i = 1; i < P; i++)
        arr[i] = 1;
    arr[P] = 2;
    for (int i = P + 1; i <= N; i++)
        arr[i] = arr[i - 1] + arr[i - P];
if (arr[N] > LONG_MAX)
std::cout << "overflow";
else
{
    f.open(t.c_str(), ios::out);
    f << arr[N];
    f.close();
   // std::cout << arr[N];
}
}