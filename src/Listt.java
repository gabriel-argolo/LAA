import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Listt {

	private HashMap<Integer, List<Integer>> list;
	//esse metodo cria uma lista com Hashmap, em cima de uma lista, pq devemos ter uma referencia ao primeiro obheto
	public Listt() {
		list = new HashMap<Integer, List<Integer>>();
	}
	//buscamos todas os adjacentes atraves de um vertice de origem
	public List<Integer> getConnections(int origin) {
		return this.list.get(origin);
	}
	//aqui criamos o vertice e o colocamos o vertice inicial como chave, e os seus adjacentes em um array, referenciado por essa chave
	public void createVertex(int vertex) {
		this.list.put(vertex, new ArrayList<Integer>());
	}
	//adicionamos as conexes, usando o vertice original como base e adicionando o vertice de destino
	public void addConnections(int origin, int destiny) {		
		this.list.get(origin).add(destiny);
	}
	//cria o hash da lista
	public HashMap<Integer, List<Integer>> getListt() {
		return this.list;
	}
}