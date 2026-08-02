class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=Integer.MAX_VALUE; int ans=0;
        for(int i=0;i<nums.length-2;i++){
            int left=i+1; int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target) return sum;
                else if(sum<target){
                    int diff=Math.abs(sum-target);
                    if(diff<res){
                        res=diff;
                        ans=sum;
                    }
                    left++;
                }else{
                    int diff=Math.abs(sum-target);
                    if(diff<res){
                        res=diff;
                        ans=sum;
                    }
                    right--;
                }
            }
        }
        return ans;
    }
}