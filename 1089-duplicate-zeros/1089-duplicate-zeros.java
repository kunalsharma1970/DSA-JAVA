class Solution {
    public void duplicateZeros(int[] arr) {
        int []res=new int[arr.length]; int s=0;
        int i=0;
        while(i<arr.length){
            if(arr[i]!=0){
                res[s]=arr[i];
                i++;
                s++;
            }else{
                res[s]=0;
                if(s==res.length-1) break;
                s++;
                res[s]=0;
                s++;
                i++;
            }
            if(s==res.length) break;
        }
        
        int k=0;
        for(int m=0;m<res.length;m++){
            arr[k]=res[m];
            k++;
        }
    }
}