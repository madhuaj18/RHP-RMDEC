import java.util.*;

public class TwoDigitString {

    public static int findTwoDigitStringLength(String a, String b) {
        int R = a.length();
        int C = b.length();

        int[] ma = new int[R]; // a modulo 10
        int[] mb = new int[C]; // b modulo 10

        ma[0] = a.charAt(0) - '0';
        mb[0] = b.charAt(0) - '0';

        for (int i = 1; i < R; i++) {
            ma[i] = (ma[i - 1] + (a.charAt(i) - '0')) % 10;
        }

        for (int j = 1; j < C; j++) {
            mb[j] = (mb[j - 1] + (b.charAt(j) - '0')) % 10;
        }

        if (ma[R - 1] == mb[C - 1]) {
            int dp[][] = new int[R + 1][C + 1];

            for (int i = 1; i < R + 1; i++) {
                for (int j = 1; j < C + 1; j++) {
                    if (ma[i - 1] == mb[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[R][C];
        }

        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n > 0) {

            String a = sc.next();
            String b = sc.next();

            System.out.println(findTwoDigitStringLength(a, b));

        }
        sc.close();
    }
}
