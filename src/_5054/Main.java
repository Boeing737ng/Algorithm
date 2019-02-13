package _5054;

//2
//4
//24 13 89 37
//6
//7 30 41 14 39 42

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int min = 100;
            int max = 0;
            while(st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                if(a > max) {
                    max = a;
                }
                if(a < min) {
                    min = a;
                }
            }
            System.out.println((max - min) * 2);
        }
    }
}
