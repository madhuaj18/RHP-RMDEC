import java.util.*;

public class SubstrCombination{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();

        for(int i = 1; i < (1 << len); i++) {
            for(int j = 0; j < len; j++) {
                if((i & (1 << j)) != 0) {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
