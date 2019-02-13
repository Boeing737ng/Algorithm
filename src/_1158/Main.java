package _1158;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int M,N,kill = 0;
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()) - 1;
        for(int i = 1; i <= N; i++) {
            list.add(Integer.toString(i));
        }
        bw.write("<");
        while(!list.isEmpty()) {
            kill += M;
            if(kill >= list.size()) {
                kill %= list.size();
            }
            if(list.size() > 1) {
                bw.write(list.remove(kill) + ", ");
            } else {
                bw.write(list.remove(kill));
            }
        }
        bw.write(">");
        bw.flush();
    }
}
