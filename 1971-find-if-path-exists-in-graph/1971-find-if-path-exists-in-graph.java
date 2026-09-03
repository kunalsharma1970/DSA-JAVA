class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean []visited=new boolean[n];
        return dfs(source,destination,adj,visited);
    }
    public boolean dfs(int s,int d,List<List<Integer>> adj,boolean []visited){
        if(s==d) return true;
        visited[s]=true;
        for(int nbr:adj.get(s)){
            if(!visited[nbr] && dfs(nbr,d,adj,visited)) return true;
        }
        return false;
    }
}