package claudioteles.com.github.compra_venda_acoes_rest.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ServicoEmail {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private String remetente;
	private String destinatario;
	private String mensagem;

	public void enviarEmail(String destinatario, String assunto, String mensagem) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(destinatario);
		mailMessage.setSubject(assunto);
		mailMessage.setText(mensagem);
		
		javaMailSender.send(mailMessage);
	}
	
	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
