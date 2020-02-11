#include <string>
#include <iostream>
#include <fstream>
#include <bits/stdc++.h>

using namespace std;

void checker() {
    string f; cin >> f;
    int n, start_code;
    string path = "./test_case_string_evaluation/" + f + ".txt";
    std::ifstream infile(path);
    std::string line;
    try {
        std::getline(infile, line);
        std::istringstream iss(line);
        string s; iss >>s;
        int v = 0;
        for (char c : s) v += c;
        cout << v << endl;
    } catch (...) {
        return;
    }
}

int main(int argc, char const *argv[])
{
    checker();
    // string s; cin >> s;
    // int v = 0;
    // for (char c : s) v += c;
    // cout << v << endl;
    return 0;
}
