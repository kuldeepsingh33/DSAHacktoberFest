class Solution {

    public static boolean check(int grid[][],int c,int x[],int y[],int i,int j){
        if(c==(grid.length*grid.length)-1) return true;
        for(int k=0;k<8;k++){
            int next_i=i+x[k];
            int next_j=j+y[k];
            if(valid(next_i,next_j,grid,c)){
                if(check(grid,c+1,x,y,next_i,next_j)) return true;
            }
        }
        return false;
    }

    public static boolean valid(int i,int j,int grid[][],int c){
        int n=grid.length;
        if(i<n && i>=0 && j<n && j>=0 && grid[i][j]==c+1){
            return true;
        }
        return false;
    }

    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0) return false;
        int c=0;
        int x[]={2,1,-1,-2,-2,-1,1,2};
        int y[]={1,2,2,1,-1,-2,-2,-1};
        return check(grid,c,x,y,0,0);
    }
}