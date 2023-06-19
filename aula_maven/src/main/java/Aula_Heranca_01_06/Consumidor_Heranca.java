package Aula_Heranca_01_06;

public class Consumidor_Heranca {
	public static void main(String[] args) {
		Aluno a = new Aluno();
		a.cpf = "123";
		a.email = "kemuellima20@gmail.com";
		a.situacao_matricula = "Ativa";
		//a.salvar();
		
		Professor p = new Professor();
		p.cpf = "5678";
		p.email = "check@gmail.com";
		p.tipo_contrato = "CLT";
		//p.salvar();
		
		Visitante v = new Visitante();
		v.cpf = "12345";
		v.data_da_visita = "01/06/2023";
		System.out.println("Data da Visita: " + v.data_da_visita);
		boolean authorization = v.liberar();
		if(authorization == true) {
			System.out.println("\nVisitante liberado com sucesso!");
		} else {
			System.out.println("\nVisitante não autorizado!");
		}
	}
}