import java.util.PriorityQueue;

public class N3 {

	static class Vertex {
		int idx;
		int val;

		public Vertex(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}

	}

	public static void main(String[] args) {

		int N = 5;
		int[] A = { 2, 2, 1, 2 };
		int[] B = { 1, 3, 4, 4 };

		int[] vertices = new int[N + 1];

		for (int i = 0; i < A.length; i++) {
			vertices[A[i]]++;
			vertices[B[i]]++;
		}

		PriorityQueue<Vertex> pQueue = new PriorityQueue<>((Vertex v1, Vertex v2) -> (v2.val - v1.val));

		for (int i = 0; i < vertices.length; i++) {
			pQueue.add(new Vertex(i, vertices[i]));
		}

		int sum = 0;

		for (int i = 0; i < vertices.length; i++) {
			Vertex v = pQueue.poll();
			sum += (v.val * N);
			N--;
		}
		System.out.println(sum);

	}

}
