class Solution {
    public static void fun(int start,int []nums,List<List<Integer>> list){
        if(start==nums.length){
            ArrayList<Integer> temp= new ArrayList<>();
            for(int num:nums){
                temp.add(num);
            }
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<nums.length;i++){
        int temp=nums[i];
        nums[i]=nums[start];
        nums[start]=temp;
        fun(start+1,nums,list);
        temp=nums[i];
        nums[i]=nums[start];
        nums[start]=temp;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        fun(0,nums,list);
        return list;
    }
}