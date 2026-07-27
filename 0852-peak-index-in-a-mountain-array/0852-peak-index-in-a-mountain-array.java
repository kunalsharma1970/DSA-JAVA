class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int low=0; int high=nums.length-1;int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            if(nums[guess]>nums[guess+1]){
                res=guess;
                high=guess-1;
            }else{
                low=guess+1;
            }
        }
        return res;
    }
}