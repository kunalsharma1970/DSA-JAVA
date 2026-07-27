class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans=new ArrayList<>();
        int i=0; int j=0;
        
        while(i<firstList.length && j<secondList.length){
            int start1=firstList[i][0];
            int end1=firstList[i][1];
            int start2=secondList[j][0];
            int end2=secondList[j][1];
            if(end2>=start1 && end1>=start2){
            int s1=Math.max(start1,start2);
            int e1=Math.min(end1,end2);
            ans.add(new int[]{s1,e1});
            }
            if(end1<end2){
                i++;
            }else{
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}