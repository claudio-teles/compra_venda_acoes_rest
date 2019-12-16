package claudioteles.com.github.compra_venda_acoes_rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import claudioteles.com.github.compra_venda_acoes_rest.modelos.Conta;

public interface RepositorioConta extends JpaRepository<Conta, Long> {

}
