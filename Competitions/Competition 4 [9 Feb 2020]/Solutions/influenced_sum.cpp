#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <numeric>
#include <math.h>
#include <utility>
#include <queue>
#include <stdio.h>
#include <string.h>
#include <bits/stdc++.h>
#include </home/wang/Documents/GitHub/Learning-Cpp/wn.h>

using namespace std;
typedef long long int ll;
// typedef vector<int> vi;
// typedef pair<int, int> pi;
#define FOR(i, a, b) for (int i = a; i <= b; i++)

// INFLUENCED SUM

// For a graph G of n nodes labels 0 to n - 1. 
// You are given the adjacency list represent G and a start node.

// Let node k be the furthest node from start node with distance d (length of shortest path from start node to k).
//  the influenced-value of the node k is 1 and the influenced-value of start nodes is d + 1 (the further the nodes
// from start node the less influence the node has). (opposite the distance)

// The value of a node is calculated by multiply the label i (0 <= i < n) with the influenced value.

// Your task is to compute the sum of value of G with the given rule.

bool visited[10000];

int influenced_sum(vector<vector<int>> adj_list, int start_node) {
    memset(visited, false, sizeof(visited));

    queue<int> q;
    q.push(start_node);
    visited[start_node] = true;
    vector<int> v;
    while (!q.empty()) {
        int s = q.size();
        int sum = 0;
        FOR (i, 1, s) {
            int cur = q.front(); q.pop();
            sum += cur;
            for (int neighbor : adj_list[cur]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.push(neighbor);
                }
            }
        }
        v.push_back(sum);
    }
    
    int influenced = v.size();
    int value = 0;
    FOR (i, 0, v.size()) value += (influenced--)*v[i];
    return value;
}

void checker() {
    string f; cin >> f;
    int n, start_code;
    vector<vector<int>> adj_list;
    string path = "./test_case/" + f + ".txt";
    std::ifstream infile(path);
    std::string line;
    try {
        std::getline(infile, line);
        std::istringstream iss(line);
        iss >> n >> start_code;
        
        adj_list = vector<vector<int>>(n);
        FOR (i, 0, n-1) {
            std::getline(infile, line);
            iss = std::istringstream(line);
            int s; iss >> s;
            adj_list[i] = vector<int>(s);
            FOR (j,0,s-1) iss >> adj_list[i][j];
        }
    } catch (...) {
        return;
    }
    

    cout << wnlib::time_to_run(influenced_sum, adj_list, start_code) << " ms" << endl;
    cout << influenced_sum(adj_list, start_code) << endl;
}

void solution() {
    int n, start_node; cin >> n >> start_node;
    vector<vector<int>> adj_list(n);
    FOR (i, 0, n-1) {
        int s; cin >> s;
        adj_list[i] = vector<int> (s);
        FOR (j,0,s-1) 
            cin >> adj_list[i][j];
    }

    cout << influenced_sum(adj_list, start_node) << endl;
}

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    checker();
    // solution();
    return 0;
}
