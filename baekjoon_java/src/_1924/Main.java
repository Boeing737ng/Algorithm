package _1924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] days = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] n = new int[13];
        n[1] = n[3] = n[5] = n[7] = n[8] = n[10] = n[12] = 31;
        n[4] = n[6] = n[9] = n[11] = 30;
        n[2] = 28;

        int a = 0;
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 1; i < m; i++) {
            a = a + n[i];
        }
        a = a + d;
        System.out.println(days[a % 7]);
    }
}
