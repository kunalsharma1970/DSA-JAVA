class Solution {
    public int search(int[] nums, int target) {
        int low=0; int high=nums.length-1; int last=nums[nums.length-1];
        int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            if(nums[guess]>last){
                low=guess+1;
            }else{
                res=guess;
                high=guess-1;
            }
        }
        int low1=0; int high1=res-1; 
        while(low1<=high1){
            int guess=(low1+high1)/2;
            if(nums[guess]==target){
                return guess;
            }else if(nums[guess]>target){
                high1=guess-1;
            }else{
                low1=guess+1;
            }
        }
        int low2=res; int high2=nums.length-1;
        while(low2<=high2){
            int guess=(low2+high2)/2;
            if(nums[guess]==target) return guess;
            else if(nums[guess]>target) high2=guess-1;
            else low2=guess+1;
        }
        return -1;
    }
}