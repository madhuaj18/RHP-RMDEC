public class Solution {
    private static int find(int node, int leader[]){
        if(leader[node] != node){
            leader[node] = find(leader[node], leader);
        }

        return leader[node];
    }

    private static void join(int lt, int rt, int leader[]){
        int ltleader = find(lt, leader);
        int rtleader = find(rt, leader);

        leader[rtleader] = ltleader;
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int leader[] = new int[n+1];
        int group_count[] = new int[n+1];

        for(int i=0;i<n+1;i++){
            leader[i]=i;
        }

        for(int i=1;i<isConnected.length+1; i++){
            for(int j=1;j<isConnected[0].length+1;j++){
                if(isConnected[i-1][j-1] == 1){
                    join(i, j, leader);
                }
            }
        }
        for(int i=1;i<n+1;i++){
            group_count[find(i, leader)]++;
            System.out.print(group_count[i]);

        }

        int final_connections = 0;
        
        for(int i=1;i<n+1;i++){
            if(group_count[i]!=0){
                final_connections++;
                
            }
        }
       return final_connections;

    }
} {
    
}
