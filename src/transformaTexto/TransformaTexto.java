package transformaTexto;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformaTexto {
	
	public static String transformaTexto(String texto){
		
		String transformado="";
		Pattern p = Pattern.compile("[a-zA-Zà-ùÀ-Ùá-úÁ-Ú0-9]+");
	    Matcher m = p.matcher(texto);
	    while(m.find()) {
	    	transformado+= m.group()
	    	.replace("à", "a")
	    	.replace("è", "e")
	    	.replace("ì", "i")
	    	.replace("ò", "o")
	    	.replace("ù", "u")
	    	.replace("á", "a")
	    	.replace("é", "e")
	    	.replace("í", "i")
	    	.replace("ó", "o")
	    	.replace("ú", "u")
	    	.replace("ã", "a")
	    	.replace("õ", "o")
	    	.replace("â", "a")
	    	.replace("ê", "e")
	    	.replace("î", "i")
	    	.replace("ô", "o")
	    	.replace("û", "u")
	    	.replace("ç", "c")
	    	+" ";
	    	
	    }
	    
		return transformado;
	}

	public static void main(String[] args) throws IOException {
	
		
	}

}
