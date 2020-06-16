import java.util.Collection;
import java.util.HashMap;

public class Matrix {
	private HashMap<Integer, HashMap<Integer, Integer>> matrix;

	public Matrix() {
		//usando Hashmap a complexidade do algoritmo fica em O(1) para novo vertice, caso haja rehash, fica O(N)
		matrix = new HashMap<Integer, HashMap<Integer, Integer>>();
	}
	//retorna os valores atraves do primeiro vertice
	public Collection<Integer> getConnections(int origin) {
		return matrix.get(origin).values();
	}
	//cria-se o vertice, usando hashmap.
	//O hashmap permite-se ter a referencia do vertice inicial e seus adjacentes.
	public void createVertex(int vertex) {
		HashMap<Integer, Integer> neww = new HashMap<Integer, Integer>();

		for (Integer to: matrix.keySet()) {
			neww.put(to, 0);
		}
		matrix.put(vertex, neww);
	}
	// metodo adiciona as conexoes do ponto de origem e destino
	public void addConnections(int origin, int destiny) {		
		matrix.get(origin).put(destiny, 1);
	}
}