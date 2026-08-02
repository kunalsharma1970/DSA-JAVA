class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0; int right=nums.length-1;
        int res[]=new int[nums.length];int s=res.length-1;
        while(left<=right){
            int leftsq=nums[left]*nums[left];
            int rightsq=nums[right]*nums[right];
            if(leftsq>rightsq){
                res[s]=leftsq;
                s--;
                left++;
            }else{
                res[s]=rightsq;
                right--;
                s--;
            }
        }
        return res;
    }
}