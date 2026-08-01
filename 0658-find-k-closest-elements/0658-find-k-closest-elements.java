class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        class Pair{
            int first;
            int second;
            Pair(int first,int second){
                this.first=first;
                this.second=second;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first) return b.first-a.first;
                return b.second-a.second;
            }
        );
        for(int i=0;i<arr.length;i++){
            int diff=Math.abs(arr[i]-x);
            int element=arr[i];

            Pair curr=new Pair(diff,element);
            if(pq.size()<k){
                pq.add(curr);
                continue;
            }
            if(curr.first<pq.peek().first){
                pq.poll();
                pq.add(curr);
            }else{
                continue;
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll().second);
        } 
        Collections.sort(list);
        return list;
    }
}