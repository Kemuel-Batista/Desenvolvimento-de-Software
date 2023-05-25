package gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test_Biblioteca {
	public static void main(String[] args) {
		Prateleira prateleira = new Prateleira();
		Estante estante = new Estante();

		Livro livro = new Livro();
		livro.autor = "Mauricio de Nassau";
		livro.edicao = "1980 - 2 Edição";
		livro.titulo = "Holanda em Pernambuco";

		prateleira.livros.add(livro);

		Livro livro2 = new Livro();
		livro2.autor = "Jordan Petterson";
		livro2.titulo = "12 Regras para a Vida";
		livro2.edicao = "1 Edição";

		prateleira.livros.add(livro2);

		Livro livro3 = new Livro();
		livro3.autor = "Jordan Petterson";
		livro3.titulo = "Mais 12 Regras para a Vida";
		livro3.edicao = "1 Edição";

		Prateleira prateleira2 = new Prateleira();
		prateleira2.livros.add(livro3);

		estante.prateleiras.add(prateleira);
		estante.prateleiras.add(prateleira2);

		System.out.println(prateleira.livros.size());

		for (int i = 0; i < estante.prateleiras.size(); i++) {
			System.out.println("Qtd de Livros na " + i + " prateleira: ");

			for (int j = 0; j < estante.prateleiras.get(j).livros.size(); j++) {

			}
		}

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();

		Gson gson = builder.create();

		String jsonString = gson.toJson(estante);
		System.out.println(jsonString);

		try {
			FileWriter arquivo = new FileWriter("C:\\_src\\aula_maven\\src\\main\\java\\gson\\texto.json", true);
			arquivo.write(jsonString);
			arquivo.close();

			BufferedReader bufferedReader = new BufferedReader(
					new FileReader("C:\\_src\\aula_maven\\src\\main\\java\\gson\\texto.json"));
			Estante estante_mapeamento = gson.fromJson(bufferedReader, Estante.class);
			System.out.println(estante_mapeamento);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}