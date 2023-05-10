package Aula03.Atividade;

public class consumir_livros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estante estante = new Estante();
		
		Livro l;
		l = new Livro();
		l.titulo = "Biblia";
		l.autor = "Diversos";
		l.ano = "0";

		estante.prateleira.add(l);
		
		l = new Livro();
		l.titulo = "Alcorão";
		l.autor = "Diversos";
		l.ano = "0";
		
		estante.prateleira.add(l);

		l = new Livro();
		l.titulo = "Torá";
		l.autor = "Diversos";
		l.ano = "0";
		
		estante.prateleira.add(l);
		
		System.out.println(estante.listar_titulos());
}

}
