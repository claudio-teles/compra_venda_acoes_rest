package claudioteles.com.github.compra_venda_acoes_rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.compra_venda_acoes_rest.modelos.Conta;
import claudioteles.com.github.compra_venda_acoes_rest.repositorios.RepositorioConta;

@Repository
public class ContaDao {
	
	@Autowired
	private RepositorioConta repositorioConta;
	
	public Conta criarConta(Conta conta) {
		return repositorioConta.save(conta);
	}
	
	public Conta consultarUmaConta(Long id_conta) {
		return repositorioConta.getOne(id_conta);
	}
	
	public List<Conta> consultarContas() {
		return repositorioConta.findAll();
	}
	
	public void atualizarConta(Conta conta) {
		repositorioConta.save(conta);
	}

}
