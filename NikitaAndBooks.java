import java.io.IOException;
import java.util.Scanner;

public class NikitaAndBooks {
    public static String isStackNeat(int n, int a[]) {
        long balance = 0;

        for (int i = 0; i < n ; i++) {
            // System.out.print(a[i]+" ");
                if (a[i] == i + 1) {
                    continue;
                }
                else if (a[i] > i + 1) {
                    balance += (a[i] - (i + 1));
                    a[i] = i + 1;
                }
                else if(a[i]< i+1){
                    if(balance>=((i+1)-a[i])){
                        balance-=((i+1) - a[i]);
                        a[i] = i+1;
                    }
                    else{
                        return "No";
                    }
                } 
                // else if (((i + 1) - a[i]) <= balance) {
                //     balance-=((i + 1) - a[i]);
                //     a[i] = i + 1;
                // }
                else if(balance<0 && a[i]>=a[i+1]){
                    return "No";
                }
                
                // System.out.println(i+"-"+ a[i]);            
        }
        boolean flag = false;
        for(int i=0;i<n-1;i++){
            if(a[i]>a[i+1]){
                flag =true;
            }
        }

        if (flag) return "No";

        return "Yes";

    }

    public static void main(String[] args) throws IOException {
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();//Integer.parseInt(bf.readLine());

        while(n>0){ 

            int size = sc.nextInt();//Integer.parseInt(bf.readLine());
            int arr[] = new int[size];

            // String[] tokens = bf.readLine().trim().split("\\s+");

            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();//Integer.parseInt(tokens[i]);
            }

            System.out.println(isStackNeat(size, arr));
            n--;
        }
    }
}
