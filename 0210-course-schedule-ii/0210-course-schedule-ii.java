class Solution {
    public int[] findOrder(int n, int[][] p) {
        int []indeg=new int[n];
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:p){
            adj.get(edge[1]).add(edge[0]);
            indeg[edge[0]]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }
        int count=0;
        int []arr=new int[n]; int s=0;
        while(!q.isEmpty()){
            int val=q.poll();
            arr[s]=val;
            s++;
            count++;
            for(int nbr:adj.get(val)){
                indeg[nbr]--;
                if(indeg[nbr]==0) q.add(nbr);
            }
        }
        if(count==n) return arr;
        return new int[0];
    }
}