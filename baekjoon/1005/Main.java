//topological sort
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main{
	public static int time[];
	public static int maxtime[];
	public static int N, K, W;

	public static LinkedList<Integer> graph[]; //인접 리스트 그래프
	public static int n, indegree[]; //진입차수를 세기 위한 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result[] = new int[T];
		for(int t=0; t<T; t++){

			N = sc.nextInt();
			K = sc.nextInt();
			time = new int[N];
			maxtime = new int[N];
			indegree = new int[N];
			graph = new LinkedList[N];
			for(int i=0; i<N; i++){
				time[i] = sc.nextInt();
				graph[i] = new LinkedList<>();
			}
			int from, to;
			for(int i=0; i<K; i++){
				from = sc.nextInt()-1;
				to = sc.nextInt()-1;
				graph[from].add(to);
				indegree[to]++;
			}
			W = sc.nextInt()-1;
			topologicalSort();
			result[t]= maxtime[W];
		}

		for (int i : result) {
			System.out.println(i);
		}
	}

	private static void topologicalSort() {
		Queue<Integer> searchQ = new LinkedList<Integer>();
		// 초기 진입차수가 0인 노드 탐색 후 탐색 큐에 삽입
		for(int i=0; i<N; i++){
			if(indegree[i]==0){
				searchQ.offer(i);
				maxtime[i]=time[i];
			}
		}
		while(!searchQ.isEmpty() && indegree[W]!=0){
			//진입노드가 0인 노드와 연결된 노드를 탐색하기 위해 저장
			int zeroNode = searchQ.poll();
			// linkedNode : 진입노드0인 애와 연결되있던 노드
			for (int linkedNode : graph[zeroNode]) {
				// 전 노드랑 합쳤을 때 가장 큰 시간으로 설정
				if(maxtime[zeroNode]+time[linkedNode]>maxtime[linkedNode]){
					maxtime[linkedNode]=time[zeroNode]+time[linkedNode];
				}
				// 연결 노드 하나 삭제
				indegree[linkedNode]--;
				// 만약 연결노드 0 이면 search노드에 추가
				if(indegree[linkedNode]==0){
					searchQ.offer(linkedNode);
					time[linkedNode]=maxtime[linkedNode];
				}
			}
		}
	}
}
