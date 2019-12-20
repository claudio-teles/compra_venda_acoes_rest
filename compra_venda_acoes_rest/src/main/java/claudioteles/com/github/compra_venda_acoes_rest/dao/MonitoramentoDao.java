package claudioteles.com.github.compra_venda_acoes_rest.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.compra_venda_acoes_rest.modelos.Monitoramento;
import claudioteles.com.github.compra_venda_acoes_rest.repositorios.RepositorioMonitoramento;

@Repository
public class MonitoramentoDao {

	@Autowired
	private RepositorioMonitoramento repositorioMonitoramento;
	
	public Monitoramento inserir(Monitoramento monitoramento) {
		return repositorioMonitoramento.save(monitoramento);
	}
	
	public Monitoramento buscar(Long id_monitoramento) {
		return repositorioMonitoramento.getOne(id_monitoramento);
	}
	
	public List<Monitoramento> buscarMonitoramentos() {
		return repositorioMonitoramento.findAll();
	}
	
	public Monitoramento alterar(Long id_monitoramento, Map<String, String> json) {
		return preencherMonitoramento(id_monitoramento, json);
	}

	public Boolean excluir(Long id_monitoramento) {
		if (repositorioMonitoramento.existsById(id_monitoramento)) {
			repositorioMonitoramento.deleteById(id_monitoramento);
			return true;
		}
		return false;
	}
	
	private Monitoramento preencherMonitoramento(Long id_monitoramento, Map<String, String> json) {
		Monitoramento m = repositorioMonitoramento.getOne(id_monitoramento);
		
		Monitoramento monitoramento = new Monitoramento();
		monitoramento.setIdMonitoramento(m.getIdMonitoramento());
		monitoramento.setEmpresa(m.getEmpresa());
		monitoramento.setPrecoCompra(m.getPrecoCompra());
		monitoramento.setPrecoVenda(m.getPrecoVenda());
		
		if (json.containsKey("preco_compra")) {
			monitoramento.setPrecoCompra(Double.parseDouble(json.get("preco_compra")));
		}
		if (json.containsKey("preco_venda")) {
			monitoramento.setPrecoVenda(Double.parseDouble(json.get("preco_venda")));
		}
		return repositorioMonitoramento.save(monitoramento);
	}
	
}
