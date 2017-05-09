package transformaTexto;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformaTexto {
	
	public static String transformaTexto(String texto){
		
		String transformado="";
		Pattern p = Pattern.compile("[a-zA-Z�-��-��-��-�0-9]+");
	    Matcher m = p.matcher(texto);
	    while(m.find()) {
	    	transformado+= m.group()
	    	.replace("�", "a")
	    	.replace("�", "e")
	    	.replace("�", "i")
	    	.replace("�", "o")
	    	.replace("�", "u")
	    	.replace("�", "a")
	    	.replace("�", "e")
	    	.replace("�", "i")
	    	.replace("�", "o")
	    	.replace("�", "u")
	    	.replace("�", "a")
	    	.replace("�", "o")
	    	.replace("�", "a")
	    	.replace("�", "e")
	    	.replace("�", "i")
	    	.replace("�", "o")
	    	.replace("�", "u")
	    	.replace("�", "c")
	    	+" ";
	    	
	    }
	    
		return transformado;
	}

	public static void main(String[] args) throws IOException {
	
		
	}

}
