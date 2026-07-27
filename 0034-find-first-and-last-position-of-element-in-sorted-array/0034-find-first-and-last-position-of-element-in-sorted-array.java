class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[]arr=new int[2];
        int low=0; int high=nums.length-1; int first=-1;
        while(low<=high){
            int guess=(low+high)/2;
            if(nums[guess]==target){
                first=guess;
                high=guess-1;
            }else if(nums[guess]<target){
                low=guess+1;
            }else{
                high=guess-1;
            }
        }
        int low1=0; int high1=nums.length-1; int second=-1;
        while(low1<=high1){
            int guess=(low1+high1)/2;
            if(nums[guess]==target){
                second=guess;
                low1=guess+1;
            }else if(nums[guess]<target) low1=guess+1;
            else high1=guess-1;
        }
        if(first!=-1 && second==-1) return new int[]{first,first};
        return new int[]{first,second};
    }
}