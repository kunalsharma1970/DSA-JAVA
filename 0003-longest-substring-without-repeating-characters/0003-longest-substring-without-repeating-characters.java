class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        int low=0; 
        int max=0;
        for(int high=0;high<s.length();high++){
            char ch=s.charAt(high);
            if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
            while(map.get(ch)>1){
                char left=s.charAt(low);
                map.put(left,map.get(left)-1);
                if(map.get(left)==0) map.remove(left);
                low++;
            }
            int length=high-low+1;
            max=Math.max(max,length);
        }
        return max;
    }
}