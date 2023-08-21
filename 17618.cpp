#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

#define fast                          \
    ios_base::sync_with_stdio(false); \
    cin.tie(0), cout.tie(0)
#define ll long long

int main()
{
    fast;
    int N;
    cin >> N;
    int answer = 0;
    while (N != 0)
    {
        string strN = to_string(N);
        int sum = 0;
        for (int i = 0; i < strN.length(); i++)
        {
            sum += (strN[i] - '0');
        }
        if (N % sum == 0)
            answer++;
        N--;
    }
    cout << answer;
}
