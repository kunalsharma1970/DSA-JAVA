class Solution {
    boolean Days(int[]bloomDay,int k,int guess,int m){
        int count=0; int bug=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=guess) count++;
            else count=0;
            if(count==k){
                bug++;
                count=0;
            }
        }
        if(bug>=m) return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low=1; int high=0; int res=-1;
        for(int i=0;i<bloomDay.length;i++){
            high=Math.max(high,bloomDay[i]);
        }
        while(low<=high){
            int guess=(low+high)/2;
            if(Days(bloomDay,k,guess,m)){
                res=guess;
                high=guess-1;
            }else{
                low=guess+1;
            }
        }
        return res;
    }
}