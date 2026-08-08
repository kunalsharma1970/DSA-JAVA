class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>list= new ArrayList<>();
        gen(0,nums,list);
        return list;
    }
    public static void gen(int start,int[]nums,List<List<Integer>>list){
        if(start==nums.length){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i:nums){
                temp.add(i);
            }
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<nums.length;i++){
            int temp=nums[i];
            nums[i]=nums[start];
            nums[start]=temp;
            gen(start+1,nums,list);
            temp=nums[i];
            nums[i]=nums[start];
            nums[start]=temp;
        }
    }
}