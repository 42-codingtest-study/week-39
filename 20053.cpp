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
    int T;
    cin >> T;
    while (T--)
    {
        int N;
        cin >> N;
        int max = -1000001, min = 1000001;
        for (int i = 0; i < N; i++)
        {
            int temp;
            cin >> temp;
            if (temp > max)
                max = temp;
            if (temp < min)
                min = temp;
        }
        cout << min << " " << max << "\n";
    }
}
