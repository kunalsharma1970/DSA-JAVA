class Solution {
    public boolean isBipartite(int[][] graph) {
        int[]colors=new int[graph.length];
        Arrays.fill(colors,-1);
        for(int i=0;i<graph.length;i++){
            if(colors[i]==-1){
                dfs(graph,i,colors,0);
            }
        }
        return part;
    }
    public boolean part=true;
    public void dfs(int[][]graph,int s,int[]colors,int color){
        colors[s]=color;
        for(int nbr:graph[s]){
            if(colors[nbr]!=-1 && colors[nbr]==color) part=false;
            if(colors[nbr]==-1){
                dfs(graph,nbr,colors,1-color);
            }
        }
    }
}