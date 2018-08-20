# 위상정렬(Topological Sort)

### 위상정렬 정의

- **그래프**를 정렬

- 정렬 기준은 **진입 차수의 비 내림차순 순서**

- 진입차수는 0개 → N개 순 탐색, 정렬 과정을 통해 진입차수가 0인 노드들은 제거하고, 0이 아닌 노드들은 정렬을 통해 점차 진입차수를 0으로 만든 뒤 제거하며 정렬

  > 진입차수(Indegree) : 해당 노드로 들어오는 간선의 개수



### 위상정렬 조건

- **DAG(Directed Acyclic Graph) 그래프**가 되어야 한다.

- It is finite [directed graph](https://en.wikipedia.org/wiki/Directed_graph) with no [directed cycles](https://en.wikipedia.org/wiki/Cycle_graph#Directed_cycle_graph). (방향성은 있지만 사이클이 없어야 한다)
  That is, it consists of finitely many [vertices](https://en.wikipedia.org/wiki/Vertex_(graph_theory)) and [edges](https://en.wikipedia.org/wiki/Edge_(graph_theory)), with each edge directed from one vertex to another, such that there is no way to start at any vertex v and follow a consistently-directed sequence of edges that eventually loops back to v again. Equivalently, a DAG is a directed graph that has a [topological ordering](https://en.wikipedia.org/wiki/Topological_ordering), a sequence of the vertices such that every edge is directed from earlier to later in the sequence. 

  > [출처](https://en.wikipedia.org/wiki/Directed_acyclic_graph)



### 위상정렬 Sequence

1. 인접 리스트 그래프 생성 뒤, 각 노드별로 indegree를 기록. (LinkedList, ArrayList, Vector)
2. Queue를 2개 생성(큐 1개와 배열 1개로도 가능)
   (searchQueue, ResultQueue)
3. Indegree가 0인 노드들을 탐색 후 searchQ에 저장
4. searchQ에서 node를 하나 씩 poll()한 후에, 해당 노드를 resultQ에 offer()한다.
5. searchQ에서 뽑은 node와 연결된 node들의 연결 노드를 삭제한다. (linkedNode--)
6. 연결노드가 0이 되면 다시 searchQ에 넣는다.
7. 4~6번 과정 반복



[참고자료](https://blog.naver.com/occidere/220921661731, http://jason9319.tistory.com/93)