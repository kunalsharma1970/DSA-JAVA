class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int low=0; int high=k-1;
        double sum=0; double res=Integer.MIN_VALUE;
        for(int i=0;i<=high;i++){
            sum+=nums[i];
        }
        while(high<nums.length){
           double avg=sum/k;
            res=Math.max(res,avg);
            if(high==nums.length-1) break;
            low++;
            high++;
            sum=sum-nums[low-1]+nums[high];
        }
        return res;
    }
}