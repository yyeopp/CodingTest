package swea;

import java.io.*;
import java.util.*;

public class SWEA7465 {
	static int N;
	static int[] parents;


	static void makeSet() {

		parents = new int[N+1];

		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

	}

	static int findSet(int a) {

		if (a == parents[a]) {
			return a;
		} else {
			return parents[a] = findSet(parents[a]);
		}
	}

	static boolean union(int a, int b) {

		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		} else {
			parents[bRoot] = aRoot;
			return true;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());
			makeSet();
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				union(a,b);
			}
			HashSet<Integer> muri = new HashSet<>();
			for (int i = 1; i < N+1; i++) {
				muri.add(findSet(i));
			}
			sb.append(muri.size()).append("\n");
			
		}
		System.out.println(sb);
	}

}
