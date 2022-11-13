import java.util.*;

public class KB04 {

	static class Operation {
		int req;
		int due;
		int category;
		int priority;

		public Operation(int req, int due, int category, int priority) {
			this.req = req;
			this.due = due;
			this.category = category;
			this.priority = priority;
		}

	}

	static Operation[] operations;
	static Map<Integer, Queue<Operation>> map;
	static int[] priorities;

	public static void main(String[] args) {

		int[][] jobs = { { 0, 2, 3, 1 }, { 5, 3, 3, 1 }, { 10, 2, 4, 1 } };
		operations = convertJobsToOperations(jobs);

		List<Integer> result = new ArrayList<Integer>();

		map = new HashMap<Integer, Queue<Operation>>();
		priorities = new int[101];

		boolean spinning = false;
		int category = 0;

		int time = operations[0].req;
		int idx = 0;

		while (true) {
			if (idx < operations.length && operations[idx].req <= time) {
				if (!map.containsKey(operations[idx].category)) {
					map.put(operations[idx].category, new LinkedList<Operation>());
				}
				enqueueNewOperation(idx);
				idx++;
				continue;
			}

			if (spinning) {
				Queue<Operation> queue = map.get(category);

				if (queue.isEmpty()) {
					spinning = false;
				} else {
					Operation o = queue.poll();
					time += o.due;
					priorities[category] -= o.priority;
				}

			} else {
				category = getNextCategory(priorities);
				if (isOver(category, idx)) {
					break;
				}
				if (isAllEmpty(category)) {
					time = operations[idx].req;
					continue;
				}
				if (isNewCategory(result, category)) {
					result.add(category);
				}
				spinning = true;

			}
		}

		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}

		System.out.println(Arrays.toString(answer));
	}

	private static Operation[] convertJobsToOperations(int[][] jobs) {
		Operation[] operations = new Operation[jobs.length];

		for (int i = 0; i < operations.length; i++) {
			operations[i] = new Operation(jobs[i][0], jobs[i][1], jobs[i][2], jobs[i][3]);
		}

		return operations;
	}

	private static void enqueueNewOperation(int idx) {
		Queue<Operation> queue = map.get(operations[idx].category);
		queue.add(operations[idx]);
		priorities[operations[idx].category] += operations[idx].priority;
	}

	private static int getNextCategory(int[] priorities) {
		int max = 0;
		int result = 0;

		for (int i = 0; i < priorities.length; i++) {
			if (priorities[i] > max) {
				max = priorities[i];
				result = i;
			}
		}
		if (max == 0) {
			return -1;
		}

		return result;
	}

	private static boolean isOver(int category, int idx) {
		return isAllEmpty(category) && idx >= operations.length;
	}

	private static boolean isAllEmpty(int category) {
		return category == -1;
	}

	private static boolean isNewCategory(List<Integer> result, int category) {
		return result.isEmpty() || category != result.get(result.size() - 1);
	}

}
