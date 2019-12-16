package claudioteles.com.github.compra_venda_acoes_rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import claudioteles.com.github.compra_venda_acoes_rest.modelos.Monitoramento;

public interface RepositorioMonitoramento extends
		JpaRepository<Monitoramento, Long> {

}
