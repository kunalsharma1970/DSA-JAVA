class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less=0; int equal=0; int big=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot) less++;
            else if(nums[i]==pivot) equal++;
            else big++;
        }
        int les[]=new int[less]; int l=0;
        int equl[]=new int[equal]; int e=0;
        int []bg=new int[big]; int b=0;
        int []total=new int[nums.length]; int t=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                les[l]=nums[i];
                l++;
            }else if(nums[i]==pivot) {
                equl[e]=nums[i];
                e++;
            }else{
                bg[b]=nums[i];
                b++;
            }
        }
        for(int i=0;i<les.length;i++){
            total[t]=les[i];
            t++;
        }
        for(int i=0;i<equl.length;i++){
            total[t]=equl[i];
            t++;
        }
        for(int i=0;i<bg.length;i++){
            total[t]=bg[i];
            t++;
        }
        return total;
    }
}