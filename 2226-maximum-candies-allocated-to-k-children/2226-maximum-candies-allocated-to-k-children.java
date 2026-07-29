class Solution {
    boolean dist(int[] candies,long k,int guess){
        long c=0;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>=guess){
                c+=candies[i]/guess;
            }else continue;
            if(c>=k) return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        int low=1; int high=0;
        for(int num:candies) high=Math.max(high,num);
        int res=0;
        while(low<=high){
            int guess=(low+high)/2;
            if(dist(candies,k,guess)){
                res=guess;
                low=guess+1;
            }else{
                high=guess-1;
            }
        }
        return res;
    }
}