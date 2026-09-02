import java.util.*;

public class CMinMaxPairs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[] = new int[N+1];

        for(int i=1;i<N+1;i++){
            arr[i] = sc.nextInt();
        }

        long same=0, exchange=0;

        for(int i=1;i<=N;i++){
            if(i == arr[i]){
                same++;
                System.out.println(i+" - "+ same);
            }
            else if(i == arr[arr[i]]){
                exchange++;
                System.out.println(i+" - "+ exchange);
            }
        }
        
        long total = (same*(same-1)/2) + (exchange/2);
        System.out.println(total);
    }
}
