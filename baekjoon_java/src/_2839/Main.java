package _2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        minimumCount(size);
        System.out.println(count);
    }

    public static void minimumCount(int n) {
        while (n % 5 != 0 && n > 0) {
            n -= 3;
            count++;
        }
        if(n < 0) {
            count = -1;
        } else {
            count = count + (n / 5);
        }
    }
}
