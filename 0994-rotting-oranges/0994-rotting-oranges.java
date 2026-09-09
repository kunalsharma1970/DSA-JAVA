class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int[]x={-1,1,0,0};
    public int[]y={0,0,-1,1}; 
    public int orangesRotting(int[][] grid) {
        int time=0; int fresh=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }if(grid[i][j]==1) fresh++;
            }
        }
        while(!q.isEmpty() && fresh>0){
            time++;
            int size=q.size();
            while(size-->0){
                Pair p=q.poll();
                int row=p.first;
                int cols=p.second;
                for(int k=0;k<4;k++){
                    int r=row+x[k];
                    int c=cols+y[k];
                    if(valid(grid,r,c) && grid[r][c]==1){
                        grid[r][c]=0;
                        q.add(new Pair(r,c));
                        fresh--;
                    }
                }
            }
        }
        if(fresh>0) return -1;
        return time;
    }
    public boolean valid(int[][]grid,int row,int cols){
        if(row<0 || cols<0 || row>=grid.length || cols>=grid[0].length) return false;
        return true;
    }
}