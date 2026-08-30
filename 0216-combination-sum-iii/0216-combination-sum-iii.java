class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        int num=9;
        int sum=0;
        fun(num,1,k,n,sum,ans,new ArrayList<>());
        return ans;
    }
    public void fun(int num,int start,int k,int n,int sum,List<List<Integer>>ans,List<Integer>list){
        if(list.size()==k && sum==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<=num;i++){
            sum+=i;
            list.add(i);
            fun(num,i+1,k,n,sum,ans,list);
            sum-=i;
            list.remove(list.size()-1);
        }
    }
}