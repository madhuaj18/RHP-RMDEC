import java.util.*;

public class CarrotChopdown {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        while(a-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int ctr[] = new int[m+1];
            
            for(int i=1;i<=n;i++){
                int curr = sc.nextInt();
                ctr[curr]++;
            }

            int psum[] = new int[m+1];
            for(int i=1;i<=m;i++){
                psum[i] = psum[i-1] + ctr[i];
            }
            int ans=0;

            for(int i=1;i<=m;i++){
                int carrotcnt = psum[m] - psum[i-1];
                if(2*i<=m){
                    carrotcnt+= ctr[2*i];
                }
                ans=Math.max(ans, carrotcnt);
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
