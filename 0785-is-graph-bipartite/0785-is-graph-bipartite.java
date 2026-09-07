class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int []colors=new int[n];
        for(int i=0;i<n;i++){
            colors[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(colors[i]==-1){
                dfs(graph,i,0,colors);
            }
        }
        return res;
    }
    public boolean res=true;
    public void dfs(int[][]graph,int s,int color,int[]colors){
        colors[s]=color;
        for(int nbr:graph[s]){
            if(colors[nbr]!=-1 && colors[nbr]==color){
                 res=false;
                 return;
            }
            if(colors[nbr]==-1){
                dfs(graph,nbr,1-color,colors);
            }
        }
    }
}