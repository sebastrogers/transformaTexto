package transformaTexto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TextoBase {

	public static void main(String[] args) throws IOException {
		ArrayList<String> array = lerArquivo("PreconceitoConvertido.txt");
		salvaArquivo(array);
	}

	static ArrayList<String> lerArquivo(String string) throws IOException {

		System.out.println("Convertendo base...");
		//FileReader arq = new FileReader(string);
		BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(string), "UTF-8"));
		
		ArrayList<String> indices = new ArrayList<String>();
		String linha;
		
		/*
		while ((linha = lerArq.readLine()) != null) {
			indices.add(TransformaTexto.transformaTexto(linha));
			System.out.println(linha);
		}
		*/
		while((linha = lerArq.readLine()) != null){
			//indices.add(StopWord.);
		}
		//arq.close();
		return indices;

	}

	static void salvaArquivo(ArrayList<String> string) throws IOException {
		FileWriter arqW = new FileWriter("PreconceitoConvertidoNOVO1.txt");
		PrintWriter gravarArq = new PrintWriter(arqW);

		for (String frase : string) {
			gravarArq.println(frase);
		}

		arqW.close();
		gravarArq.close();
	}

}
