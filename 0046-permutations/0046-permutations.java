class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        fun(nums,0,ans);
        return ans;
    }
    public void fun(int []nums,int start,List<List<Integer>>ans){
        if(start==nums.length){
            List<Integer>list= new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            int temp=nums[i];
            nums[i]=nums[start];
            nums[start]=temp;
            fun(nums,start+1,ans);
            temp=nums[i];
            nums[i]=nums[start];
            nums[start]=temp;
        }
    }
}