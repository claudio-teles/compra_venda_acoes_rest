package claudioteles.com.github.compra_venda_acoes_rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import claudioteles.com.github.compra_venda_acoes_rest.modelos.Negocio;

public interface RepositorioNegocio extends JpaRepository<Negocio, Long> {

}
