class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        int low=0; int res=0;

        for(int high=0;high<s.length();high++){
            char ch=s.charAt(high);
            if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
            while(map.get(ch)>1){
                char leftch=s.charAt(low);
                map.put(leftch,map.get(leftch)-1);
                if(map.get(leftch)==0) map.remove(leftch);
                low++;
            }
            if(map.get(ch)==1){
                int length=high-low+1;
                res=Math.max(res,length);
            }
        }
        return res;

    }
}