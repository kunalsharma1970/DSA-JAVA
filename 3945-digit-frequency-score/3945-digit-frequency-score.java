class Solution {
    public int digitFrequencyScore(int n) {
        int sum=0; 
        while(n>0){
            int last=n%10;
            sum+=last;
            n=n/10;
        }
        return sum;
    }
}