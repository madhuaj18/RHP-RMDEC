import java.util.*;

public class MinusTwo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while(x-->0){
            int n = sc.nextInt();
            int odd=0, eeq=0, eoq=0; // eeq-even:even quotient, eoq-even: odd
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(arr[i]%2==0){
                    if((arr[i]/2)%2==0){
                        eeq++;
                    }
                    else{
                        eoq++;
                    }
                }
                else{
                    odd++;
                }
            }
            System.out.println(Math.max(Math.max(eeq, eoq), odd));
        }
        sc.close();
    }
}
