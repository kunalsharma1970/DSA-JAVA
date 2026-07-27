class Solution {
    public int maxProduct(int[] nums) {
        int i=0; int j=nums.length-1; int ans=0; int res=0;
        while(i<j){
            if(nums[i]<nums[j]){
                ans=(nums[i]-1)*(nums[j]-1);
                res=Math.max(res,ans);
                i++;
                ans=0;
            }else{
                ans=(nums[i]-1)*(nums[j]-1);
                res=Math.max(res,ans);
                j--;
                ans=0;
            }
        }
        return res;
    }
}