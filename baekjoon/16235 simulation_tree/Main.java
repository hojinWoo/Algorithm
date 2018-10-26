import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		int dy[] = {-1, 0, 1,-1, 1, -1, 0, 1};
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
//		System.out.println(N + " : " + M + " : " + K);
		int[][] init = new int[N][N];
		int[][] food = new int[N][N];
		
		TreeArray array = new TreeArray();
		array.setRow(N);
		array.setCol(N);
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				init[i][j] = 5;
				food[j][i] = sc.nextInt();
//				System.out.print(food[i][j]+" ");
			}
//			System.out.println();
		}
		
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
			Tree tree = new Tree();
			tree.setAge(age);
			array.getTreeArray(y-1).getTreeRow(x-1).setTree(tree);
		}
		
		
		
		while( K > 0 ) {
			
			//봄
			//양분 먹기 > 못 먹으면 죽음
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					init[j][i] = array.getTreeArray(j).getTreeRow(i).eatFood(init[j][i]);
				}
			}
			
			//여름
			//죽은 나무 > 양분 (소수점 아래는 버림)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					init[j][i] += array.getTreeArray(j).getTreeRow(i).checkTree();
				}
			}
			
			//가을
			//5의 배수는 나무 번식
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int count = array.getTreeArray(j).getTreeRow(i).isFiveMulAge();
					while(count > 0) {
						//번식
						for (int k = 0; k < 8; k++) {
							int ddx = j+dx[k];
							int ddy = i+dy[k];
							if(ddx>=0 && ddx<N && ddy>=0 && ddy<N) {
								array.getTreeArray(ddx).getTreeRow(ddy).addTree();
							}
						}
						count--;
					}
				}
			}
			
			///겨울 (양분 보충)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int feedFood = food[i][j];
					init[i][j] += feedFood;
				}
			}
			
			K--;
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count += array.getTreeArray(j).getTreeRow(i).getTreeCount();
			}
		}
		System.out.println(count);
	}
}


class Tree{
	private int age;
	private boolean isAlive;
	public Tree() {
		age = 1;
		isAlive = true;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	public void die() {
		isAlive = false;
	}
	public void growup() {
		++age;
	}
	
}

class TreeCell{
	private List<Tree> treelist;
	
	public TreeCell() {
		treelist = new ArrayList<Tree>();
	}
	
	public List<Tree> getTreelist() {
		return treelist;
	}

	public void setTree(Tree tree) {
		treelist.add(tree);
	}
	//양분 먹기
	public int eatFood(int food) {
		for (int i = treelist.size()-1; i >= 0; i--) {
			if(treelist.get(i).getAge() <= food) {
				food -= treelist.get(i).getAge();
				treelist.get(i).growup();
			}else {
				treelist.get(i).die();
			}
		}
		return food;
	}
	
	//죽은 나무 체크
	public int checkTree() {
		int sum = 0;
		for (int i = treelist.size()-1; i >= 0; i--) {
			if(!treelist.get(i).isAlive()) {
				sum += Math.floor(treelist.get(i).getAge()/2);
				treelist.remove(i);
			}
		}
		return sum;
	}
	
	//번식 나무 체크
	public int isFiveMulAge() {
		int count = 0;
		for (int i = treelist.size()-1; i >= 0; i--) {
			if((treelist.get(i).getAge() %5) ==0) {
				count++;
			}
		}
		return count;
	}
	
	//새 나무 번식
	public void addTree() {
		treelist.add(new Tree());
	}
	
	//나무의 수
	public int getTreeCount() {
		return treelist.size();
	}
}

class TreeRow{
	
	private List<TreeCell> treeRow;
	
	public TreeRow() {
		treeRow = new ArrayList<TreeCell>();
	}
	public void setCol(int col) {
		for (int i = 0; i < col; i++) {
			treeRow.add(new TreeCell());
		}
	}
	public TreeCell getTreeRow(int col) {
		return treeRow.get(col);
	}
	
}

class TreeArray{
	private List<TreeRow> treeArray;
	
	public TreeArray() {
		treeArray = new ArrayList<TreeRow>();
	}
	
	public void setRow(int row) {
		for (int i = 0; i < row; i++) {
			treeArray.add(new TreeRow());
		}
	}
	
	public void setCol(int col) {
		for (TreeRow treeRow : treeArray) {
			treeRow.setCol(col);
		}
	}

	public TreeRow getTreeArray(int row) {
		return treeArray.get(row);
	}
}

