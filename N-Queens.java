class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean board[][]=new boolean[n][n];
        List<List<String>> ans=new ArrayList<>();
        List<String> ll=new ArrayList<>();
        Print(board,ans,ll,n,0);
        return ans;
    }
    public static boolean isSafe(boolean[][] board, int row, int col) {
		// left diagonal
		int r = row;
		int c = col;
		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c--;
		}

		// right diagonal
		r = row;
		c = col;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c++;
		}

		// up

		r = row;
		while (r >= 0) {
			if (board[r][col]) {
				return false;
			}
			r--;
		}
		return true;
	}

    public static void Print(boolean[][] board,List<List<String>> ans,List<String> ll,int tq,int row){
        if(tq==0){
            ans.add(new ArrayList<>(ll));
            return;
        }

        for(int col=0;col<board[0].length;col++){
           if(isSafe(board,row,col)){
             board[row][col]=true;
               char[] rowString = new char[board.length];
                Arrays.fill(rowString, '.');
                rowString[col] = 'Q';
                ll.add(new String(rowString));
            Print(board,ans,ll,tq-1,row+1);
            ll.remove(ll.size()-1);
            board[row][col]=false;
        }
    }
        }
}