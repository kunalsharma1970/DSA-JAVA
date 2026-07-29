class Solution {
    long speed(int []piles,int guess){
        long hour=0;
        for(int i=0;i<piles.length;i++){
            hour+=piles[i]/guess;
            if(piles[i]%guess!=0)hour++;
        }
        return hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
          int low=1; int high=0; int res=0;
          for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
          }
          while(low<=high){
            int guess=(low+high)/2;
            long hours=speed(piles,guess);
            if(hours>h){
                low=guess+1;
            }else{
                res=guess;
                high=guess-1;
            }
          }
          return res;
    }
}