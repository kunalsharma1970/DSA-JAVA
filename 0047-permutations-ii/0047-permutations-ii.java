class Solution {
    public static void fun(int start,int []nums,Set<List<Integer>>set){
        if(start==nums.length){
            ArrayList<Integer> temp= new ArrayList<>();
            for(int num:nums){
                temp.add(num);
            }
            set.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<nums.length;i++){
            // if(i>0 && nums[i]==nums[i-1]) continue;
            int temp=nums[i];
            nums[i]=nums[start];
            nums[start]=temp;
            fun(start+1,nums,set);
            temp=nums[i];
            nums[i]=nums[start];
            nums[start]=temp;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>>set= new HashSet<>();
        fun(0,nums,set);
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }
}