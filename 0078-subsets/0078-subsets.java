class Solution {
    public static void AllSubsets(int[]nums,int start,List<List<Integer>>list,List<Integer>temp){
        if(start==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[start]);
        AllSubsets(nums,start+1,list,temp);
        temp.remove(temp.size()-1);
        AllSubsets(nums,start+1,list,temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        AllSubsets(nums,0,list,new ArrayList<>());
        return list;
    }
}