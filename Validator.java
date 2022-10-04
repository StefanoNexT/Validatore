package util;

public class Validator {
	
	static final String CARATTERISPECIALI = ";:_-+[]@#°§!?£%&/()=|\\\"\\\\\\'^`} {°";
	static final String CARATTERISPECIALI_NOSPAZIO = ";:_-+[]@#°§!?£%&/()=|\\\"\\\\\\'^`}{°";
	static final String NUMERI = "1234567890";
	static final String LETTERE = "bcdfghjklmnpqrstvwxyzaeiou";
	static final String LETTEREMAIUSCOLE = "QWERTYUIOPASDFGHJKLZXCVBNM";

	//Nome utente senza caratteri speciali, senza numeri, senza lettere ripetute per 3+ volte  
	//"c1ao" , "ci@o" , "ciiiao" ->NO
	public boolean ValidaNome(String nome)
	{
		for(String x : (NUMERI+CARATTERISPECIALI).split(""))
			if(nome.contains(x) && nome != null && !nome.isEmpty())
				return false;
	
		String array [] = nome.split("");
		for(int i=0; i < nome.length()-2; i++) 
		{
			if(nome.length()-2 != i) 
				if(array[i].equals(array[i+1]) && array[i].equals(array[i+2])) 
					return false;
		}
		return true;
	}
	
    //la password deve avere 1 carattere speciale 1 lettera maiuscola e 1 numero
	public boolean ValidaPassword(String password)
	{
		String arrayPassword [] = password.split("");
		String arrayLettereMai [] = LETTEREMAIUSCOLE.split("");
		String arrayCaratteriSpecialiSenzaSpazio [] = CARATTERISPECIALI_NOSPAZIO.split("");
		String arrayNum [] = NUMERI.split("");
		int cont=0 , contSpeciali=0 , contNum=0;
	    for(int i =0; i<password.length();i++) 
	    {
	        for(int j=0; j<LETTEREMAIUSCOLE.length();j++)
	            if((arrayPassword[i].equals(arrayLettereMai[j]))) cont++;
	        
	        for(int j=0; j<CARATTERISPECIALI_NOSPAZIO.length();j++) 
	            if((arrayPassword[i].equals(arrayCaratteriSpecialiSenzaSpazio[j]))) contSpeciali++;
	        
	        for(int j=0; j<NUMERI.length();j++)
		        if((arrayPassword[i].equals(arrayNum[j]))) contNum++;
	    }
	    if(cont > 0 && contSpeciali > 0 && contNum > 0)
	    	return true;
	   
		return false;
	}




   
	
}
