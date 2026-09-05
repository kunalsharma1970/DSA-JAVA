class Solution {
    class Pair{
        int row;
        int cols;
        Pair(int row,int cols){
            this.row=row;
            this.cols=cols;
        }
    }
    public int[]x={-1,1,0,0};
    public int []y={0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q= new LinkedList<>();
        int time=0; int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    grid[i][j]=0;
                }
                else if(grid[i][j]==1) fresh++;
            }
        }
        while(!q.isEmpty() && fresh>0){
            time++;
            int size=q.size();
            while(size-->0){
                Pair p=q.poll();
                int r=p.row;
                int c=p.cols;
                for(int k=0;k<4;k++){
                    int rr=r+x[k];
                    int cc=c+y[k];
                    if(valid(grid,rr,cc) && grid[rr][cc]==1){
                        q.add(new Pair(rr,cc));
                        grid[rr][cc]=0;
                        fresh--;
                    }
                }
            }
        }
        if(fresh>0) return -1;
        return time;
    }
    public boolean valid(int[][]grid,int r,int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length) return false;
        return true;
    }
}