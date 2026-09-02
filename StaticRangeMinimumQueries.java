import java.util.*;

public class StaticRangeMinimumQueries {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        long arr[] = new long[N+1];

        long output[] = new long[Q];

        for(int i=1;i<N+1;i++){
            arr[i]= sc.nextLong();
        }
        int x=0;
        for(int j=0;j<Q;j++){

            int lt = sc.nextInt();
            int rt = sc.nextInt();

            long min =arr[lt];

            for(int i=lt+1; i<=rt;i++){
                min = Math.min(min, arr[i] );
            }

            output[x] = min;
            x++;
        }
        for(long a: output){
            System.out.println(a);
        }

        sc.close();
    }
}
