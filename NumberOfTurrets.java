import java.util.*;

public class NumberOfTurrets{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //number of castle
        int T = sc.nextInt(); //no of turrets

        int[] walls = new int[N+2];

        while(T>0){
            int lt = sc.nextInt();
            int rt = sc.nextInt();

            walls[lt]++;
            walls[rt+1]--;
            --T;
        }
        int result = 200001;

        for(int w=1; w<N+1; w++){
            walls[w]+=walls[w-1];
            result = Math.min(result, walls[w]);
        }

        System.out.println(result);

        sc.close();
    }
}