package _7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N, V;
    static int[][] a;
    static Queue<DOT> q = new LinkedList<>();
    static int[] move_x = {-1,1,0,0};
    static int[] move_y = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        setArray();
        bfs();
    }

    public static void setArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        a = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] == 1) {
                    q.add(new DOT(i,j));
                }
            }
        }
    }

    public static void bfs() {
        int day = 0;
        while(!q.isEmpty()) {
            DOT dot = q.poll();
            for(int i = 0; i < 4; i++) {
                int next_x = dot.x + move_x[i];
                int next_y = dot.y + move_y[i];

                if(next_x >= N || next_y >= M || next_x < 0 || next_y < 0) {
                    continue;
                }
                if(a[next_x][next_y] != 0) {
                    continue;
                }
                a[next_x][next_y] = a[dot.x][dot.y] + 1;
                q.add(new DOT(next_x, next_y));
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(a[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, a[i][j]);
            }
        }
        System.out.println(day - 1);
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