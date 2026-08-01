class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        class Pair{
            int first;
            int second;
            Pair(int first,int second){
                this.first=first;
                this.second=second;
            }
        }
        Pair[]projects=new Pair[n];
        for(int i=0;i<n;i++){
            projects[i]=new Pair(capital[i],profits[i]);
        }
        Arrays.sort(projects,(a,b)->a.first-b.first);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int idx=0;
        while(k>0){
            while(idx<n){
                if(projects[idx].first>w) break;
                pq.add(projects[idx].second);
                idx++;
            }
            if(pq.size()==0) return w;
            w+=pq.poll();
            k--;
        }
        return w;
    }
}