class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int temp=n;
        int pro=1;
        while(n>0){
            int last=n%10;
            sum+=last;
            pro*=last;
            n=n/10;
        }
        int s=sum+pro;
        if(temp%s==0) return true;
        return false;
    }
}