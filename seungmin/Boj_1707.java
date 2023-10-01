import java.io.*;
import java.util.*;

public class Boj_1707 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int v, e;
	static ArrayList<Integer>[] al;
	static int visit[];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for(int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			visit = new int[v+1];
			al = new ArrayList[v+1];

			for(int i = 0; i <= v; i++)
				al[i] = new ArrayList<Integer>();

			for(int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				al[p1].add(p2);
				al[p2].add(p1);
			}
			grouping();
		}
	}

	public static void grouping() {
		Queue<Integer> q = new LinkedList<Integer>();

		for(int i = 1; i <= v; i++) {
			if(visit[i] == 0) {
				q.add(i);
				visit[i] = 1;
			}

			while(!q.isEmpty()) {
				int now = q.poll();

				for(int j = 0; j < al[now].size(); j++) {
					if(visit[al[now].get(j)] == 0) {
						q.add(al[now].get(j));
					}
					
					if(visit[al[now].get(j)] == visit[now]) {
						System.out.println("NO");
						return;
					}

					if(visit[now] == 1 && visit[al[now].get(j)] == 0)
						visit[al[now].get(j)] = 2;
					else if(visit[now] == 2 && visit[al[now].get(j)] == 0)
						visit[al[now].get(j)] = 1;
				}
			}
		}

		System.out.println("YES");
	}

}