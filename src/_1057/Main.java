package _1057;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, kim, lim, stage = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        kim = Integer.parseInt(st.nextToken());
        lim = Integer.parseInt(st.nextToken());

        while(kim != lim) {
            kim = kim/2 + kim%2;
            lim = lim/2 + lim%2;
            stage++;
        }
        System.out.println(stage);
    }
}
