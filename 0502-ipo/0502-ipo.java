class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        class Pair{
            int capital;
            int profit;
            Pair(int capital,int profit){
                this.capital=capital;
                this.profit=profit;
            }
        }
        Pair[]projects=new Pair[n];
        for(int i=0;i<n;i++){
            projects[i]=new Pair(capital[i],profits[i]);
        }
        Arrays.sort(projects,(a,b)->a.capital-b.capital);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int idx=0;
        while(k>0){
            while(idx<n){
                if(projects[idx].capital>w) break;
                pq.add(projects[idx].profit);
                idx++;
            }
            if(pq.size()==0) return w;
            int pro=pq.poll();
            w+=pro;
            k--;
        }
        return w;
    }
}