class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res= new ArrayList<>();
        dfs(0,graph,new ArrayList<>(),res);
        return res;
    }
    public void dfs(int curr,int[][]graph,List<Integer>list,List<List<Integer>>res){
        list.add(curr);
        if(curr==graph.length-1){
            res.add(new ArrayList<>(list));

        }else{
            for(int nbr:graph[curr]){
                dfs(nbr,graph,list,res);
            }
        }
        list.remove(list.size()-1);
    }
}