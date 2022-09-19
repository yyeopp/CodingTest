package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pQueue.add(Integer.parseInt(br.readLine()));
        }

        int[] houses = new int[N];

        for (int i = 0; i < houses.length; i++) {
            houses[i] = pQueue.poll();
        }

        int end = houses[N - 1] - houses[0] + 1;
        int start = 1;

        while (end - start > 1) {
            int mid = (start + end) / 2;
            if (ableToSetAP(C, mid, houses)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);


    }

    private static boolean ableToSetAP(int C, int distance, int[] houses) {
        int num = 1;
        int house = houses[0];
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - house >= distance) {
                num++;
                house = houses[i];
            }
        }
        return num >= C;

    }


}
