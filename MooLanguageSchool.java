import java.util.*;

public class MooLanguageSchool {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        while(--x >=0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            boolean owns[] = new boolean[n/k];
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    owns[i/k] = true;
                }
            }

            int count=0;
            for(int i=0;i<n/k;i++){
                if(owns[i] == false){
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
