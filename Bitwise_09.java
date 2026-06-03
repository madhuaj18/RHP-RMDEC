import java.util.*;

public class Bitwise_09 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int mask = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= '0' && ch <= '9') 
                mask |= (1 << (ch - '0'));
        }

        int all = (1 << 10) - 1;

        System.out.println((mask == all)?"Yes":"No");
    }
}
