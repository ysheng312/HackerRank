import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class HackerRank_FavoriteSequence {
	// public static final int max = 10000;

	private static class Graph {
		public Set<Integer> vertices;
		public Map<Integer, Set<Integer>> adjList;
		public Map<Integer, Integer> inDegrees;
		public Map<Integer, Boolean> processed;

		public Graph() {
			vertices = new TreeSet<Integer>();
			adjList = new HashMap<Integer, Set<Integer>>();
			inDegrees = new HashMap<Integer, Integer>();
			processed = new HashMap<Integer, Boolean>();
		}

		public void addVertex(int i) {
			if (vertices.contains(i) == false) {
				vertices.add(i);
				adjList.put(i, new HashSet<Integer>());
				inDegrees.put(i, 0);
				processed.put(i, false);
			}
		}

		public void insertEdge(int i, int j) {
			addVertex(i);
			addVertex(j);

			Set<Integer> adjI = adjList.get(i);
			if (adjI.contains(j) == false)
			{	adjI.add(j);
				inDegrees.put(j, inDegrees.get(j) + 1);
			}
		}

		// pop all vertices with indegree = 0 and processed is false
		public Set<Integer> popVertices() {
			Set<Integer> pops = new HashSet<Integer>();

			for (int i : this.vertices) {
				if (inDegrees.get(i) == 0 && processed.get(i) == false) {
					pops.add(i);
					processed.put(i, true);
				}
			}

			return pops;
		}
	}

	public static void main(String args[]) throws NumberFormatException,
			IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		int N = Integer.parseInt(buffer.readLine());

		Graph g = new Graph();

		for (int i = 0; i < N; i++) {
			int K = Integer.parseInt(buffer.readLine());
			int v[] = new int[K];
			String line = buffer.readLine();
			String tokens[] = line.split("\\s+");
			int j = 0;
			for (String token : tokens) {
				int num = Integer.parseInt(token);

				g.addVertex(num);
				v[j] = num;
				j++;
			}

			for (j = 0; j < K - 1; j++) {
				g.insertEdge(v[j], v[j + 1]);
			}
		}

		buffer.close();

		Queue<Integer> minHeap = new PriorityQueue<Integer>();

		Set<Integer> origin = new LinkedHashSet<Integer>();

		// process all vertices with indegree = 0
		for (int i : g.popVertices()) {
			minHeap.offer(i);
		}

		while (minHeap.isEmpty() != true) {
			int i = minHeap.poll();

			origin.add(i);

			// traverse adjList to decrease the indegree of its neighbors by
			// 1
			Set<Integer> adjI = g.adjList.get(i);

			if (adjI != null) {
				for (int j : adjI) {

					g.inDegrees.put(j, g.inDegrees.get(j) - 1);

					if (g.inDegrees.get(j) == 0 && g.processed.get(j) == false) {
						minHeap.offer(j);
						g.processed.put(j, true);
					}
				}
			}
		}

		for (int i : origin) {
			System.out.print(i + " ");
		}
	}
}