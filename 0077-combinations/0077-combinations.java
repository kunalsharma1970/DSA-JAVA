class Solution {
    public static void fun(int n,int k,int start,List<List<Integer>>list,List<Integer>temp){
        if(temp.size()==k){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=n;i++){
            temp.add(i);
            fun(n,k,i+1,list,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        fun(n,k,1,list,new ArrayList<>());
        return list;
    }
}