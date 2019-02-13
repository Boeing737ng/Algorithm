package _2309;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;

public class Main {
    static int sum = 0;
    static int[] dwarf = new int[9];
    static boolean done = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            dwarf[i] += height;
            sum += height;
        }
        for(int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++) {
                if(sum - (dwarf[i] + dwarf[j]) == 100) {
                    dwarf[i] = 101;
                    dwarf[j] = 101;
                    done = true;
                    break;
                }
                if(done) break;
            }
        }
        Arrays.sort(dwarf);
        for(int i = 0; i < 7; i++) {
            System.out.println(dwarf[i]);
        }
    }
}
