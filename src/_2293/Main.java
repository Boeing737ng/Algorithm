package _2293;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static int[] coin, memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coin = new int[n];
        memo = new int[k+1];
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        memo[0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                if(j - coin[i] >= 0) {
                    memo[j] += memo[j - coin[i]];
                }
            }
        }
        System.out.println(memo[k]);
    }
}