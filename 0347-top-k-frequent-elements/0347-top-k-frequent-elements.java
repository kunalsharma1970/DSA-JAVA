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
                return a.first-b.first;
            }
        );
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            int freq=e.getValue();
            int element=e.getKey();
            
            Pair p=new Pair(freq,element);
            if(pq.size()<k) {
                pq.add(p);
                continue;
            }
            if(p.first>pq.peek().first){
                pq.poll();
                pq.add(p);
            }else continue;
        }
        int[]res=new int[k]; int s=0;
        while(!pq.isEmpty()){
            res[s]=pq.peek().second;
            s++;
            pq.poll();
        }
        return res;
    }
}