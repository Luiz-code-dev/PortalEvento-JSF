package portaldeevento;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {

	private Integer id;
	private String nomeCompleto;
	private String apelido;
	private String email;
	private String senha;
	
	private List<String> nomes = new ArrayList<String> ();
	
	public String addNome() {
		nomes.add(nomeCompleto);
		return "";
	}

	public UsuarioBean() {
	}

	public UsuarioBean(String nomeCompleto, String apelido, String email, String senha, Integer id) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.apelido = apelido;
		this.email = email;
		this.senha = senha;
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

	
}
