class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int low=0; int res=0;
        for(int high=0;high<fruits.length;high++){
            if(map.containsKey(fruits[high])) map.put(fruits[high],map.get(fruits[high])+1);
            else map.put(fruits[high],1);
            while(map.size()>2){
                map.put(fruits[low],map.get(fruits[low])-1);
                if(map.get(fruits[low])==0) map.remove(fruits[low]);
                low++;
            }
            int length=high-low+1;
            res=Math.max(res,length);
        }
        return res;
    }
}