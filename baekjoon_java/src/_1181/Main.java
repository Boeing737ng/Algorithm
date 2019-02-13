package _1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N = 0;
    static String[] list;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new String[N];
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        sort();
        for(int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
    public static void sort() {
        list = new String[set.size()];
        set.toArray(list);
        Arrays.sort(list); // sort by dictionary value
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 1 if o1 is longer
                // 0 if same length
                // -1 if o2 is longer
                return Integer.compare(o1.length(), o2.length());
            }
        });
    }
}