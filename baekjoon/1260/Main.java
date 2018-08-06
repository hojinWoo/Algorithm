public class Main {
	static int Nv;//vertex(정점)
	static int Ne;//edge(간선)
	static int[][] ad = new int[1001][1001];
	static boolean[] visit1=new boolean[10001]; //dfs 방문
	static boolean[] visit2=new boolean[10001]; //bfs 방문
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Nv=sc.nextInt();//vertex(정점)
		Ne=sc.nextInt();//edge(간선)
		int start=sc.nextInt();
		int x;
		int y;
		for(int i=1;i<=Ne;i++){
			x=sc.nextInt();
			y=sc.nextInt();
			ad[x][y]=1;
			ad[y][x]=1;
		}
		dfs(start);
		System.out.println();
		bfs(start);
	}
	public static void dfs(int i){
		visit1[i]=true; //방문
		System.out.print(i+" ");
		for(int j=1;j<Nv+1;j++){
            //간선이 존재하고 방문한 적이 없다면 dfs추가
			if(ad[i][j]==1 && visit1[j]==false){
				dfs(j);
			}
		}

	}
	public static void bfs(int i){
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(i); //queue에 추가
		visit2[i]=true;
		while(!q.isEmpty()){
			int temp=q.poll();
			System.out.print(temp+" ");
			for(int j=1;j<Nv+1;j++){
                //BFS방식이기 때문에 queue 인접 node들 체크
				if(ad[temp][j]==1 && !visit2[j]){
					q.offer(j);
					visit2[j]=true;
				}
			}
		}
	}
}

/*
추가 예제
4 3 1
1 3
1 4
3 2

1 3 2 4
1 3 4 2
*/
