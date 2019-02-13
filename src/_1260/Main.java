package _1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V;
    static int[][] a;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        a = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[x][y] = 1;
            a[y][x] = 1;
        }

        dfs(V);
        visited = new boolean[N+1];
        System.out.println();
        bfs(V);
    }

    public static void dfs(int top) {
        System.out.print(top + " ");
        visited[top] = true;
        for(int i = 1; i <= N; i++) {
            if(a[top][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int top) {
        Queue<Integer> q = new LinkedList<>();
        q.add(top);
        visited[top] = true;

        while(!q.isEmpty()) {
            int first = q.poll();
            System.out.print(first + " ");

            for(int i = 1; i <= N; i++) {
                if(a[first][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
