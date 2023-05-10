package Aula05;

public class Professor_Consumidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Professor professor = new Professor("4564", "5646", "Kemuel", "kemuel@gmail.com");
		
		System.out.println(professor.nome + " " + professor.email);
		
		Professor p2 = new Professor();
	}
}
