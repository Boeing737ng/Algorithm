package _1890;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] list;
    static long[][] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        memo = new long[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp();
        System.out.println(memo[N-1][N-1]);
    }
    public static void dp() {
        memo[0][0] = 1;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(memo[i][j] == 0 || (i==N-1 && j==N-1)) {
                    continue;
                }
                int jump = list[i][j];
                int right = jump + j;
                int down = jump + i;
                if(right < N) {
                    memo[i][right] += memo[i][j];
                }
                if(down < N) {
                    memo[down][j] += memo[i][j];
                }
            }
        }
    }
}

// bfs - 메모리 초과 뜸 (이 문제는 bfs로 풀면 안된다!! DP를 사용하자)
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int N,count = 0;
//    static int[][] list;
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        N = Integer.parseInt(br.readLine());
//        list = new int[N][N];
//        for(int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < N; j++) {
//                list[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        bfs();
//    }
//    public static void bfs() {
//        Queue<DOT> q = new LinkedList<>();
//        q.add(new DOT(0,0));
//        int[] move_x = {0,0};
//        int[] move_y = {0,0};
//        while(!q.isEmpty()) {
//            DOT dot = q.poll();
//            move_x[0] = list[dot.y][dot.x];
//            move_y[1] = list[dot.y][dot.x];
//            for(int i = 0; i < 2; i++) {
//                int next_x = dot.x + move_x[i];
//                int next_y = dot.y + move_y[i];
//
//                if(next_x >= N || next_y >= N) {
//                    continue;
//                }
//                if(list[next_y][next_x] == 0) {
//                    count++;
//                } else {
//                    q.add(new DOT(next_x,next_y));
//                }
//            }
//        }
//        System.out.println(count);
//    }
//}
//class DOT {
//    int x;
//    int y;
//    DOT(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
