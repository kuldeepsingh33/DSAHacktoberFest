class Solution {
public:
vectorrow;
vectorcol;
vector<vector>ans;
bool valid(vector&v,int i,int j)
{
int n=v.size();
int r=i;
int c=j;
r++;
c++;
while(r>=0&&c>=0&&r<n&&c<n)
{
if(v[r][c]=='Q')
return false;
r++;
c++;
}
r=i-1;
c=j+1;
while(r>=0&&c>=0&&r<n&&c<n)
{
if(v[r][c]=='Q')
return false;
r--;
c++;
}
r=i-1;
c=j-1;
while(r>=0&&c>=0&&r<n&&c<n)
{
if(v[r][c]=='Q')
return false;
r--;
c--;
}
r=i+1;
c=j-1;
while(r>=0&&c>=0&&r<n&&c<n)
{
if(v[r][c]=='Q')
return false;
r++;
c--;
}
//cout<<i<<" "<<"true"<<" "<<j<<"\n";
return true;
}
void go(vector&v,int r,int c,int n)
{
if(r==n){
ans.push_back(v);
return ;
}
