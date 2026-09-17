class Solution {
    public boolean sahi(int[]ska,int[]tka){
        for(int i=0;i<256;i++){
            if(ska[i]<tka[i]) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int []tka=new int[256];
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            tka[ch]++;
        }
        int low=0; int res=Integer.MAX_VALUE;; int length=0; int start=0;
        int []ska=new int[256];
        for(int high=0;high<s.length();high++){
            char ch=s.charAt(high);
            ska[ch]++;
            while(sahi(ska,tka)){
                length=high-low+1;
                if(length<res){
                    res=length;
                    start=low;
                }
                char left=s.charAt(low);
                ska[left]--;
                low++;
            }
        }
        if(res==Integer.MAX_VALUE) return "";
        return s.substring(start,res+start);

    }
}