#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <numeric>
#include <math.h>
#include <utility>
#include <fstream>
#include <bits/stdc++.h>
#include </home/wang/Documents/GitHub/Learning-Cpp/wn.h>

using namespace std;
typedef long long int ll;
// typedef vector<int> vi;
// typedef pair<int, int> pi;
#define FOR(i, a, b) for (int i = a; i <= b; i++)

/*

SKYFALL

The sky has fall!!!!

You are given an array of n positive integer denote the height of building in your city.
As the sky fall, it slow down when destroy a floor of building.
Let p be the number of floors the sky destroy before being stopped.
return the floor number (round down to the nearest integer) at which the sky stop. if the sky
    cannot be stopped, return -1
*/

int sky_fall(vector<int> building, int p) {
    int n = building.size();
    if (n == 1) return (building[0] >= p)? building[0] - p : -1;

    sort(building.begin(), building.end(), [](int a, int b) {return a > b;});
    building.push_back(0);

    int cur_height = building[0];
    int cur_sum = 0;
    FOR (i,1, n) {
        if (cur_sum + i*(cur_height - building[i]) >= p) {
           return cur_height - (p - cur_sum + i - 1)/i;
        } else {
            cur_sum += i*(cur_height - building[i]);
            cur_height = building[i];
        }
    }
    return -1;
}

void checker() {
    //Don't print anything to STDOUT in this function
    //Enter your custom checker scoring logic here
    string path = "./input.txt";
    std::ifstream infile(path);
    std::string line;
    int n, p;
    vector<int> h;
    try {
        std::getline(infile, line);
        std::istringstream iss(line);
        iss >> n >> p;
        std::getline(infile, line);
        iss = std::istringstream(line);
        for (int i = 0; i < n; i++) {
            int temp;
            iss >> temp;
            h.push_back(temp);
        }
    } catch (...) {
        return;
    }
    cout << h[n - 1] << endl;
    cout << wnlib::time_to_run(sky_fall, h, p) << " ms" << endl;
    cout << sky_fall(h, p) << endl;
}

void solution() {
    int n, p; cin >> n >> p;
    vector<int> building(n);
    int sum = 0;
    FOR (i, 0, n-1) cin >> building[i];
    FOR (i, 0, n-1) cout << building[i] << ",";
    

    cout << sum << endl;
    cout << wnlib::time_to_run(sky_fall, building, p) << " ms" << endl;
    cout << sky_fall(building, p) << endl;
}

int main(int argc, char const *argv[])
{
    checker();
    solution();
    return 0;
}
