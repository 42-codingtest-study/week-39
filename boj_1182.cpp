#include <iostream>
#include <algorithm>
#include <utility>
#include <math.h>

using namespace std;

int n, s;
int arr[22];
int dp[22];
int cnt = 0;

void func(int cur, int sum)
{
  if (cur == n)
  {
    if (sum == s)
    {
      cnt++;
    }
    return ;
  }

  func(cur+1, sum + arr[cur]);
  func(cur+1, sum);
}

int main()
{
  cin>>n>>s;

  for (int i = 0; i < n; i++)
  {
    cin>>arr[i];
  }
  
  func(0,0);
  if (s == 0)
    cnt--;
  cout<<cnt<<"\n";

  return 0;
}