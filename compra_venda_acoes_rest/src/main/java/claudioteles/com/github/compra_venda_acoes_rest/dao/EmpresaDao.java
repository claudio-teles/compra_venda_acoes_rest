package claudioteles.com.github.compra_venda_acoes_rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import claudioteles.com.github.compra_venda_acoes_rest.modelos.Empresa;
import claudioteles.com.github.compra_venda_acoes_rest.repositorios.RepositorioEmpresa;

@Repository
public class EmpresaDao {
	
	@Autowired
	private RepositorioEmpresa repositorioEmpresa;
	
	public void salvarOuAtualizar(Empresa empresa) {
		repositorioEmpresa.save(empresa);
	}
	
	public Empresa obterEmpresa(Long id_empresa) {
		return repositorioEmpresa.getOne(id_empresa);
	}
	
	public List<Empresa> pegarTodasEmpresas() {
		return repositorioEmpresa.findAll();
	}

}
