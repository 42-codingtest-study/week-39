#include <iostream>

using namespace std;

int n;
int s[22];
int ispossible[2000002];

void func(int cur, int sum)
{
  ispossible[sum] = 1;
  if (cur == n)
    return;

  func(cur + 1, sum + s[cur]);
  func(cur + 1, sum);
}

int main()
{
  cin >> n;
  for (int i = 0; i < n; i++)
    cin >> s[i];

  func(0, 0);

  for (int i = 1; i <= 2000000; i++)
  {
    if (ispossible[i] == 0)
    {
      cout << i << "\n";
      return 0;
    }
  }
  return 0;
}