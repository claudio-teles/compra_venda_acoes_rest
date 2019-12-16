package claudioteles.com.github.compra_venda_acoes_rest.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import claudioteles.com.github.compra_venda_acoes_rest.dao.ClienteDao;
import claudioteles.com.github.compra_venda_acoes_rest.dao.ContaDao;
import claudioteles.com.github.compra_venda_acoes_rest.dao.EmpresaDao;
import claudioteles.com.github.compra_venda_acoes_rest.dao.MonitoramentoDao;
import claudioteles.com.github.compra_venda_acoes_rest.dao.NegocioDao;
import claudioteles.com.github.compra_venda_acoes_rest.modelos.Conta;
import claudioteles.com.github.compra_venda_acoes_rest.modelos.Empresa;
import claudioteles.com.github.compra_venda_acoes_rest.modelos.Monitoramento;
import claudioteles.com.github.compra_venda_acoes_rest.modelos.Negocio;
import claudioteles.com.github.compra_venda_acoes_rest.repositorios.RepositorioCliente;
import claudioteles.com.github.compra_venda_acoes_rest.servicos.CompraVendaAcao;
import claudioteles.com.github.compra_venda_acoes_rest.servicos.ServicoMonitoramento;

@CrossOrigin
@RestController
@RequestMapping("/api_rest")
@SessionScope
public class AcaoRestControlador {
	
	private Boolean logado = false;
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	@Autowired
	private ServicoMonitoramento sm;
	@Autowired
	private CompraVendaAcao cva;
	
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private ContaDao contaDao;
	@Autowired
	private EmpresaDao empDao;
	@Autowired
	private MonitoramentoDao monDao;
	
	@Autowired
	private NegocioDao negDao;
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean> fazerLogin(@RequestBody Map<String, String> json) {
		if ( repositorioCliente.existsByNome(json.get("nome")) && repositorioCliente.existsBySenha(json.get("senha")) ) {
			Map<String, Boolean> resposta = new HashMap<String, Boolean>();
			resposta.put("logado", true);
			this.setLogado(true);
			return resposta;
		} else {
			Map<String, Boolean> resposta = new HashMap<String, Boolean>();
			resposta.put("logado", false);
			this.setLogado(false);
			return resposta;
		}
	}
	
	@PostMapping("/contas")
	@ResponseStatus(HttpStatus.CREATED)
	public Conta criarContaCliente(@RequestBody Map<String, String> json) {
		if (this.getLogado() == true) {
			Conta conta = new Conta();
			conta.setCliente(clienteDao.pegarCliente(Long.parseLong(json.get("id_cliente"))));
			conta.setEmailNotificacao(json.get("email_notificacao"));
			conta.setSaldo(Double.parseDouble(json.get("saldo_inicial")));
			conta.setPrecoCompra(Double.parseDouble(json.get("preco_compra")));
			conta.setPrecoVenda(Double.parseDouble(json.get("preco_venda")));
			conta.setQuantidadeAcoes(0L);
			return contaDao.criarConta(conta);
		}
		return null;
	}
	
	@GetMapping("/contas/{id_conta}")
	@ResponseStatus(HttpStatus.OK)
	public Conta consultarConta(@PathVariable Long id_conta) {
		if (this.getLogado() == true) {
			return contaDao.consultarUmaConta(id_conta);
		}
		return null;
	}
	
	@GetMapping("/contas")
	@ResponseStatus(HttpStatus.OK)
	public List<Conta> consultarContas() {
		if (this.getLogado() == true) {
			return contaDao.consultarContas();
		}
		return null;
	}
	
	@GetMapping("/contas/comprar_e_vender_acoes/{id_conta}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Negocio> comprarE_VenderAcao(@PathVariable Long id_conta, @PathParam("destinatario") String destinatario, @PathParam("assunto") String assunto) {
		System.out.println("Id conta: "+id_conta+"\nDestinatário: "+destinatario+"\nAssunto: "+assunto+"\n");
		if (this.getLogado() == true) {
			Double valorAcaoAleatorio = 0D;
			int contador = 0;
			while (contador <= 100) { // Executar 100 iterações para gerar um relatório.
				try {
					Thread.sleep(5000); // A bolsa de valores gera um valor a cada 5 segundos.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				int numeroAleatorio = new Random(0).nextInt(30000); // Valor gerado de 0 -> 30.000.
				Double preco = (double) (10 + (1 * numeroAleatorio));
				valorAcaoAleatorio = preco;
				this.comprar(id_conta, valorAcaoAleatorio, destinatario, assunto); // Comprar uma ação.
				this.vender(id_conta, valorAcaoAleatorio, destinatario, assunto); // Vender uma açãco.
				contador++;
				System.out.println("Contador: "+contador);
			}
			return negDao.buscarNegocios();
		}
		return null;
	}
	
	@PostMapping("/monitoramentos")
	@ResponseStatus(HttpStatus.CREATED)
	public Monitoramento inserirMonitoramento(@RequestBody Map<String, String> json) {
		if (this.getLogado() == true) {
			return monDao.inserir(sm.preencherMonitoramento(empDao, json));
		}
		return null;
	}
	
	@GetMapping("/monitoramentos/{id_monitoramento}")
	@ResponseStatus(HttpStatus.OK)
	public Monitoramento consultarMonitoramento(@PathVariable Long id_monitoramento) {
		if (this.getLogado() == true) {
			return monDao.buscar(id_monitoramento);
		}
		return null;
	}
	
	@GetMapping("/monitoramentos")
	@ResponseStatus(HttpStatus.OK)
	public List<Monitoramento> consultarMonitoramentos() {
		if (this.getLogado() == true) {
			return monDao.buscarMonitoramentos();
		}
		return null;
	}
	
	@PutMapping("/monitoramentos/{id_monitoramento}")
	@ResponseStatus(HttpStatus.OK)
	public Monitoramento alterarMonitoramento(@PathVariable Long id_monitoramento, @RequestBody Map<String, String> json) {
		if (this.getLogado() == true) {
			return monDao.alterar(id_monitoramento, json);
		}
		return null;
	}
	
	
	@DeleteMapping("/monitoramentos/{id_monitoramento}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean> deletarMonitoramento(@PathVariable Long id_monitoramento) {
		if (this.getLogado() == true) {
			Map<String, Boolean> resposta = new HashMap<String, Boolean>();
			if (monDao.excluir(id_monitoramento)) {
				resposta.put("monitoramento_deletado", true);
				return resposta;
			} else {
				resposta.put("monitoramento_deletado", false);
				return resposta;
			}
		}
		return null;
	}

	public Boolean getLogado() {
		return logado;
	}

	public void setLogado(Boolean logado) {
		this.logado = logado;
	}
	
	/**
	 * @param id_conta A conta do usuário.
	 * @param valorAcaoAleatorio Gerado pela bolsa de valores.
	 * @param destinatario O e-mail para conferir a compra e venda de ações.
	 * @param assunto O assunto do e-mail para conferir a compra e venda de ações.
	 * 
	 * Esse metodo realiza a compra de todas as ações que forem possíveis durante um loop de 100 iterações.
	 * 
	 */
	private void comprar(Long id_conta, Double valorAcaoAleatorio, String destinatario, String assunto) {
		for (Empresa empresa : empDao.pegarTodasEmpresas()) {
			cva.compraAcao(valorAcaoAleatorio, contaDao.consultarUmaConta(id_conta), empresa, destinatario, assunto);
		}
	}
	
	/**
	 * @param id_conta A conta do usuário.
	 * @param valorAcaoAleatorio Gerado pela bolsa de valores.
	 * @param destinatario O e-mail para conferir a venda e venda de ações.
	 * @param assunto O assunto do e-mail para conferir a compra e venda de ações.
	 * 
	 * Esse metodo realiza a venda de todas as ações que forem possíveis durante um loop de 100 iterações.
	 * 
	 */
	private void vender(Long id_conta, Double valorAcaoAleatorio, String destinatario, String assunto) {
		for (Empresa empresa : empDao.pegarTodasEmpresas()) {
			cva.venderAcao(valorAcaoAleatorio, contaDao.consultarUmaConta(id_conta), empresa, destinatario, assunto);
		}
	}

}
