class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int low=0; int high=k-1; long res=0; long sum=0;
        for(int i=0; i<=high;i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
            sum+=nums[i];
        }
        while(high<nums.length){
            if(map.size()==k){
                res=Math.max(res,sum);
                // sum=0;
            }
            map.put(nums[low],map.get(nums[low])-1);
            if(map.get(nums[low])==0) map.remove(nums[low]);
            low++;
            if(high==nums.length-1) break;
            high++;
            if(map.containsKey(nums[high])) map.put(nums[high],map.get(nums[high])+1);
            else map.put(nums[high],1);
            sum=sum-nums[low-1]+nums[high];
        }
        return res;
    }
}