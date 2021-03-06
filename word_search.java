/*
LeetCode – Word Search (Java)
 
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.


For example, given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

package interview;

public class practice{
	public boolean exist(char[][] board, String word) {
	    int m = board.length;
	    int n = board[0].length;
	 
	    boolean result = false;
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	           if(dfs(board,word,i,j,0)){
	               result = true;
	               return true;
	           }
	        }
	    }
	 
	    return result;
	}
	 
	public boolean dfs(char[][] board, String word, int i, int j, int k){
	    int m = board.length;
	    int n = board[0].length;
	 
	    if(i<0 || j<0 || i>=m || j>=n){
	        return false;
	    }
	 
	    if(board[i][j] == word.charAt(k)){
	        char temp = board[i][j];
	        board[i][j]='#';
	        if(k==word.length()-1){
	            return true;
	        }else if(dfs(board, word, i-1, j, k+1)
	        ||dfs(board, word, i+1, j, k+1)
	        ||dfs(board, word, i, j-1, k+1)
	        ||dfs(board, word, i, j+1, k+1)){
	            return true;
	        }
	        board[i][j]=temp;
	    }
	 
	    return false;
	}
	
	public static void main(String[] args){
		practice obj = new practice();
		String word = "ABCCED";
		char[][] board = new char[3][4];
		board[0][0]='A';
		board[0][1]='B';
		board[0][2]='C';
		board[0][3]='E';
		board[1][0]='S';
		board[1][1]='F';
		board[1][2]='C';
		board[1][3]='S';
		board[2][0]='A';
		board[2][1]='D';
		board[2][2]='E';
		board[2][3]='E';
										
		System.out.println(obj.exist(board,word));
		
	}
	
	
	
}