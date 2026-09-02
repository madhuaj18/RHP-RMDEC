//leetcode 79

class Solution {
    final static int diff[][] = {{-1,0}, {0,1}, {1,0},{0,-1} };

    public static boolean dfs(int r, int c, int R, int C, char[][] board, String word, boolean vis[][], int idx){

        

        if(board[r][c] != word.charAt(idx)){
            return false;
        }
        if(idx == word.length()-1){
            return true;
        }
        
        vis[r][c]=true;

            for(int i=0;i<4;i++){
                int ar = r+diff[i][0], ac = c+diff[i][1];

                if(idx < word.length() && ar>=0 && ar<R && ac>=0 && ac<C && !vis[ar][ac]){
                    if(dfs(ar, ac, R, C, board, word, vis, idx+1)){ 
                    return true;
                    }
                }
                
            }
        
        vis[r][c] =false;
            
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int idx=0;
        int R = board.length;
        int C = board[0].length;

        boolean vis[][] = new boolean[R][C];
        boolean flag = false;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j] == word.charAt(0))
                    flag = dfs( i,  j,  R,  C, board, word,vis, 0);
                if(flag){
                    for(boolean a[]:vis){
                        System.out.println(a);
                    }

                    return true;
                }
                
            }
        }
        return false;
    }
}