#include <iostream>
#include <math.h>
#include <algorithm>

using namespace std;

int n;
int arr[10];
int isused[10];
int lst[10];
int ans = -1;

int get_diff()
{
  int sum1 = 0;
  for (int i = 0; i < n-1; i++)
  {
    sum1 += abs(lst[i] - lst[i + 1]);
  }
  return sum1;
}

void func(int cur)
{

  if (cur == n )
  {
    int sum2 = get_diff();
    ans = max(sum2, ans);
    return;
  }

  for (int i = 0; i < n; i++)
  {
    if (isused[i] == 0)
    {
      isused[i] = 1;
      lst[cur] = arr[i];
      func(cur + 1);
      lst[cur] = 0;
      isused[i] = 0;
    }
  }
}

int main()
{
  cin >> n;
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }

  func(0);
  cout << ans << "\n";
  return 0;
}