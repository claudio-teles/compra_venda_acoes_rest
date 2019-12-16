package claudioteles.com.github.compra_venda_acoes_rest.servicos;

import java.util.Map;

import org.springframework.stereotype.Service;

import claudioteles.com.github.compra_venda_acoes_rest.dao.EmpresaDao;
import claudioteles.com.github.compra_venda_acoes_rest.modelos.Monitoramento;

@Service
public class ServicoMonitoramento {

	public Monitoramento preencherMonitoramento(EmpresaDao empDao, Map<String, String> json) {
		Monitoramento monitoramento = new Monitoramento();
		monitoramento.setEmpresa(empDao.obterEmpresa(Long.parseLong(json.get("id_empresa"))));
		monitoramento.setPrecoCompra(Double.parseDouble(json.get("preco_compra")));
		monitoramento.setPrecoVenda(Double.parseDouble(json.get("preco_venda")));
		return monitoramento;
	}

}
