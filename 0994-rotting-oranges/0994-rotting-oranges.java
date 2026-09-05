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
        Queue<Pair>q=new LinkedList<>();
        int time=0; int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    grid[i][j]=0;
                }else if(grid[i][j]==1) fresh++;
            }
        }
        while(!q.isEmpty() && fresh>0){
            time++;
            int size=q.size();
            while(size-->0){
                Pair p= q.poll();
                int r=p.first;
                int c=p.second;
                for(int k=0;k<4;k++){
                    int row= r+x[k];
                    int cols=c+y[k];
                    if(isValid(grid,row,cols) && grid[row][cols]==1){
                        q.add(new Pair(row,cols));
                        grid[row][cols]=0;
                        fresh--;
                    }
                }
            }
        }
        if(fresh>0) return -1;
        return time;
    }
    public boolean isValid(int[][]grid,int r,int c){
        if(r<0||r>=grid.length||c<0||c>=grid[0].length) return false;
        return true;
    }
}