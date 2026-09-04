class Solution {
    public int count=0;
    public int res=0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area=dfs(grid,i,j);
                    res=Math.max(res,area);
                }
            }
        }
        return res;
    }
    public int dfs(int [][]graph,int r, int c){
        if(r<0 || c<0 || r==graph.length ||c==graph[0].length || graph[r][c]==0) return 0;
        count++;
        graph[r][c]=0;
        int d=dfs(graph,r+1,c);
        int u=dfs(graph,r-1,c);
        int ri=dfs(graph,r,c+1);
        int l=dfs(graph,r,c-1);
        return 1+d+u+ri+l;
    }
}