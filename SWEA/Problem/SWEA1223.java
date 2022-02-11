package swea;

import java.io.*;
import java.util.*;


public class SWEA1223 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int T = Integer.parseInt(br.readLine());
			String[] temp = br.readLine().split("");
			Queue<String> list = new LinkedList<>();
			Stack<String> util = new Stack<>();
			for (int i = 0; i < T; i++) {
				if (!temp[i].equals("+") && !temp[i].equals("*")) {
					list.add(temp[i]);
			

				}
				if (temp[i].equals("+")) {
					while(!util.isEmpty()) {
						list.add(util.pop());
					}
					util.add(temp[i]);
				
					
				}
				if (temp[i].equals("*")) {
					
					while((!util.isEmpty())&&!util.peek().equals("+")) {
						list.add(util.pop());
					}
					util.add(temp[i]);
					

				}
				

			}
			while(!util.isEmpty()) {
				list.add(util.pop());
			}

			
			
			Stack<String> calc = new Stack<>();
			for (int i = 0; i < T; i++) {
				if (!list.peek().equals("+") && !list.peek().equals("*")) {
					calc.add(list.poll());
					continue;
				} else {
					if (list.peek().equals("+")) {
						list.poll();
						calc.add(String.format("%d", Integer.parseInt(calc.pop()) + Integer.parseInt(calc.pop())));
						continue;
					}
					if (list.peek().equals("*")) {
						list.poll();
						calc.add(String.format("%d", Integer.parseInt(calc.pop()) * Integer.parseInt(calc.pop())));
						continue;
					}
					
				}
			}
			sb.append(calc.pop()).append("\n");

		}
		System.out.println(sb);
	}

}
