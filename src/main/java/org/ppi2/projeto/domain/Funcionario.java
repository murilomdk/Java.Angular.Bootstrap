package org.ppi2.projeto.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	
	private String cpf;
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy="funcionario_cad")
	private List<Locacao> locacoesCad = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="funcionario_rec")
	private List<Locacao> locacoesRec = new ArrayList<>();
	
	

	public List<Locacao> getLocacoesCad() {
		return locacoesCad;
	}

	public void setLocacoesCad(List<Locacao> locacoesCad) {
		this.locacoesCad = locacoesCad;
	}

	public List<Locacao> getLocacoesRec() {
		return locacoesRec;
	}

	public void setLocacoesRec(List<Locacao> locacoesRec) {
		this.locacoesRec = locacoesRec;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", locacoesCad=" + locacoesCad
				+ ", locacoesRec=" + locacoesRec + "]";
	}
	
	
	
}
