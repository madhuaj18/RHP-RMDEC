import java.util.*;

public class KarenAndCoffee{

    static final int MAX = 200000;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        int[] diff = new int[MAX+1];

        for (int i=0; i<n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            diff[l] = 1;
            diff[r+1] = -1;
        }

        for (int i=1; i<=MAX; i++) {
            diff[i] += diff[i-1];
        }

        int[] prefix = new int[MAX+1];

        for (int i=1; i<=MAX; i++) {
            prefix[i] = prefix[i-1];

            if (diff[i] >= k) {
                prefix[i]++;
            }
        }

        while (q > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(prefix[y] - prefix[x-1]);
            --q;
        }

        sc.close();
    }
}