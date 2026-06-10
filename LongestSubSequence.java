import java.util.*;

public class LongestSubSequence{

    public static int subsequence(String str1, String str2){
        
        int m = str1.length(), n = str2.length();

        if(m <= Math.pow(10,3) && n <= Math.pow(10,3)){
            int grid[][] = new int[m+1][n+1];

            for(int i=1;i<m+1;i++){
                for(int j=1;j<n+1;j++){
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        grid[i][j] = grid[i-1][j-1] + 1;
                    }
                    else{
                        grid[i][j] = Math.max(grid[i][j-1], grid[i-1][j]);
                    }
                }
            }
            return grid[m][n];   
        }
        return 0;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("***Longest Subsequence:***");

        System.out.print("Enter String 1: ");
        String str1 = sc.nextLine();

        System.out.print("Enter String 2: ");
        String str2 = sc.nextLine();

        System.out.print("Length of the longest subsequence: " + subsequence(str1, str2));
    }
}