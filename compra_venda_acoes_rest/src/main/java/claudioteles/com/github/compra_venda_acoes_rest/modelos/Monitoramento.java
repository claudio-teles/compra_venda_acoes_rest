package claudioteles.com.github.compra_venda_acoes_rest.modelos;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "monitoramento")
public class Monitoramento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5705144038544877802L;
	
	@Id
	@GeneratedValue(generator = "gerador_de_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_de_id", sequenceName = "sequencia_acoes", initialValue = 50, allocationSize = 1)
	@Column(name = "id_monitoramento", nullable = false)
	private Long idMonitoramento;
	@OneToOne(targetEntity = Empresa.class, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(foreignKey = @ForeignKey(name = "um_monitoramento_tem_uma_empresa"), nullable = false)
	private Empresa empresa;
	@Column(name = "preco_compra", nullable = false)
	private Double precoCompra;
	@Column(name = "preco_venda", nullable = false)
	private Double precoVenda;
	
	public Long getIdMonitoramento() {
		return idMonitoramento;
	}
	public void setIdMonitoramento(Long idMonitoramento) {
		this.idMonitoramento = idMonitoramento;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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

}
