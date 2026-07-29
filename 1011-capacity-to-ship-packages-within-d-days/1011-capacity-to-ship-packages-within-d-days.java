class Solution {
    boolean Shipped(int []weights,int days,int guess){
        int weight=0;int cap=1;
        for(int i=0;i<weights.length;i++){
            if(weight+weights[i]<=guess){
                weight+=weights[i];
            }else if(guess<weights[i])return false;
            else{
                cap++;
                weight=weights[i];
            }
        }
        if(cap<=days) return true;
        return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=1; int high=0; int res=-1;
        for(int num:weights){
            high+=num;
        }
        while(low<=high){
            int guess=(low+high)/2;
            if(Shipped(weights,days,guess)){
                res=guess;
                high=guess-1;
            }else{
                low=guess+1;
            }
        }
        return res;
    }
}