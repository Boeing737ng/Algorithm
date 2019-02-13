package _1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list, temp;
    static int N,M,pointer,result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>(Collections.nCopies(N, 0));
        temp = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            list.set(a - 1, a);
            temp.add(a);
        }
        for(int i = 0; i < M; i++) {
            int value = temp.get(i);
            int left = searchleft(value);
            int right = list.size() - left;
            if(left <= right) {
                result += left;
            } else {
                result += right;
            }
            pointer = list.indexOf(value);
            list.remove(pointer);
            if(pointer == list.size()) {
                pointer = 0;
            }

        }
        System.out.println(result);
    }
    public static int searchleft(int dest) {
        int count = 0;
        while(true) {
            if(list.get(pointer) == dest) {
                return count;
            }
            pointer--;
            if(pointer < 0) {
                pointer = list.size() - 1;
            }
            count++;
        }
    }
}
