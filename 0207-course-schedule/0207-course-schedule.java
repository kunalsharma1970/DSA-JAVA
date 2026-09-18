class Solution {
    public boolean canFinish(int n, int[][] p) {
        int[]indeg=new int[n];
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:p){
            adj.get(edge[0]).add(edge[1]);
            indeg[edge[1]]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int val=q.poll();
            count++;
            for(int nbr:adj.get(val)){
                indeg[nbr]--;
                if(indeg[nbr]==0) q.add(nbr);
            }
        }
        if(count==n) return true;
        return false;
    }
}