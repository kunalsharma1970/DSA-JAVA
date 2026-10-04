class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int []res=new int[nums.length];
        int s=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                res[s]=nums[i];
                s++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==pivot){
                res[s]=nums[i];
                s++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>pivot){
                res[s]=nums[i];
                s++;
            }
        }
        int r=0;
        for(int i=0;i<res.length;i++){
            nums[r]=res[i];
            r++;
        }
        return nums;
    }
}