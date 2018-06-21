package org.ppi2.projeto.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

public class Locacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	
	@ManyToOne
	private Veiculo veiculo;
	
	
	@ManyToOne
	private Cliente cliente;
	
	
	@ManyToOne
	private Funcionario funcionario_cad;
	
	
	
	@ManyToOne
	private Funcionario funcionario_rec;

	@ManyToMany
	private List<Avaria> avarias = new ArrayList<>();
	
	@ManyToMany
	private List<Multa> multas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario_cad() {
		return funcionario_cad;
	}

	public void setFuncionario_cad(Funcionario funcionario_cad) {
		this.funcionario_cad = funcionario_cad;
	}

	public Funcionario getFuncionario_rec() {
		return funcionario_rec;
	}

	public void setFuncionario_rec(Funcionario funcionario_rec) {
		this.funcionario_rec = funcionario_rec;
	}

	public List<Avaria> getAvarias() {
		return avarias;
	}

	public void setAvarias(List<Avaria> avarias) {
		this.avarias = avarias;
	}

	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	@Override
	public String toString() {
		return "Locacao [id=" + id + ", data=" + data + ", veiculo=" + veiculo + ", cliente=" + cliente
				+ ", funcionario_cad=" + funcionario_cad + ", funcionario_rec=" + funcionario_rec + ", avarias="
				+ avarias + ", multas=" + multas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Locacao other = (Locacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
