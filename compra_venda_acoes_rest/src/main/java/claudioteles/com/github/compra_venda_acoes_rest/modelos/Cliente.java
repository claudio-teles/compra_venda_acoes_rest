package claudioteles.com.github.compra_venda_acoes_rest.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5360551748649537004L;
	
	@Id
	@GeneratedValue(generator = "gerador_de_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_de_id", sequenceName = "sequencia_acoes", initialValue = 50, allocationSize = 1)
	@Column(name = "id_cliente", nullable = false)
	private Long idCliente;
	@Column(nullable = false, length = 40)
	private String nome;
	@Column(nullable = false, length = 40)
	private String senha;
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
