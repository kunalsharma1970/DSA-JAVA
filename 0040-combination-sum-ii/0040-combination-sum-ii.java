class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans= new ArrayList<>();
        fun(candidates,0,0,target,ans,new ArrayList<>());
        return ans;
    }
    public void fun(int[]candidates,int start,int sum,int target,List<List<Integer>>ans,List<Integer>list){
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            if(sum + candidates[i] > target) {
                break;
            }
            sum+=candidates[i];
            list.add(candidates[i]);
            fun(candidates,i+1,sum,target,ans,list);
            sum-=candidates[i];
            list.remove(list.size()-1);
        }
    }
}