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
@Table(name = "empresa")
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7064626056425468516L;
	
	@Id
	@GeneratedValue(generator = "gerador_de_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_de_id", sequenceName = "sequencia_acoes", initialValue = 50, allocationSize = 1)
	@Column(name = "id_empresa", nullable = false)
	private Long idEmpresa;
	@Column(nullable = false, length = 40)
	private String nome;
	@Column(name = "preco_compra_acao", nullable = false)
	private Double precoCompraUmaAcao;
	@Column(name = "preco_venda_acao", nullable = false)
	private Double precoVendaUmaAcao;
	@Column(name = "totao_em_acoes", nullable = false)
	private Double totalEmAcoes;
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPrecoCompraUmaAcao() {
		return precoCompraUmaAcao;
	}
	public void setPrecoCompraUmaAcao(Double precoCompraUmaAcao) {
		this.precoCompraUmaAcao = precoCompraUmaAcao;
	}
	public Double getPrecoVendaUmaAcao() {
		return precoVendaUmaAcao;
	}
	public void setPrecoVendaUmaAcao(Double precoVendaUmaAcao) {
		this.precoVendaUmaAcao = precoVendaUmaAcao;
	}
	public Double getTotalEmAcoes() {
		return totalEmAcoes;
	}
	public void setTotalEmAcoes(Double totalEmAcoes) {
		this.totalEmAcoes = totalEmAcoes;
	}

}
