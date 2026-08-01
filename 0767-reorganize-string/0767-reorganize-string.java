class Solution {
    public String reorganizeString(String s) {
        class Pair{
            int first;
            char second;
            Pair(int first,char second){
                this.first=first;
                this.second=second;
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first) return b.first-a.first;
                return b.second-a.second;
            }
        );
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
            else  map.put(ch,1);
        }
        for(Map.Entry<Character,Integer>e:map.entrySet()){
            int freq=e.getValue();
            char alpha=e.getKey();
            Pair curr=new Pair(freq,alpha);
            pq.add(curr);
        }
        StringBuilder sb=new StringBuilder();
        int seat=0;
        while(!pq.isEmpty()){
            Pair p1=pq.poll();
            if(sb.length()==0 ||sb.charAt(seat-1)!=p1.second){
                sb.append(p1.second);
                p1.first--;
                if(p1.first!=0) pq.add(p1);
                seat++;
            }else{
                if(pq.size()==0) return "";
                Pair p2=pq.poll();
                sb.append(p2.second);
                p2.first--;
                if(p2.first!=0) pq.add(p2);
                pq.add(p1);
                seat++;
            }
        }
        return sb.toString();
    }
}