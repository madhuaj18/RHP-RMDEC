import java.util.*;

public class Bitwise_azAZ {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int lowerMask = 0;
        int upperMask = 0;

        for(int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
                lowerMask |= (1 << (ch - 'a'));
            }
            else if(ch >= 'A' && ch <= 'Z') {
                upperMask |= (1 << (ch - 'A'));
            }
        }

        int allBits = (1 << 26) - 1;

        if(lowerMask == allBits && upperMask == allBits){ 
            System.out.println("YES");
        }
        else{ 
            System.out.println("NO");
            }
    }
}
