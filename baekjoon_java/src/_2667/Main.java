package _2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] a;
    static int N;
    static boolean[][] visited;
    static int numOfHouse;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        a = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < N; j++) {
                a[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(a[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }
        list.sort(null);
        printResult();
    }

    public static void printResult() {
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void bfs(int y, int x) {
        int[] move_x = {-1,1,0,0};
        int[] move_y = {0,0,-1,1};

        Queue<DOT> q = new LinkedList<>();
        q.add(new DOT(x,y));
        visited[y][x] = true;
        numOfHouse = 1;
        while(!q.isEmpty()) {
            DOT dot = q.poll();
            for(int i = 0; i < 4; i++) {
                int next_x = dot.x + move_x[i];
                int next_y = dot.y + move_y[i];

                if(next_x >= N || next_y >= N || next_x < 0 || next_y < 0) {
                    continue;
                }
                if(a[next_y][next_x] == 0 || visited[next_y][next_x]) {
                    continue;
                }

                q.add(new DOT(next_x, next_y));
                visited[next_y][next_x] = true;
                numOfHouse++;
            }
        }
        list.add(numOfHouse);
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