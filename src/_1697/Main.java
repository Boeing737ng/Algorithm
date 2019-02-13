package _1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int a, b;
    static int visited[] = new int[100000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        bfs();
    }
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        int next = a;
        q.add(next);
        visited[a] = 1;

        while(!q.isEmpty()) {

        }
    }
}
