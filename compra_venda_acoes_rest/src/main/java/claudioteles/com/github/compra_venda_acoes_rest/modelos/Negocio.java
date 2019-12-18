package claudioteles.com.github.compra_venda_acoes_rest.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "negocio")
public class Negocio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3135905117533325636L;
	
	@Id
	@GeneratedValue(generator = "gerador_de_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_de_id", sequenceName = "sequencia_acoes", initialValue = 50, allocationSize = 1)
	@Column(name = "id_negociacao", nullable = false)
	private Long idNegociacao;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(
		foreignKey = @ForeignKey(name = "negocios_da_empresa"),
		referencedColumnName = "id_empresa", nullable = false
	)
	private Empresa empresa;
	@Column(nullable = false)
	private Double valorNegociado;
	@Column(nullable = false)
	private Integer quantidade;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;
	
	public Long getIdNegociacao() {
		return idNegociacao;
	}
	public void setIdNegociacao(Long idNegociacao) {
		this.idNegociacao = idNegociacao;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Double getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(Double valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Negocio [idNegociacao=" + idNegociacao + ", empresa=" + empresa + ", valorNegociado=" + valorNegociado
				+ ", quantidade=" + quantidade + ", data=" + data + "]";
	}

}
