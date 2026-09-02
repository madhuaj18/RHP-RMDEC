import java.util.*;
 

public class CRotation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        
        char[] ch = sc.next().toCharArray();

        if(ch.length != N){
            sc.close();
            return;
        }

        int pos=0;

        while(Q>0){
            int t = sc.nextInt();
            int x = sc.nextInt();
            

            switch(t){
                case 1:
                    pos = (pos+x)%N;
                    break;

                case 2:
                    x%=N;
                    if(pos<0) pos= -pos;

                    System.out.println(ch[(x - pos - 1 + N)%N]);
                    break;
            }

            Q--;
        }

        sc.close();
    }
}
