package _9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s1,s2;
    static int[][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        list = new int[s1.length()+1][s2.length()+1];
        for(int i = 1; i <= s1.length(); i++) {
            char c1 = s1.charAt(i-1);
            for(int j = 1; j <= s2.length(); j++) {
                char c2 = s2.charAt(j-1);
                if(c1 == c2) {
                    list[i][j] = list[i-1][j-1] + 1;
                } else {
                    list[i][j] = Math.max(list[i-1][j], list[i][j-1]);
                }
            }
        }
        System.out.println(list[s1.length()][s2.length()]);
    }
}
