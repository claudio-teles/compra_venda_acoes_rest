package claudioteles.com.github.compra_venda_acoes_rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import claudioteles.com.github.compra_venda_acoes_rest.modelos.Empresa;

public interface RepositorioEmpresa extends JpaRepository<Empresa, Long> {

}
