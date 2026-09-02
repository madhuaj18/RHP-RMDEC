import java.util.*;

public class StaticRangeSumQueries {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int arr[] = new int[n+1]; //prefix sum array

        for(int i=1;i<n+1;i++){ 
            arr[i] = arr[i-1] + sc.nextInt();
        }

        while(q>0){

            int x=sc.nextInt(), y=sc.nextInt();
            int output = arr[y] - arr[x-1];
            System.out.println(output);
            q--;
        }
        sc.close();
    }
}
