package grafos;

import java.util.*;
import disjointSet.*;

public class AlgoritmosGrafos {
	
	/**
	 * saca los vertices adyacentes a un nodo
	 * @param node
	 * @param matrix
	 * @return
	 */
	public ArrayList<Integer> adjacents(int node, int[][] matrix){
		
		ArrayList<Integer> adj = new ArrayList<>();
		
		for (int i = 0; i < matrix.length; i++)
			if(matrix[node][i] > 0)
				adj.add(i);

		return adj;
	}
	
	/**
	 * BFS
	 * @param node
	 * @param matrix
	 * @return el orden en el que visito los nodos 
	 */
	public ArrayList<Integer> bfs(int node, int[][] matrix){
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[matrix.length]; 
		
		queue.add(node);
		visited[node] = true; 
		
		ArrayList<Integer> recorrido = new ArrayList<Integer>();
		
		while(!queue.isEmpty()){
			node = queue.poll();
			recorrido.add(node);
			
			// busca los adyacentes del nodo que salio de la cola
			ArrayList<Integer> adj = adjacents(node, matrix);
			
			//si no estan visitados los marca, y los mete a la cola
			for (int i = 0; i < adj.size(); i++) {
				int v = adj.get(i);
				if(!visited[v]){
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return recorrido;
	}
	
	public int[] bfsLevels(int n, int[][] matrix){
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] levels = new int[matrix.length];
		boolean visited[] = new boolean[matrix.length]; 
		
		queue.add(n);
		visited[n] = true; 
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		while(!queue.isEmpty()){
			n = queue.poll();
			array.add(n);
			
			ArrayList<Integer> adj = adjacents(n, matrix);
			
			for (int i = 0; i < adj.size(); i++) {
				int s = adj.get(i);
				if(!visited[s]){
					visited[s] = true;
					queue.add(s);
					levels[s] = levels[n] + 1;
				}
			}
		}
		return levels;
	}

	/**
	 * DFS
	 * @param node
	 * @param graph
	 * @return una lista con el orden de recorrido de los nodos
	 */
	public ArrayList<Integer> dfs(int node, int[][] graph){
		
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[graph.length]; 
		
		stack.push(node);
		visited[node] = true; 
		
		ArrayList<Integer> recorrido = new ArrayList<Integer>();
		
		while(!stack.isEmpty()){
			node = stack.pop();
			recorrido.add(node);
			
			ArrayList<Integer> adj = adjacents(node, graph);
			
			for (int i = 0; i < adj.size(); i++) {
				int v = adj.get(i);
				if(!visited[v]){
					visited[v] = true;
					stack.push(v);
				}
			}
		}
		return recorrido;		
	}
	
	
	public int minVertex(int[] weight, boolean[] inMst){
		int min = Integer.MAX_VALUE;
		int min2 = -1;
		for (int i = 0; i < inMst.length; i++) {
			if(inMst[i] == false && weight[i] < min){
				min = weight[i];
				min2 = i;
			}
		}
		return min2;
	}
	
	/**
	 * halla el vertice mas pequeno y lo retorna
	 * @param weight los pesos que tiene el arbol
	 * @param inMst  lista que dice si los vertices ya estan dentro del mst
	 * @param vertexs numero de vertices
	 * @return el vertice con el peso mas pequeno
	 */
	
	public int minVertex(int[] weight, boolean[] inMst, int vertices){
		int minValue = Integer.MAX_VALUE;
		int minVertex = -1;
		for (int i = 0; i < vertices; i++) {
			if(inMst[i] == false && weight[i] < minValue){
				minValue = weight[i];
				minVertex = i;
			}
		}
		return minVertex;
	}
	
	public int[] dijkstra(int[][] matrix, int vertex){ 
		int[] distancias = new int[matrix.length];
		
		boolean inMst[] = new boolean[matrix.length]; 
		
		for (int i = 0; i < matrix.length; i++) { 
			distancias[i] = Integer.MAX_VALUE; 
			inMst[i] = false; 
		} 
		
		distancias[vertex] = 0; 
		for (int i = 0; i < matrix.length - 1; i++) {  
			int u = minVertex(distancias, inMst); 
			inMst[u] = true; 
			for (int j = 0; j < matrix.length; j++) {
				if (!inMst[j] && matrix[u][j] != 0 && distancias[u] != Integer.MAX_VALUE && distancias[u] + matrix[u][j] < distancias[j]) {
					distancias[j] = distancias[u] + matrix[u][j]; 
				}				
			}
		} 
		return distancias;
	} 
	
	public int[][] floydWarshall(int[][] matrix){
		
		int[][] fw = new int[matrix.length][matrix.length];
		
		for (int i = 0; i < matrix.length; i++) 
			for (int j = 0; j < matrix.length; j++) 
				fw[i][j] = matrix[i][j];
		
		for (int k = 0; k < matrix.length; k++)
			for (int i = 0; i < matrix.length; i++) 
				for (int j = 0; j < matrix.length; j++) 
					if(fw[i][j] > fw[i][k] + fw[k][j])
						fw[i][j] = fw[i][k] + fw[k][j];
		
		return fw;
	}
	
	/**
	 * hace prim
	 * @param matrix la matriz de pesos
	 */
	
	public void prim(int[][] matrix){
		
		int[] mst = new int[matrix.length];	//lista de adyacencia
		int[] weight = new int[matrix.length];	// pesos del mst
		boolean[] inMst = new boolean[matrix.length];	// si ya estan conectados en el arbol
		
		
		// inicio los pesos en valores maximos y conexiones en el arbol en false
		for (int i = 0; i < matrix.length; i++) { 
			weight[i] = Integer.MAX_VALUE; 
			inMst[i] = false; 
		}
		
		// se hace prim desde el vertice 0
		weight[0] = 0; 	// peso cero
		mst[0] = -1;	
		
		for (int i = 0; i < matrix.length-1; i++) {
			int u = minVertex(weight, inMst, matrix.length);
			inMst[u] = true;
			for (int j = 0; j < matrix.length; j++) {
				if(matrix[u][j] != 0 && inMst[j] == false && matrix[u][j] < weight[j]){
					mst[j] = u;
					weight[j] = matrix[u][j];
				}
			}
		}		

		printMST(mst, matrix.length, matrix);
	}
	
	/**
	 * Imprime prim
	 * @param parent
	 * @param n
	 * @param graph
	 */
	
	public void printMST(int parent[], int n, int graph[][]){ 
		System.out.println("Edge \tWeight"); 
		for (int i = 1; i < graph.length; i++) 
			System.out.println(parent[i]+" - "+ i+"\t"+ graph[i][parent[i]]); 
	}
	
	public int[][] Kruskal(int[][] pesos, int infinito){
		
		DisjointSet<Integer> set = new DisjointSet<>();
		int[][] MST = new int[pesos.length][pesos.length];
		
		for(int i = 0; i < pesos.length; i++)
			set.makeSet(i);
		
		class obj {
			
			int A;
			int B;
			int P;
			
			obj(int a, int b, int p){
				A = a;
				B = b;
				P = p;
			}
			
			int getA() {
				return A;
			}
			
			int getB() {
				return B;
			}
			
			int getP() {
				return P;
			}
		}
		
		ArrayList<obj> aristas = new ArrayList<>();
		
		for(int i = 0; i < pesos.length;  i++) {
			for(int j = 0; j < pesos.length; j++) {
				int peso = pesos[i][j];
				if(peso > 0 && peso < infinito) {
					obj o = new obj(i, j, peso);
					aristas.add(o);
				}
			}
		}
		
		Comparator<obj> comparador = new Comparator<obj>() {
			
			@Override
			public int compare(obj a, obj b) {
				if(a.getP() > b.getP())
					return  1;
				else if (a.getP() < b.getP())
					return -1;
				else
					return 0;
			}
		};
		
		aristas.sort(comparador);
		
		for(int i = 0; i < aristas.size(); i++) {
			obj arista = aristas.get(i);
			if(set.findSet(arista.getA()) != set.findSet(arista.getB())) {
				set.union(arista.getA(), arista.getB());
				MST[arista.getA()][arista.getB()] = arista.getP();
				MST[arista.getB()][arista.getA()] = arista.getP();
			}
		}		
		return MST;
	}
}
