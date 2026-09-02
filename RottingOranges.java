//leetcode 994

class Solution {

    final static int diff[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    
    public int orangesRotting(int[][] grid) {
        int minutes = -1;

        int R = grid.length;
        int C = grid[0].length;

        boolean rotten[][] = new boolean[R][C];

        int fresh=0, rot=0;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j] == 2) {
                    rot++;
                    queue.add(new int[]{i, j});
            }
            }
        }
        if(fresh!=0 && rot == 0){
            return -1;
        }
        if(fresh == 0 ){
            return 0;
        }

        int oranges = fresh+rot;

        int qsize = queue.size();
        System.out.println(qsize);

        while(!queue.isEmpty()){
            System.out.println(qsize);
            minutes++;
            while(qsize>0){ 
            
            int idx[] = queue.poll();
            int r = idx[0], c = idx[1];

            for(int i=0;i<4;i++){
                int ar = r+diff[i][0], ac = c+ diff[i][1];
                if(ar>=0 && ar<R && ac>=0 && ac<C && grid[ar][ac]==1){
                    fresh--;
                    rot++;
                    queue.add(new int[]{ar, ac});
                    grid[ar][ac] = 2;
                    
                
                }
            }
            qsize--;
            }
            qsize = queue.size();
        }

        if(oranges == rot){
            return minutes;
        }
        
        
        return -1;
}
}