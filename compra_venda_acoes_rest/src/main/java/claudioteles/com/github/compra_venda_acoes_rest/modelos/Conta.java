package claudioteles.com.github.compra_venda_acoes_rest.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7347637738280310965L;
	
	@Id
	@GeneratedValue(generator = "gerador_de_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_de_id", sequenceName = "sequencia_acoes", initialValue = 50, allocationSize = 1)
	@Column(name = "id_conta", nullable = false)
	private Long idConta;
	@OneToOne(targetEntity = Cliente.class)
	@JoinColumn(foreignKey = @ForeignKey(name = "uma_conta_tem_um_cliente"), nullable = false)
	private Cliente cliente;
	@Column(name = "email_notificacao", nullable = false, length = 40)
	private String emailNotificacao;
	private Double saldo;
	
	@Column(nullable = false)
	private Double precoCompra;
	@Column(nullable = false)
	private Double precoVenda;
	private Long quantidadeAcoes;
	
	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEmailNotificacao() {
		return emailNotificacao;
	}

	public void setEmailNotificacao(String emailNotificacao) {
		this.emailNotificacao = emailNotificacao;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}
	public Double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Long getQuantidadeAcoes() {
		return quantidadeAcoes;
	}

	public void setQuantidadeAcoes(Long quantidadeAcoes) {
		this.quantidadeAcoes = quantidadeAcoes;
	}
}
