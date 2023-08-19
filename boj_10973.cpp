#include <iostream>
#include <algorithm>

using namespace std;

const int MAX_N = 10002;

int n;
int arr[MAX_N];

int main() {
    cin >> n;
    
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int i = n - 2;
    while (i >= 0 && arr[i] <= arr[i + 1]) {
        i--;
    }
    
    if (i >= 0) {
        int j = n - 1;
        while (j >= 0 && arr[i] <= arr[j]) {
            j--;
        }
        swap(arr[i], arr[j]);
        reverse(arr + i + 1, arr + n);
    } else {
        cout << -1;
        return 0;
    }

    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }

    return 0;
}
