//leetcode 1926
class Solution {
    final static int diff[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public int nearestExit(char[][] maze, int[] entrance) {

        int R = maze.length;
        int C = maze[0].length;

        
        int row = entrance[0], col = entrance[1];
        maze[row][col] = '!'; // marking the entrance with a diff char
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { row, col, 0 });

        while (!queue.isEmpty()) {

            int q[] = queue.poll(); // [0, 1, 2] = [row, col, steps]

            for (int i = 0; i < 4; i++) {
                int ar = q[0] + diff[i][0], ac = q[1] + diff[i][1];

                if (ar >= 0 && ar < R && ac >= 0 && ac < C && maze[ar][ac] == '.') {
                    if(ar==0 || ar==R-1 || ac==0 || ac==C-1){
                        //if(maze[ar][ac] != '!'){
                            return q[2]+1;
                        //}
                    }

                    queue.add(new int[]{ar, ac, q[2]+1});
                    maze[ar][ac] = '+';
                }
            }
        }
        return -1;
    }
}