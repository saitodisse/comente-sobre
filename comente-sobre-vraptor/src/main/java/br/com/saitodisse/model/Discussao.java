package br.com.saitodisse.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*	
 * entidade Discussao
 * ------------------
 * Toda discussao tem uma mensagem principal, a pergunta
 * e pode possui varias mensagens secundárias, as respostas
 * 
 * */
@Entity
public class Discussao {
	
	public Discussao() {
		this.respostas = new ArrayList<Mensagem>();
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne (cascade = {CascadeType.ALL})
	private Mensagem pergunta;
	
	@OneToMany (cascade = {CascadeType.ALL})
	private List<Mensagem> respostas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Mensagem getPergunta() {
		return pergunta;
	}
	public void setPergunta(Mensagem pergunta) {
		this.pergunta = pergunta;
	}
	
	public List<Mensagem> getRespostas() {
		return respostas;
	}
	public void addResposta(Mensagem resposta) {
		this.respostas.add(resposta);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Discussao other = (Discussao) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}
	
}
