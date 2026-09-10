class Solution {
    public long countPairs(int n, int[][] edges) {
       List<List<Integer>> adj= new ArrayList<>();
       for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
       } 
       for(int []edge:edges){
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
       }
       boolean []visited=new boolean[n];
       List<Integer> ans= new ArrayList<>();
       for(int i=0;i<n;i++){
            List<Integer>list= new ArrayList<>();
            if(!visited[i]){
                dfs(adj,i,list,visited);
                ans.add(list.size());
            }
       }
       if(ans.size()==1) return 0;
       long result=0;
       long prev=0;
       for(int i=0;i<ans.size();i++){
           int size=ans.get(i);
           result+=(long)size*prev;
           prev+=size;
       }
       return result;
    }
    public void dfs(List<List<Integer>>adj,int s,List<Integer>list,boolean[]visited){
        visited[s]=true;
        list.add(s);
        for(int nbr:adj.get(s)){
            if(!visited[nbr]) dfs(adj,nbr,list,visited);
        } 
    }
}