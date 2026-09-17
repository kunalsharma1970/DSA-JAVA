class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n=candidates.length;
        fun(candidates,n,0,0,ans,list,target);
        return ans;
    }
    public void fun(int []candidates,int n,int idx,int sum,List<List<Integer>>ans,List<Integer>list,int target){
        if(idx==n){
            if(sum==target){
                ans.add(new ArrayList<>(list));
                return;
            }
            return;
        }
        fun(candidates,n,idx+1,sum,ans,list,target);
        if(candidates[idx]+sum<=target){
            list.add(candidates[idx]);
            sum+=candidates[idx];
            fun(candidates,n,idx,sum,ans,list,target);
            list.remove(list.size()-1);
            sum-=candidates[idx];
        }
    }
}