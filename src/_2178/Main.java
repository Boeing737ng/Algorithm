package _2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<DOT> q = new LinkedList<>();
    static int[][] a;
    static boolean[][] visited;
    static int N,M;
    public static void main(String[] args) throws IOException {
        setArray();
        bfs();
    }

    public static void setArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < M; j++) {
                a[i][j] = (line.charAt(j) - '0');
            }
        }
        q.add(new DOT(0,0));
        visited[0][0] = true;
    }

    public static void bfs() {
        int[] move_x = {-1,1,0,0};
        int[] move_y = {0,0,-1,1};
        int count = 0;
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
                System.out.println("y: " + next_y + ", x: " + next_x);
                a[next_y][next_x] = a[dot.y][dot.x] + 1;
                q.add(new DOT(next_x, next_y));
                visited[next_y][next_x] = true;

            }
        }
        System.out.println(a[N-1][M-1]);
    }
}

class DOT {
    int x;
    int y;
    DOT(int x, int y) {
        this.x = x;
        this.y = y;
    }
}