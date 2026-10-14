class Solution {
    int []parent;
    int []rank;
    int find(int x){
        if(parent[x]==x) return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }
    boolean union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB){
            return false;
        }
        if(rank[rootA]<rank[rootB]){
            parent[rootA]=rootB;
        }else if(rank[rootB]<rank[rootA]) parent[rootB]=rootA;
        else{
            parent[rootB]=rootA;
            rank[rootA]++;
        }
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int []edge:edges){
            if(!union(edge[0],edge[1])) return edge;
        }
        return new int[1];
    }
}