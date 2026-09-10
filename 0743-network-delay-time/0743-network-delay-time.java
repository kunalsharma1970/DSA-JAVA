class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:times){
            adj.get(edge[0]-1).add(new Pair(edge[1]-1,edge[2]));
        }
        int []dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;
        PriorityQueue<Pair> pq= new PriorityQueue<>(
            (a,b) -> a.weight-b.weight
        );
        pq.add(new Pair(k-1,0));
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int val=p.node;
            int d=p.weight;
            if(d>dist[val]) continue;
            for(Pair nbr:adj.get(val)){
                int nod=nbr.node;
                int w=nbr.weight;
                if(d+w<dist[nod]){
                    dist[nod]=d+w;
                    pq.add(new Pair(nod,d+w));
                }
            }
        }
        int max=0;
        for(int num:dist){
            if(num==Integer.MAX_VALUE) return -1;
            max=Math.max(max,num);
        }
        return max;
    }
}