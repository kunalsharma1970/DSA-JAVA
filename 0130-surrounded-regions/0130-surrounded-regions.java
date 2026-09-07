class Solution {
    public void solve(char[][] board) {
        int n=board.length; int m=board[0].length;
        for(int i=0;i<m;i++){
            if(board[0][i]=='O') dfs(board,0,i);
        }
        for(int i=0;i<m;i++){
            if(board[n-1][i]=='O') dfs(board,n-1,i);
        }
        for(int j=0;j<n;j++){
            if(board[j][0]=='O') dfs(board,j,0);
        }
        for(int j=0;j<n;j++){
            if(board[j][m-1]=='O') dfs(board,j,m-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#') board[i][j]='O';
                else board[i][j]='X';
            }
        }
    }
    public boolean valid(char[][]board,int row,int cols){
        if(row<0 || row>=board.length || cols<0 || cols>=board[0].length) return false;
        return true;
    }
    public int[]x={1,-1,0,0};
    public int[]y={0,0,1,-1};
    public void dfs(char[][]board,int row,int cols){
        board[row][cols]='#';
        for(int k=0;k<4;k++){
            int r=row+x[k];
            int c=cols+y[k];
            if(valid(board,r,c) && board[r][c]=='O') dfs(board,r,c);
        }
    }
}