import java.util.*;

public class ManyRepunitSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        long carryfwd = 0; // could be soo larger

        List<Long> result = new LinkedList<>();

        for(int ctr=1; ctr<=arr[n-1]; ctr++){
            int lb = Arrays.binarySearch(arr, ctr);
            
            if(lb<1){lb=-lb-1;}
            System.out.print(lb+"\n");

            int count = n-lb;
            carryfwd+= count;
            result.add(carryfwd%10);
            carryfwd/=10;
        }

        while(carryfwd!=0){
            result.add(carryfwd%10);
            carryfwd/=10;
        }

        Collections.reverse(result);
        for(long x: result){
            System.out.print(x+" ");
        }
        sc.close();
    }
}
