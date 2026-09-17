class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        fun(0,nums,ans,list);
        return ans;
    }
    public void fun(int start,int[]nums,List<List<Integer>>ans,List<Integer>list){
        if(start==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[start]);
        fun(start+1,nums,ans,list);
        list.remove(list.size()-1);
        fun(start+1,nums,ans,list);
    }
}