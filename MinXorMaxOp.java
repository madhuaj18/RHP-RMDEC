import java.util.*;

public class MinXorMaxOp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int x = sc.nextInt();
            int y = sc.nextInt();

            int sum =  x+y;
            int rx=0, ry=0; // revised x and revised y

            for(int sh=30;sh>=0;sh--){//sh - shift
                if((sum & 1<<sh) !=0){
                    if((rx|1<<sh)<=x){
                        rx = rx| 1<<sh; // doing this '|' adds the rx value
                    }
                    else{
                        ry = ry|1<<sh;
                    }
                }
            }
            System.out.println(sum+" "+(x-rx));
        }
        sc.close();
    }
}
