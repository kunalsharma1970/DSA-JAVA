class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            sb.append(ch);
        }
        int i=0; int j=sb.length()-1;
        while(i<j){
            if(Character.isLetter(sb.charAt(i)) && Character.isLetter(sb.charAt(j))){
                char temp=sb.charAt(i);
                sb.setCharAt(i,sb.charAt(j));
                sb.setCharAt(j,temp);
                i++;
                j--;
            }else if(Character.isLetter(sb.charAt(i)) && !Character.isLetter(sb.charAt(j))) j--;
            else i++;
        }
        return sb.toString();
    }
}