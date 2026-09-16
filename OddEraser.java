import java.util.*;

public class OddEraser {
    public static int hcf(int a, int b) {
        return b == 0 ? a : hcf(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        while (m-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(hcf(arr[0], arr[n - 1]));
        }
        sc.close();
    }
}
