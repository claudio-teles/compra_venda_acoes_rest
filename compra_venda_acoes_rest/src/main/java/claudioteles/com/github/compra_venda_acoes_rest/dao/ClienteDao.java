package claudioteles.com.github.compra_venda_acoes_rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.compra_venda_acoes_rest.modelos.Cliente;
import claudioteles.com.github.compra_venda_acoes_rest.repositorios.RepositorioCliente;

@Repository
public class ClienteDao {
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	public Cliente pegarCliente(Long id_cliente) {
		return repositorioCliente.getOne(id_cliente);
	}

}
