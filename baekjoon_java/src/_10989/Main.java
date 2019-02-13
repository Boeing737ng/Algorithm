package _10989;

import java.io.*;

public class Main {
    static int N = 0;
    static int[] list;
    static int[] countingList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        countingList = new int[10001];
        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            countingList[list[i]]++;
        }
        countingSort();
    }
    public static void countingSort() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 10001; i++) {
            for(int j = 0; j < countingList[i]; j++) {
                bw.write(Integer.toString(i) + '\n');
            }
        }
        bw.close();
    }
}
