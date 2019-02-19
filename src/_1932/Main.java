package _1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new int[501][501];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; st.hasMoreTokens(); j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        intTriangle();
        System.out.println(result);
    }
    public static void intTriangle() {
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    list[i][j] = list[i][j] + list[i - 1][j];
                } else if (j == i) {
                    list[i][j] = list[i][j] + list[i - 1][j - 1];
                } else {
                    list[i][j] = Math.max(list[i - 1][j - 1] + list[i][j], list[i - 1][j] + list[i][j]);
                }

                if(result < list[i][j]) {
                    result = list[i][j];
                }
            }
        }
    }
}
