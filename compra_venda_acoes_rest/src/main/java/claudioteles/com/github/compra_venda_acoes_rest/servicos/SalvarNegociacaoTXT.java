package claudioteles.com.github.compra_venda_acoes_rest.servicos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

@Service
public class SalvarNegociacaoTXT {
	
	/**
	 * Esse metodo salva todas as negociações no formato .txt no disco rígido do computador.
	 * 
	 * @param texto Representa o texto a ser gravado no formatao .txt na pasta src do diretório raiz do projeto: compra_venda_acoes_rest.
	 * 
	 */
	public void salvarEmTxt(String texto) {
		try {
			FileWriter writer = new FileWriter(new File("src/negociacao.txt"));  
			PrintWriter printWriter = new PrintWriter(writer);
			printWriter.print(texto);
			printWriter.close();  
			writer.close();
			System.out.println("Arquivo: \"negociacao.txt\" criado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
