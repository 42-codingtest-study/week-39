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
    int N, K;
    cin >> N >> K;
    int answer = 0;
    while (K--)
    {
        int temp;
        cin >> temp;
        answer += (temp % 2 == 0) ? temp / 2 : temp / 2 + 1;
    }
    (answer >= N) ? cout << "YES" : cout << "NO";
}
