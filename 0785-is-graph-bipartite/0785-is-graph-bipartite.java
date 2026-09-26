class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int []colors=new int[n];
        Arrays.fill(colors,-1);
        for(int i=0;i<n;i++){
            if(colors[i]==-1) dfs(graph,i,colors,0);
        }
        return c;
    }
    public boolean c=true;
    public void dfs(int[][]graph,int s,int[]colors,int color){
        colors[s]=color;
        for(int nbr:graph[s]){
            if(colors[nbr]!=-1 &&  colors[nbr]==color) c=false;
            else if(colors[nbr]==-1) dfs(graph,nbr,colors,1-color);
        }
    }
}