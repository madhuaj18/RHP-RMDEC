import java.util.*;

public class UnbelivableArray {

    private static int find(int node, int[] leader){
        if(leader[node] !=node){
            leader[node] = find(leader[node], leader);
        }
        return leader[node];
    }

    private static void join(int lt, int rt, int[] leader){
        leader[find(lt, leader)] = find(rt, leader);
    }
    
    private static void solve(Scanner sc){

        int N = sc.nextInt();
        int Q = sc.nextInt(); // queries

        int arr[] = new int[N+1];
        
        int []leader = new int[N+1];
        Map<Integer, Integer> vlm = new TreeMap<>(); //store the index of leader : valueToLeader map
        Map<Integer, Integer> lvm = new TreeMap<>(); // that index's respective value : leaderToValue map

        for(int i=1;i<N+1;i++){
            arr[i] = sc.nextInt();

            if(vlm.get(arr[i]) == null){
                vlm.put(arr[i], i);
                lvm.put(i, arr[i]);
            }
            leader[i] = vlm.get(arr[i]);
        }
        try{ 

        while( Q-- > 0){
            int t = sc.nextInt();

            if(t==1){
                int x = sc.nextInt();
                int y = sc.nextInt();

                if(x==y){
                    continue; //no need to change
                }
                if(!vlm.containsKey(x)){
                    continue; // element not present in the array
                }
                if(vlm.containsKey(y)){
                    //Both a and y are present in the array
                    // so join
                    join(vlm.get(x), vlm.get(y), leader);
                    lvm.remove(vlm.get(x));
                    vlm.remove(x);
                }
                else{
                    //y is not there in the array
                    int xleader = vlm.get(x); // get the index of x's leader
                    lvm.put(xleader, y);
                    vlm.put(y, xleader); // becomes {y : xleader}

                     // remove that value's leader and stuffs and update it with y
                    vlm.remove(x); // which have {x : xleader}
                }
                
            }
            else{
                // print 
                int idx = sc.nextInt();
                int ultimateleader = find(leader[idx], leader);
                System.out.println(lvm.get(ultimateleader));
            }
        }
    }
    catch(Exception e){
       e.printStackTrace();
    }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int id = sc.nextInt();

        for(int i=1;i<id+1;i++){
            System.out.println("Case "+i+":");
            solve(sc);
        }
        
        sc.close();
    }


    
}
