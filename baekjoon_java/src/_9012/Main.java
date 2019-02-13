package _9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N = 0;
    static Stack<Character> stack = new Stack<>();
    static String line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            line = br.readLine();
            vps();
        }
    }
    public static void vps() {
        char paren;
        for(int i = 0; i < line.length(); i++) {
            paren = line.charAt(i);
            if(paren == '(') {
                stack.push(paren);
            } else {
                if(stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        while(!stack.isEmpty()) {
            stack.pop();
        }
    }
}
