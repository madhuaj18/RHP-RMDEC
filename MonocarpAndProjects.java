import java.util.*;

public class MonocarpAndProjects {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            long x = sc.nextLong();
            long y = sc.nextLong();
            long k = sc.nextLong();

            long projects = 0;
            long ctr = 0;

            while(ctr<k){
                long rem = (y+ctr)%(x+ctr);
                if(rem == (y-x)) break;
                projects+=rem;
                ctr++;
                
            }
            if(k>ctr){
                projects += (k-ctr)*(y-x);
            }

            System.out.println(projects);
        }
        sc.close();
    }
}
