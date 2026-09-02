import java.util.*;

public class OneDCountry {
    static int upperBound(int[] arr, int x) {
    int l = 0, r = arr.length;

    while (l < r) {
        int mid = (l + r) / 2;

        if (arr[mid] <= x)
            l = mid + 1;
        else
            r = mid;
    }

    return l;
}
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int loc[] = new int[N];
        long vpsum[] = new long[N+1]; // villegers prefix sum array

        for(int i=0;i<N;i++) loc[i] = sc.nextInt();
        for(int i=1;i<N+1;i++) vpsum[i] = vpsum[i-1] + sc.nextLong();

        int Q = sc.nextInt();

        while(Q>0){
            int ql = sc.nextInt();
            int qr = sc.nextInt();
            int lb = Arrays.binarySearch(loc, ql);
            lb = lb<0 ? -lb-1 : lb;

            int ub = upperBound(loc, qr);
            // if (ub < 0) {
            //     ub = -ub - 1;
            // } else {
            //     while (ub > 0 && loc[ub + 1] == qr) {
            //         ub++;
            //     }
            // }

            int left = lb;
            int right = ub;

            System.out.println(vpsum[right] - vpsum[left]);

            Q--;
        }
    }
}
