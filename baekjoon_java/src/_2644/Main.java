package _2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    static int N, M, A, B, level = 0;
    static int[][] a;
    static int[] d = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        a = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parsewInt(st.nextToken());
            a[x][y] = 1;
            a[y][x] = 1;
        }
        if(A == B) {
            System.out.println(0);
            return;
        }
        bfs();
    }
    public static void bfs() {
        q.add(A);
        while(!q.isEmpty()) {
            int start = q.poll();
            for(int i = 1; i <= N; i++) {
                if(a[start][i] != 1 || d[i] != 0) {
                    continue;
                }
                d[i] = d[start] + 1;
                q.add(i);
            }
        }
        System.out.println(d[B]==0?-1:d[B]);
    }
}
