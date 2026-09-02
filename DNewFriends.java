import java.util.*;

public class DNewFriends {

    public static int find(int n, int[] leader){
        if(leader[n] !=n){
            leader[n] = find(leader[n], leader);
        }

        return leader[n];
    }

    public static void join(int lt, int rt, int []leader){
        int ltleader = find(lt, leader);
        int rtleader = find(rt, leader);
        leader[rtleader] = ltleader;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // no. of users
        int M = sc.nextInt(); // no. of edges

        int leader[] = new int[N+1];
        int group_count[] = new int[N+1];
        int edge_count[] = new int[N+1];

        for(int i=0;i<N+1; i++){
            leader[i] = i;
        }

        for(int e=0;e<M;e++){ // e means edges
            int lt = sc.nextInt();
            int rt = sc.nextInt();

            join(lt, rt, leader);
            edge_count[find(lt, leader)]++;
        }
        

        for(int i=1; i<N+1; i++){
            int x = find(i, leader);
            group_count[x]++;
        }
        
        long total_connections, existing_connections;
        long final_connections = 0;

        for(int i=1;i<N+1;i++){
            if(group_count[i]!=0){
                total_connections = (group_count[i] * (group_count[i]-1))/2;
                existing_connections = edge_count[i];
                final_connections += total_connections-existing_connections;
                
            }
        }
        System.out.println("No. of new Connections: "+ final_connections);

        sc.close();
    }
}
