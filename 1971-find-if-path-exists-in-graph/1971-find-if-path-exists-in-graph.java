class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean []visited=new boolean[n];
        dfs(adj,source,destination,visited);
        return path;
    }
    public boolean path=false;
    public void dfs(List<List<Integer>>adj,int s,int dest,boolean[]visited){
        if(s==dest)path=true;
        visited[s]=true;
        for(int nbr:adj.get(s)){
            if(!visited[nbr]) dfs(adj,nbr,dest,visited);
        }
    }
}