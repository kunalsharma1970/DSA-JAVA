class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0; int right=people.length-1; int count=0;int sum=0;
        while(left<=right){
            if(left==right) sum+=people[left];
            else  sum=people[left]+people[right];
        
            if(sum<=limit){
                count++;
                left++;
                right--;
            }else {
                count++;
                right--;
            }
        }
        return count;
    }
}