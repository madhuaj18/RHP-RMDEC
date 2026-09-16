import java.util.*;

public class MonocarpsContest{
    final public static Scanner sc = new Scanner(System.in);

    private static void solve(){
        int n = sc.nextInt();
        int arr[] = new int[n];
        int oc =0;

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            oc += arr[i];
        }

        int zc = n-oc, ans=0;

        if(zc<2){
            System.out.println(-1);
            return;
        }

        if(arr[0]==1) ans++;
        if(arr[n-1]==1) ans++;

        System.out.println(ans);

    }
    public static void main(String args[]){
        int t = sc.nextInt();
        while(t-->0){
            solve();
        }
    }
}