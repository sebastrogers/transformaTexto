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

		String[] stopwords = { "de", "a", "o", "que", "e", "do", "da", "em", "um", "para", "é", "com", "não", "uma",
				"os", "no", "se", "na", "por", "mais", "as", "dos", "como", "mas", "foi", "ao", "ele", "das", "tem",
				"à", "seu", "sua", "ou", "ser", "quando", "muito", "há", "nos", "já", "está", "eu", "também", "só",
				"pelo", "pela", "até", "isso", "ela", "entre", "era", "depois", "sem", "mesmo", "aos", "ter", "seus",
				"quem", "nas", "me", "esse", "eles", "estão", "você", "tinha", "foram", "essa", "num", "nem", "suas",
				"meu", "às", "minha", "têm", "numa", "pelos", "elas", "havia", "seja", "qual", "será", "nós", "tenho",
				"lhe", "deles", "essas", "esses", "pelas", "este", "fosse", "dele", "tu", "te", "vocês", "vos", "lhes",
				"meus", "minhas", "teu", "tua", "teus", "tuas", "nosso", "nossa", "nossos", "nossas", "dela", "delas",
				"esta", "estes", "estas", "aquele", "aquela", "aqueles", "aquelas", "isto", "aquilo", "estou", "está",
				"estamos", "estão", "estive", "esteve", "estivemos", "estiveram", "estava", "estávamos", "estavam",
				"estivera", "estivéramos", "esteja", "estejamos", "estejam", "estivesse", "estivéssemos", "estivessem",
				"estiver", "estivermos", "estiverem", "hei", "há", "havemos", "hão", "houve", "houvemos", "houveram",
				"houvera", "houvéramos", "haja", "hajamos", "hajam", "houvesse", "houvéssemos", "houvessem", "houver",
				"houvermos", "houverem", "houverei", "houverá", "houveremos", "houverão", "houveria", "houveríamos",
				"houveriam", "sou", "somos", "são", "era", "éramos", "eram", "fui", "foi", "fomos", "foram", "fora",
				"fôramos", "seja", "sejamos", "sejam", "fosse", "fôssemos", "fossem", "for", "formos", "forem", "serei",
				"será", "seremos", "serão", "seria", "seríamos", "seriam", "tenho", "tem", "temos", "tém", "tinha",
				"tínhamos", "tinham", "tive", "teve", "tivemos", "tiveram", "tivera", "tivéramos", "tenha", "tenhamos",
				"tenham", "tivesse", "tivéssemos", "tivessem", "tiver", "tivermos", "tiverem", "terei", "terá",
				"teremos", "terão", "teria", "teríamos", "teriam" };

		ArrayList<String> wordsList = new ArrayList<String>();
		wordsList = ler("src//PreconceitoConvertidoNOVO.txt");
		// String tweet = "C:/Users/sebas/Google
		// Drive/Git/transformaTexto/PreconceitoConvertido.txt";

		// tweet = tweet.trim().replaceAll("\\s+", " ");
		// System.out.println("Sem remoção dos stopwords: " + tweet);
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