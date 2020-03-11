// freeweights.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <algorithm>
using namespace std;
bool core(int* weights, int index, int N)
{
    /*
      The approach in this problem is to run a scan through the array, ignoring any values
      that is less than or equal to i. If that scan reveals any other unpaired weights, it is a fail.
      */
    int check = 0;
    int firstvalidpair = -1;
    int firstvalidpairindex = -1;
    for (int j = 0; j < 2 * N; j++)
    {
        if (weights[j] <= index)
        {
            // ignore, as we can always move such a weight
        }
        else if (firstvalidpair == -1)
        {
            firstvalidpair = weights[j];
            firstvalidpairindex = j;
        }
        else if (firstvalidpair != weights[j])
        {
            // then break, as the condition isn't satisfied
            check = 1;
            break;
        }
        else if (firstvalidpair > index && weights[j] == firstvalidpair && firstvalidpairindex < N && j >= N)
        {
            /* this means that the second weight is in a different row to that of the first
            and cannot be accepted, must be broken as usual
            */
            check = 1;
            break;
        }
        else if (weights[j] == firstvalidpair)
        {
            // yay, condition is satisfied (for now). Reset it back and wait for the next set of pairs to consider
            firstvalidpair = -1;
            firstvalidpairindex = -1;
        }
    }
    if (check == 0)
    {
        // we're done!
  //      printf("%d\n", index);
        return true;
    }
    else
        return false;
}
int binSearch(int* weights, int low, int high, int N)
{
    if (low == high)
        return low;
    if (low + 1 == high)
    {
        if (core(weights, low, N))
            return low;
        else
            return high;
    }
    int mid = (low + high) / 2;
    if (core(weights, mid, N))
        return binSearch(weights, low, mid, N);
    else
        return binSearch(weights, mid + 1, high, N);
}
int main()
{
    int N; // number of pairs of weights
    cin >> N;
    int* weights = (int*)malloc(2 * N * sizeof(int)); // 2N weights for N pairs
    // inputting the weights
    int maxweight = 0;
    for (int i = 0; i < 2 * N; i++)
    {
        cin >> weights[i];
        maxweight = max(weights[i], maxweight);
    }
    // finding min(weight) for which this works using binary search
    printf("%d\n",binSearch(weights, 0, maxweight, N));
    // std::cout << "Hello World!\n";
}