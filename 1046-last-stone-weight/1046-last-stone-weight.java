class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==0) return 0;
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>0){
            if(pq.size()==1) return pq.peek();
            int y=pq.poll();
            int x=pq.poll();
            if(x==y) continue;
            else{
                y=y-x;
                pq.add(y);
            }
        }
        return 0;
    }
}