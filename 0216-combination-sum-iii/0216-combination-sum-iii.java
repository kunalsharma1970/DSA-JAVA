class Solution {
    public static void fun(int start,int k,int n,List<List<Integer>>list,List<Integer>temp,int sum){
        if(temp.size()==k && sum==n){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=9;i++){
            sum+=i;
            temp.add(i);
            fun(i+1,k,n,list,temp,sum);
            temp.remove(temp.size()-1);
            sum-=i;
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list= new ArrayList<>();int sum=0;
        fun(1,k,n,list,new ArrayList<Integer>(),sum);
        return list;
    }
}