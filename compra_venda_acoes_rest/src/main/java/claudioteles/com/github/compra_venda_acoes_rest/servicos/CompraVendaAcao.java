package claudioteles.com.github.compra_venda_acoes_rest.servicos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import claudioteles.com.github.compra_venda_acoes_rest.dao.ContaDao;
import claudioteles.com.github.compra_venda_acoes_rest.dao.EmpresaDao;
import claudioteles.com.github.compra_venda_acoes_rest.dao.NegocioDao;
import claudioteles.com.github.compra_venda_acoes_rest.modelos.Conta;
import claudioteles.com.github.compra_venda_acoes_rest.modelos.Empresa;
import claudioteles.com.github.compra_venda_acoes_rest.modelos.Negocio;

@Service
public class CompraVendaAcao {
	
	@Autowired
	private ServicoEmail servicoEmail;
	
	@Autowired
	private ContaDao contaDao;
	
	@Autowired
	private EmpresaDao empresaDao;
	
	@Autowired
	private NegocioDao negocioDao;
	
	public Boolean compraAcao(Double valorBolsaValoresAgora, Conta conta, Empresa empresa, String destinatario, String assunto) {
		if (conta.getPrecoCompra() <= valorBolsaValoresAgora) {
			if ( conta.getPrecoCompra() <= empresa.getPrecoVendaUmaAcao() ) {
				if ( empresa.getTotalEmAcoes() % conta.getPrecoCompra() == 0) {
					conta.setQuantidadeAcoes((long) (conta.getSaldo() / conta.getQuantidadeAcoes())); // Formula p/ determinar a quantidade de ações.
					conta.setSaldo(0D);
					contaDao.atualizarConta(conta);
					
					empresa.setTotalEmAcoes(0D);
					empresaDao.salvarOuAtualizar(empresa);
					
					Double valorNegociado = empresa.getTotalEmAcoes();
					
					// Salvar a negociação
					Negocio negociacao = new Negocio();
					negociacao.setEmpresa(empresa);
					negociacao.setValorNegociado(valorNegociado);
					negociacao.setQuantidade( (int) (empresa.getTotalEmAcoes() / conta.getPrecoCompra()) );
					negociacao.setData(new Date());
					
					negocioDao.salvar(negociacao);
					
					// Enviar email para o cliente sobre a compra
					servicoEmail.enviarEmail(
						destinatario, assunto, 
						"Empresa: "+negociacao.getEmpresa()+"\n"
						+"Valor negociado: "+negociacao.getValorNegociado()+"\n"
						+"Quantidade: "+negociacao.getQuantidade()+"\n"
						+"Data: "+negociacao.getData()+""
					);
					
					return true;
				} else {
					Double quociente = ( empresa.getTotalEmAcoes() / conta.getPrecoCompra() );
					Double totalAcoesCompradas = ( quociente * conta.getPrecoCompra() );
					conta.setQuantidadeAcoes((long) (conta.getSaldo() / conta.getQuantidadeAcoes())); // Formula p/ determinar a quantidade de ações.
					conta.setSaldo(conta.getSaldo() - totalAcoesCompradas);
					contaDao.atualizarConta(conta);
					
					empresa.setTotalEmAcoes(empresa.getTotalEmAcoes() - totalAcoesCompradas);
					empresaDao.salvarOuAtualizar(empresa);
					// Salvar a negociação
					
					Negocio negociacao = new Negocio();
					negociacao.setEmpresa(empresa);
					negociacao.setValorNegociado(totalAcoesCompradas);
					negociacao.setQuantidade( (int) (empresa.getTotalEmAcoes() / conta.getPrecoCompra()) );
					negociacao.setData(new Date());
					
					negocioDao.salvar(negociacao);
					
					// Enviar email para o cliente sobre a venda
					servicoEmail.enviarEmail(
						destinatario, assunto, 
						"Empresa: "+negociacao.getEmpresa()+"\n"
						+"Valor negociado: "+negociacao.getValorNegociado()+"\n"
						+"Quantidade: "+negociacao.getQuantidade()+"\n"
						+"Data: "+negociacao.getData()+""
					);
					
					return true;
				}
			}
		}
		return false;
	}
	
	public Boolean venderAcao(Double valorBolsaValoresAgora, Conta conta, Empresa empresa, String assunto, String destinatario) {
		if ( conta.getPrecoVenda() <= valorBolsaValoresAgora ) {
			if (conta.getPrecoVenda() >= empresa.getPrecoCompraUmaAcao()) {
				Double valorAcoes = ( conta.getQuantidadeAcoes() * conta.getPrecoVenda() );
				empresa.setTotalEmAcoes(empresa.getTotalEmAcoes() + valorAcoes);
				
				empresaDao.salvarOuAtualizar(empresa);
				conta.setSaldo(conta.getSaldo() + valorAcoes);
				conta.setQuantidadeAcoes((long) (conta.getQuantidadeAcoes() - (valorAcoes / conta.getPrecoVenda())));
				contaDao.atualizarConta(conta);
				
				Negocio negociacao = new Negocio();
				negociacao.setEmpresa(empresa);
				negociacao.setValorNegociado(valorAcoes);
				negociacao.setQuantidade( (int) (empresa.getTotalEmAcoes() / conta.getPrecoCompra()) );
				negociacao.setData(new Date());
				
				negocioDao.salvar(negociacao);
				
				// Enviar email para o cliente sobre a compra
				servicoEmail.enviarEmail(
					destinatario, assunto, 
					"Empresa: "+negociacao.getEmpresa()+"\n"
					+"Valor negociado: "+negociacao.getValorNegociado()+"\n"
					+"Quantidade: "+negociacao.getQuantidade()+"\n"
					+"Data: "+negociacao.getData()+""
				);
				
				return true;
			}
		}
		
		return false;
	}
}
