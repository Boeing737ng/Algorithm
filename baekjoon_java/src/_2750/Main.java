package _2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int j;
        int[] list = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < n; i++) {
            int temp = list[i];
            for(j = i-1; j >=0 && list[j] > temp; j--) {
                list[j+1] = list[j];
            }
            list[j+1] = temp;
        }
        for(int i = 0; i < n; i++) {
            System.out.println(list[i]);
        }
    }
}
