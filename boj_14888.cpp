#include <iostream>

using namespace std;

int n;
int a[102];
int operands[4];

long long maxval = -1000000003;
long long minval = 1000000003;

void func(int result, int cur)
{
  if (cur == n)
  {
    if (result > maxval)
    {
      maxval = result;
    }
    if (result < minval)
    {
      minval = result;
    }
    return;
  }

  for (int i = 0; i <4; i++)
  {
    if (operands[i] > 0)
    {
      operands[i]--;

      if (i == 0)
      {
        func(result + a[cur], cur + 1);
      }
      if (i == 1)
      {
        func(result - a[cur], cur + 1);
      }
      if (i == 2)
      {
        func(result * a[cur], cur + 1);
      }
      if (i == 3)
      {
        func(result / a[cur], cur + 1);
      }
      operands[i]++;
    }
  }
  return ;
}

int main()
{
  cin>>n;

  for (int i = 0 ; i < n; i++)
  {
    cin>>a[i];
  }
  for (int i = 0; i < 4; i++)
  {
    cin>>operands[i];
  }

  func(a[0], 1);

  cout<<maxval << "\n" << minval << "\n";

  return 0;
}