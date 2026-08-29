class Solution {
    static void generate(int open ,int n,int close,ArrayList<String>list,StringBuilder sb){
        if(open==n && close==n){
            list.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append('(');
            generate(open+1,n,close,list,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            generate(open,n,close+1,list,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list=new ArrayList<>();
        int open=0; int close=0;
        StringBuilder sb=new StringBuilder();
        generate(open,n,close,list,sb);
        return list;
    }
}