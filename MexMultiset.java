import java.util.*;

public class MexMultiset {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        while(q-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            List<Integer> zi = new ArrayList<>();

            for(int i=0;i<n;i++){
                arr[i] =sc.nextInt();
                if(arr[i]==0){
                    zi.add(i);
                }
            }

            if(zi.size()==1){
                System.out.println("NO");
                continue;
            }

            String[] strArr = new String[n];
            Arrays.fill(strArr, "C");
            if(!zi.isEmpty()){ 
                strArr[zi.get(0)] = "B";
                for(int i=1;i<zi.size();i++){
                        strArr[zi.get(i)] = "A";
                    }
                }

            System.out.println("YES");
            for(String s: strArr){
                System.out.print(s);
            }
            System.out.println();
        }
        sc.close();
    }
}
