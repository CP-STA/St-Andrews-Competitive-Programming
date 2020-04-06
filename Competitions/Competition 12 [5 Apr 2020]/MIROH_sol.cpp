#include <iostream>
#include <vector>
using namespace std;

int w, h;
vector <string> grid;
vector < vector<bool> > visited;
int total_visited;
int total_open_spaces;
int total_rooms;

/* This function essentially mimicks a depth first traversal,
   treating the grid almost as if it were a graph, with individual
   cells being nodes connected to non-wall cells adjacent to them
   (that is, the cells one unit above, one unit to the right, one
   unit below and one unit to the left of a given cell).
   It looks through each adjacent cell of the currently-visited one,
   and calls itself if an adjacent cell is both open and has not
   been visited yet. This thus traverses through each cell in a connected
   group, therefore marking every cell in this room as visited. */
void floodFill (int r, int c) {
    total_visited++;
    if (total_visited != total_open_spaces) {
        if (r > 0 && grid[r-1][c] == '0' && !visited[r-1][c]) {
            visited[r-1][c] = true;
            floodFill (r-1, c);
        }
        if (c < w-1 && grid[r][c+1] == '0' && !visited[r][c+1]) {
            visited[r][c+1] = true;
            floodFill (r, c+1);
        }
        if (r < h-1 && grid[r+1][c] == '0' && !visited[r+1][c]) {
            visited[r+1][c] = true;
            floodFill (r+1, c);
        }
        if (c > 0 && grid[r][c-1] == '0' && !visited[r][c-1]) {
            visited[r][c-1] = true;
            floodFill (r, c-1);
        }
    }
}

int main () {
    /* Obtain the input as described in the problem statement,
       and initialise the variables we need. At first, all of
       the cells in the grid are unvisited. */
    cin >> w >> h;
    total_visited = 0;
    total_open_spaces = 0;
    total_rooms = 0;
    
    for (int r = 0; r < h; r++) {
        string row;
        vector<bool> row_visited;
        cin >> row;
        for (int c = 0; c < w; c++) {
            row_visited.push_back (false);
            if (row[c] == '0') {
                total_open_spaces++;
            }
        }
        grid.push_back (row);
        visited.push_back (row_visited);
    }
    
    /* The condition in the while loop ensures that when the final answer
       has been obtained, every possible cell which can be checked, has been checked. */
    while (total_visited < total_open_spaces) {
        /* Search through the grid for unvisited cells. */
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                /* Since floodFill marks every cell in a room as visited, any unvisited,
                   open cell must be part of a room which has not been counted yet. If we
                   find one such cell, then we know we have found a new room, and we should
                   proceed to call floodFill so as to visit every cell in this room. */
                if (grid[r][c] == '0' && !visited[r][c]) {
                    total_rooms++;
                    visited[r][c] = true;
                    floodFill (r, c);
                }
            }
        }
    }
    
    /* Output our final answer. */
    cout << total_rooms << "\n";
    return 0;
}