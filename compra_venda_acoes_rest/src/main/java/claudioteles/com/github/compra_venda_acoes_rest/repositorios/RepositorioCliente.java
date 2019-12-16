package claudioteles.com.github.compra_venda_acoes_rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import claudioteles.com.github.compra_venda_acoes_rest.modelos.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente, Long> {
	
	Boolean existsByNome(String nome);
	Boolean existsBySenha(String senha);
	
	Cliente findByNome(String nome);

}
