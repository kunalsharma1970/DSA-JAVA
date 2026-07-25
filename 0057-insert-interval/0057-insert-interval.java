class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        if(intervals.length==0){
            list.add(new int[]{newInterval[0],newInterval[1]});
            return list.toArray(new int[list.size()][]);
        }
        boolean insert=false;
        for(int i=0;i<intervals.length;i++){
            if(insert==false && intervals[i][0]>newInterval[0]){
                list.add(new int[]{newInterval[0],newInterval[1]});
                insert=true;
            }
            list.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        if(insert==false){
            list.add(new int[]{newInterval[0],newInterval[1]});
        }
        List<int[]> ans=new ArrayList<>();
        int start1=list.get(0)[0];
        int end1=list.get(0)[1];
        for(int i=1;i<list.size();i++){
            int start2=list.get(i)[0];
            int end2=list.get(i)[1];
            if(end1>=start2){
                end1=Math.max(end1,end2);
                continue;
            }
            ans.add(new int[]{start1,end1});
            start1=start2;
            end1=end2;
        }
        ans.add(new int[]{start1,end1});
        return ans.toArray(new int[ans.size()][]);
    }
}