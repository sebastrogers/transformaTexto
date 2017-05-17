package transformaTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StopWord {
	public static void main(String[] args) {

		String[] stopwords = { "de", "a", "o", "que", "e", "do", "da", "em", "um", "para", "�", "com", "n�o", "uma",
				"os", "no", "se", "na", "por", "mais", "as", "dos", "como", "mas", "foi", "ao", "ele", "das", "tem",
				"�", "seu", "sua", "ou", "ser", "quando", "muito", "h�", "nos", "j�", "est�", "eu", "tamb�m", "s�",
				"pelo", "pela", "at�", "isso", "ela", "entre", "era", "depois", "sem", "mesmo", "aos", "ter", "seus",
				"quem", "nas", "me", "esse", "eles", "est�o", "voc�", "tinha", "foram", "essa", "num", "nem", "suas",
				"meu", "�s", "minha", "t�m", "numa", "pelos", "elas", "havia", "seja", "qual", "ser�", "n�s", "tenho",
				"lhe", "deles", "essas", "esses", "pelas", "este", "fosse", "dele", "tu", "te", "voc�s", "vos", "lhes",
				"meus", "minhas", "teu", "tua", "teus", "tuas", "nosso", "nossa", "nossos", "nossas", "dela", "delas",
				"esta", "estes", "estas", "aquele", "aquela", "aqueles", "aquelas", "isto", "aquilo", "estou", "est�",
				"estamos", "est�o", "estive", "esteve", "estivemos", "estiveram", "estava", "est�vamos", "estavam",
				"estivera", "estiv�ramos", "esteja", "estejamos", "estejam", "estivesse", "estiv�ssemos", "estivessem",
				"estiver", "estivermos", "estiverem", "hei", "h�", "havemos", "h�o", "houve", "houvemos", "houveram",
				"houvera", "houv�ramos", "haja", "hajamos", "hajam", "houvesse", "houv�ssemos", "houvessem", "houver",
				"houvermos", "houverem", "houverei", "houver�", "houveremos", "houver�o", "houveria", "houver�amos",
				"houveriam", "sou", "somos", "s�o", "era", "�ramos", "eram", "fui", "foi", "fomos", "foram", "fora",
				"f�ramos", "seja", "sejamos", "sejam", "fosse", "f�ssemos", "fossem", "for", "formos", "forem", "serei",
				"ser�", "seremos", "ser�o", "seria", "ser�amos", "seriam", "tenho", "tem", "temos", "t�m", "tinha",
				"t�nhamos", "tinham", "tive", "teve", "tivemos", "tiveram", "tivera", "tiv�ramos", "tenha", "tenhamos",
				"tenham", "tivesse", "tiv�ssemos", "tivessem", "tiver", "tivermos", "tiverem", "terei", "ter�",
				"teremos", "ter�o", "teria", "ter�amos", "teriam" };

		ArrayList<String> wordsList = new ArrayList<String>();
		wordsList = ler("src//PreconceitoConvertidoNOVO.txt");
		// String tweet = "C:/Users/sebas/Google
		// Drive/Git/transformaTexto/PreconceitoConvertido.txt";

		// tweet = tweet.trim().replaceAll("\\s+", " ");
		// System.out.println("Sem remo��o dos stopwords: " + tweet);
		// String[] words = tweet.split(" ");
		System.out.println("arquivo gerado");

		ArrayList<String> wordsListSaida = new ArrayList<String>();
		for (String word : wordsList) {
			
			String aux = word;
			String[] auxV = aux.split(" ");
			
			for (String string : stopwords) {
				for (int i = 0; i < auxV.length; i++) {
					if (auxV[i].equalsIgnoreCase(string)) {
						auxV[i] = "";
					}
				}				
			}
			
			String saida = "";
			for (String string : auxV) {
				
				if (!string.isEmpty()) {
					//System.out.println(string);
					saida += string.trim().toLowerCase() + " ";
					
				}			
			}
			
			wordsListSaida.add(saida);		
		}
		
		try {
			salvaArquivo(wordsListSaida);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		/**
		 * for (int i = 0; i < wordsList.size(); i++) {
		 * 
		 * for (int j = 0; j < stopwords.length; j++) { if
		 * (stopwords[j].contains(wordsList.get(i))) { wordsList.remove(i); } }
		 * } for (String str : wordsList) { System.out.print(str + " "); }
		 **/
	}

	
	static void salvaArquivo(ArrayList<String> string) throws IOException {
		FileWriter arqW = new FileWriter("PreconceitoStopwords.txt");
		PrintWriter gravarArq = new PrintWriter(arqW);

		for (String frase : string) {
			gravarArq.println(frase);
		}

		arqW.close();
		gravarArq.close();
	}
	public static ArrayList<String> ler(String file) {
		ArrayList<String> words = new ArrayList();

		try {

			FileReader in = new FileReader(file);
			BufferedReader reader = new BufferedReader(in);

			while (reader.ready()) {
				words.add(reader.readLine());
			}

			in.close();
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return words;

	}
}