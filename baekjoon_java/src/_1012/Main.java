package _1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<DOT> q = new LinkedList<>();
    static int T, M, N, K, Total = 0;
    static boolean[][] visited;
    static int[][] a;
    public static void main(String[] args) throws IOException {
        setArray();
    }
    public static void setArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            a = new int[N][M];
            visited = new boolean[N][M];
            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                a[y][x] = 1;
            }
            start();
            Total = 0;
        }
    }
    public static void start() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(a[i][j] == 1 && !visited[i][j]) {
                    q.add(new DOT(i, j));
                    visited[i][j] = true;
                    bfs();
                    Total++;
                }
            }
        }
        System.out.println(Total);
    }
    public static void bfs() {
        int[] move_x = {-1,1,0,0};
        int[] move_y = {0,0,-1,1};
        while(!q.isEmpty()) {
            DOT dot = q.poll();
            for(int i = 0; i < 4; i++) {
                int next_x = dot.x + move_x[i];
                int next_y = dot.y + move_y[i];

                if(next_x >= M || next_y >= N || next_x < 0 || next_y < 0) {
                    continue;
                }
                if(visited[next_y][next_x] == true || a[next_y][next_x] == 0) {
                    continue;
                }
                q.add(new DOT(next_y, next_x));
                visited[next_y][next_x] = true;
            }
        }
    }
}
class DOT {
    int y;
    int x;
    DOT(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
