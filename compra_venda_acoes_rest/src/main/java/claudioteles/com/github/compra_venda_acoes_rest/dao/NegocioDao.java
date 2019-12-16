package claudioteles.com.github.compra_venda_acoes_rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.compra_venda_acoes_rest.modelos.Negocio;
import claudioteles.com.github.compra_venda_acoes_rest.repositorios.RepositorioNegocio;

@Repository
public class NegocioDao {
	
	@Autowired
	private EmpresaDao empresaDao;
	
	@Autowired
	private RepositorioNegocio repositorioNegocio;
	
	public Negocio salvar(Negocio negocio) {
		return repositorioNegocio.save(negocio);
	}
	
	public List<Negocio> buscarNegocios() {
		return repositorioNegocio.findAll();
	}

}
