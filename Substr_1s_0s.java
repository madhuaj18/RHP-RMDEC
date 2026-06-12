import java.util.*;
public class Substr_1s_0s{
    public static int substrLen(String str){
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxlen = 0, sum = 0;

        map.put(0,-1);

        for(int i=0;i<str.length();i++){

            if(str.charAt(i)=='0'){
                sum+=-1;
            }
            else{
                sum++;
            }
            if(map.containsKey(sum)){
                maxlen=Math.max(maxlen, i-map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter string with 0's and 1's: ");
        String str = sc.nextLine();
        
        System.out.println("Longest substring length: " + substrLen(str));

        sc.close();
    }
}