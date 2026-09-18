class Solution {
    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:p){
            int pre=edge[0];
            int cou=edge[1];
            adj.get(pre).add(cou);
        }
        boolean []visited=new boolean[n];
        boolean []path=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]) dfs(adj,i,path,visited);
        }
        return !cycle;
    }
    public boolean cycle=false;
    public void dfs(List<List<Integer>>adj,int s,boolean[]path,boolean[]visited){
        visited[s]=true;
        path[s]=true;
        for(int nbr:adj.get(s)){
            if(!visited[nbr]) dfs(adj,nbr,path,visited);
            else if(visited[nbr] && path[nbr]){
                cycle=true;
                return;
            }
        }
        path[s]=false;
    }
}