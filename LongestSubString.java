import java.util.*;

public class LongestSubString{

    public static int substring(String str1, String str2){

        int m = str1.length(), n = str2.length();

        if(m <= Math.pow(10,3) && n <= Math.pow(10,3)){
            int grid[][] = new int[m+1][n+1];
            int maxval=0;

            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    if(str1.charAt(i) == str2.charAt(j)){
                        grid[i][j] = grid[i-1][j-1] + 1;
                        maxval = Math.max(maxval, grid[i][j]);
                    }
                }
            }
            return maxval;   
        }
        return 0;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("***Longest Substring:***");

        System.out.print("Enter String 1: ");
        String str1 = sc.nextLine();

        System.out.print("Enter String 2: ");
        String str2 = sc.nextLine();

        System.out.print("Length of longest substring: " + substring(str1, str2));

        sc.close();
    }
}