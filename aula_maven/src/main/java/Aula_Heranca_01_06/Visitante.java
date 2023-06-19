package Aula_Heranca_01_06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Visitante extends Pessoa {
	public String data_da_visita;
	
	@Override
	public boolean liberar() {
		super.salvar();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    String data_formatada = formatter.format(date);
	    System.out.print("Current date: "+data_formatada);
	    
	    if(this.data_da_visita.equals(data_formatada)) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
}