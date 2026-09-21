class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public int swimInWater(int[][] grid) {
        int low=grid[0][0];
        int high=grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                high=Math.max(high,grid[i][j]);
            }
        }
        int res=0;
        while(low<=high){
            int guess=(low+high)/2;
            if(bfs(grid,guess)){
                res=guess;
                high=guess-1;
            }else low=guess+1;
        }
        return res;
    }
    public boolean bfs(int [][]grid,int money){
        int []x={1,-1,0,0};
        int []y={0,0,1,-1};
        Queue<Pair> q= new LinkedList<>();
        boolean [][]visited= new boolean[grid.length][grid[0].length];
        q.add(new Pair(0,0));
        visited[0][0]=true;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.first;
            int cols=p.second;
            if(row==grid.length-1 && cols==grid[0].length-1) return true;
            for(int k=0;k<4;k++){
                int r=row+x[k];
                int c=cols+y[k];
                if(valid(grid,r,c) && visited[r][c]==false && money>=grid[r][c]){
                    q.add(new Pair(r,c));
                    visited[r][c]=true;
                }
            }
        }
        return false;
    }
    public boolean valid(int [][]grid,int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) return false;
        return true;
    }
}