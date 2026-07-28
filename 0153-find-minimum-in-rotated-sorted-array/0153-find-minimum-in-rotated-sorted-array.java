class Solution {
    public int findMin(int[] nums) {
        int low=0; int high=nums.length-1; int last=nums[nums.length-1];
        int res=-1;
        // if(nums.length==1) return nums[0];
        while(low<=high){
            int guess=(low+high)/2;
            if(nums[guess]<=last){
                res=nums[guess];
                high=guess-1;
            }else{
                low=guess+1;
            }
        }
        return res;
    }
}