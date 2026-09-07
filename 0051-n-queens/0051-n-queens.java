
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, n, ans, new ArrayList<>());

        return ans;
    }

    public void solve(char[][] board, int row, int n,List<List<String>> ans, List<String> list) {
        if (row == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {

            if (check(board, row, i)) {
                board[row][i] = 'Q';
                list.add(new String(board[row]));
                solve(board, row + 1, n, ans, list);
                list.remove(list.size() - 1);
                board[row][i] = '.';
            }
        }
    }

    public boolean check(char[][] board, int row, int c) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = c + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = c - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
