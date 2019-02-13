package _2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N = 0;
    static int[] list;
    static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        sorted = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(list, 0, N-1);
    }
    public static void mergeSort(int[] a, int start, int end) {
        int mid;
        if(end > start) {
            mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }
    public static void merge(int[] a, int start, int middle, int end) {
        int i = start;             // 첫 번째 부분집합의 시작 위치 설정
        int j = middle+1;     // 두 번째 부분집합의 시작 위치 설정
        int k = start;             // 배열 sorted에 정렬된 원소를 저장할 위치 설정

        while(i<=middle && j<=end) {
            if(a[i]<=a[j]) {
                sorted[k] = a[i];
                i++;
            }else {
                sorted[k] = a[j];
                j++;
            }
            k++;
        }
        if(i>middle) {
            for(int t=j;t<=end;t++,k++) {
                sorted[k] = a[t];
            }
        }else {
            for(int t=i;t<=middle;t++,k++) {
                sorted[k] = a[t];
            }
        }

        for(int t=start;t<=end;t++) {
            a[t] = sorted[t];
        }
        System.out.println("병합 정렬 후: "+Arrays.toString(a));


    }
}
