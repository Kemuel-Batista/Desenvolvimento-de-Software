package Atividade_Singleton_Heranca_18_05;

public class Consumidor_Faculdade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		
		aluno.cpf = "789756487";
		aluno.email = "kemuellima20@gmail.com";
		aluno.matricula = "RGM89789";
		aluno.nome = "Kemuel";
		
		//aluno.salvar(aluno);
		
		aluno.findOne(1);
	}

}
