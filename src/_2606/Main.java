package _2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] a;
    static int N, connected_count;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        connected_count = Integer.parseInt(br.readLine());

        a = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < connected_count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            a[x][y] = 1;
            a[y][x] = 1;
        }
        bfs();
    }
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int count = 0;
        while(!q.isEmpty()) {
            int top = q.poll();
            for(int i = 1; i <= N; i++) {
                if(a[top][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
