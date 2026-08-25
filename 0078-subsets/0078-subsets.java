class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        gen(nums,0,ans,new ArrayList<>());
        return ans;
    }
    public void gen(int []nums,int start,List<List<Integer>> ans,List<Integer>list){
        if(start==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[start]);
        gen(nums,start+1,ans,list);
        list.remove(list.size()-1);
        gen(nums,start+1,ans,list);
    }
}