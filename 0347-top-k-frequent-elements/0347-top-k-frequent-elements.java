class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        class Pair{
            int first;
            int second;
            Pair(int first,int second){
                this.first=first;
                this.second=second;
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first) return a.first-b.first;
                return a.second-b.second;
            }
        );
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            int element=e.getKey();
            int freq=e.getValue();

            Pair curr=new Pair(freq,element);
            if(pq.size()<k){
                pq.add(curr);
                continue;
            }
            if(curr.first<pq.peek().first) continue;
            else{
                pq.poll();
                pq.add(curr);
            }
        }
        int []res=new int[k];
        int s=0;
        while(!pq.isEmpty()){
            res[s]=pq.poll().second;
            s++;
        }
        return res;
    }
}