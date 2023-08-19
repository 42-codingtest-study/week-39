#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

int n;
int A[13];
int operands[4];

int isvisited[13];
int maxval = -1000000002;
int minval = 1000000002;

void func(int cur, int sum)
{
  if (cur == n)
  {
    if (sum > maxval)
      maxval = sum;
    if (sum < minval)
      minval = sum;
    return ;
  } 
  for (int i = 0; i < 4; i++)
  {
    if (operands[i] == 0)
      continue;
    
    if (i == 0)
    {
    operands[i]--;  
      func(cur+1, sum + A[cur]);
    }
    if (i == 1)
    {
    operands[i]--;  
      func(cur+1, sum - A[cur]);
    }
    if(i== 2)
    {
    operands[i]--;  
      func(cur+1, sum * A[cur]);
    }
    if (i == 3)
    {
    operands[i]--;  
      func(cur+1, sum / A[cur]);
    }
    operands[i]++;
  }

}

int main()
{
  cin>>n;
  for (int i = 0; i < n ; i++)
  {
    cin>>A[i];
  }
  for (int i = 0; i < 4; i++)
  {
    cin>>operands[i];
  }

  func(1,A[0]);

  cout<<maxval<<"\n" << minval << "\n";
  return 0;
}