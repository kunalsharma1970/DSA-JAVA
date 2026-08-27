class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words){
            int start=0;
            int end=word.length()-1;
            boolean isPalendrome=true;
            
            while (start<end){
                if (word.charAt(start) != word.charAt(end)){
                    isPalendrome = false;
                    break;
                }
                start++;
                end--;
            }
            
            if (isPalendrome){
                return word;
            }
        }
        return "";
    }
}
