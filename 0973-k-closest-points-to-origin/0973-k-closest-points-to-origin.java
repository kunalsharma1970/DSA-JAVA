class Solution {
    public int[][] kClosest(int[][] points, int k) {
        class Pair{
            int row;
            int cols;
            int dist;
            Pair(int row,int cols,int dist){
                this.row=row;
                this.cols=cols;
                this.dist=dist;
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)-> b.dist-a.dist  
        );
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            int dis=(x*x)+(y*y);
            Pair curr=new Pair(x,y,dis);
            if(pq.size()<k){
                pq.add(curr);
                continue;
            }
            if(curr.dist<pq.peek().dist){
                pq.poll();
                pq.add(curr);
            }else continue;
        }
        int[][]res=new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            res[i][0]=p.row;
            res[i][1]=p.cols;
            i++;
        }
        return res;
    }
}