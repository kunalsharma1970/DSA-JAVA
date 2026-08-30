class Solution {
    void fun(int []candidates,int n,int idx,int sum,List<Integer>list,List<List<Integer>>ans,int target){
        if(idx==n){
            if(sum==target){
                ans.add(new ArrayList<>(list));
                return;
            }
            return;
        }
        fun(candidates,n,idx+1,sum,list,ans,target);
        if(sum+candidates[idx]<=target){
            list.add(candidates[idx]);
            sum+=candidates[idx];
            fun(candidates,n,idx,sum,list,ans,target);
            list.remove(list.size()-1);
            sum-=candidates[idx];
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>list=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int sum=0; int n=candidates.length;int idx=0;
        fun(candidates,n,idx,sum,list,ans,target);
        return ans;
    }
}