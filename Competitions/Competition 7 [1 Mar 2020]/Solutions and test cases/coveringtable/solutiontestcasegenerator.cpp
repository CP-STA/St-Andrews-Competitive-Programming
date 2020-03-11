#include <iostream>
#include <algorithm>
#include <fstream>
#include <string.h>
using namespace std;
int main(int argc, char* argv[])
{
// first argument is l, second argument is b
int l = strtol(argv[1], nullptr, 0);
int b = strtol(argv[2], nullptr, 0);
int num = strtol(argv[3], nullptr, 0);
fstream f;
string s;
s.append("input");
if (num < 10)
s.append("0");
s.append(to_string(num));
s.append(".txt");
f.open(s.c_str(), ios::out);
f << l << " " << b;
f.close();
string t;
t.append("output");
if (num < 10)
t.append("0");
t.append(to_string(num));
t.append(".txt");
f.open(t.c_str(), ios::out);
double res = min((double)l*0.5,(double)b*0.5)*min((double)l*0.5,(double)b*0.5)*3.14;
string p = to_string(res);
f << p.c_str();
f.close();
return 0;
}