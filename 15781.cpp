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
    int N, M;
    cin >> N >> M;
    ll maxHelmet = 0, maxArmor = 0;
    for (int i = 0; i < N; i++)
    {
        ll temp;
        cin >> temp;
        maxHelmet = max(maxHelmet, temp);
    }
    for (int i = 0; i < M; i++)
    {
        ll temp;
        cin >> temp;
        maxArmor = max(maxArmor, temp);
    }
    cout << maxHelmet + maxArmor;
}
