import java.util.*;

public class IHateSigmaProblem {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        long sum=0, lastsum=0;
        int prev[] = new int[N+1];

        for(int i=N-1;i>=0;i--){
            lastsum-= prev[arr[i]];
            lastsum+= prev[arr[i]] = N-i; // N-i is the position from the end
            sum+=lastsum;
        }
        System.out.println(sum);
    }
}
  