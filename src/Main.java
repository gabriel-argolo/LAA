import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {


	//Esse metodo carrega o arquivo
	public static Listt loadList(String path) throws NumberFormatException, IOException {
		//aqui se instancia a classe listt, criando um objeto to tipo listt, no scanner definimos o caminho do arquivo
		Listt listt = new Listt();
		Scanner in = new Scanner(new File(path));
		String line = null;

		//aqui temos um loop que percorre todo o .txt linha a linha, analisando a cadeia de strings e separando por tabulaçoes
		while (in.hasNextLine()) {
			line = in.nextLine();
			String[] connections = line.split("[\t ]+");
			int origin = Integer.parseInt(connections[0]);
			//ao encontrar o vertice de origem, isolamos o colocamos literalmente numa lista, onde o restante dos objetos sao considerados como vizinhos
			listt.createVertex(origin);
			for (int i = 1; i < connections.length; i++) {
				listt.addConnections(origin, Integer.parseInt(connections[i]));
			}
		}
		//fecha-se o scanner e retornamos a lista
		in.close();

		return listt;
	}
	//esse metodo retorna os detalhes de lista
	public static void listDetails(Listt listt) {
		//essa variavel contabiliza as adjacencias, de inicio definimos que seja 0
		int neighbors = 0;
		//faz-se o loop do primeiro vertice e se imprime,
		for (Integer vertex: listt.getListt().keySet()) { 
			System.out.print(String.format("%d: ", vertex));
			//faz-se o loop das adjacencias, e imprime todos os vizinhos, relacionados a determinado ertice
			for (Integer neighbor: listt.getConnections(vertex)) {
				System.out.print(String.format("%d: ", neighbor));
			}
			//aqui contamos os vizinhos de cada vertice inicial
			neighbors += listt.getConnections(vertex).size();
			//aqui imprimimos os vertices adjacentes que foram armazenados nas listas
			System.out.println(String.format("(quantidade de vértices adjacentes: %d)", listt.getConnections(vertex).size()));
		}

		if (neighbors > 0) {
			System.out.println("A complexidade deste grafo é: "+(neighbors+listt.getListt().size()));
		} else {
			System.out.println("Esse grafo é Nulo!");
		}
	}

	//aqui carregamos a matriz em memoria
	public static void loadMatrix(String path) throws NumberFormatException, IOException {
		//aqui se instancia a classe matrix, criando um objeto to tipo matrix, no scanner definimos o caminho do arquivo
		Matrix matrix = new Matrix();
		Scanner in = new Scanner(new File(path));
		String line = null;

		//aqui temos um loop que percorre todo o .txt linha a linha, analisando a cadeia de strings e separando por tabulaçoes
		while (in.hasNextLine()) {
			line = in.nextLine();
			String[] connections = line.split("[\t ]+");
			int origin = Integer.parseInt(connections[0]);

			//aqui se adiciona o primeiro vertice, e posteriormente adicionamos suas conexoes
			matrix.createVertex(origin);
			for (int i = 1; i < connections.length; i++) {
				matrix.addConnections(origin, Integer.parseInt(connections[i]));
			}
		}
		in.close();
	}


	public static void main(String... args) throws IOException {		
		//carrega o arquivo e exibe os detalhes da lista
		listDetails(loadList("file1.txt"));
		System.out.println("");
		//carrega o arquivo e exibe os detalhes da lista
		listDetails(loadList("file2.txt"));
		//carrega a matriz e a imprime
		loadMatrix("file1.txt");
	}
}
