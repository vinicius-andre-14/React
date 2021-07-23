package br.com.Apex.ApexLegends;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Armas {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long Id_Arma;
	
	private String nome;
	private String tipo;
	private String municao;
	private int nroSkins;
	private int dano;
	private int danohs;
	public long getId_Arma() {
		return Id_Arma;
	}
	public void setId_Arma(long id_Arma) {
		Id_Arma = id_Arma;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMunicao() {
		return municao;
	}
	public void setMunicao(String municao) {
		this.municao = municao;
	}
	public int getNroSkins() {
		return nroSkins;
	}
	public void setNroSkins(int nroSkins) {
		this.nroSkins = nroSkins;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public int getDanohs() {
		return danohs;
	}
	public void setDanohs(int danohs) {
		this.danohs = danohs;
	}
	@Override
	public String toString() {
		return "Armas [Id_Arma=" + Id_Arma + ", nome=" + nome + ", tipo=" + tipo + ", municao=" + municao
				+ ", nroSkins=" + nroSkins + ", dano=" + dano + ", danohs=" + danohs + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id_Arma ^ (Id_Arma >>> 32));
		result = prime * result + dano;
		result = prime * result + danohs;
		result = prime * result + ((municao == null) ? 0 : municao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + nroSkins;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Armas other = (Armas) obj;
		if (Id_Arma != other.Id_Arma)
			return false;
		if (dano != other.dano)
			return false;
		if (danohs != other.danohs)
			return false;
		if (municao == null) {
			if (other.municao != null)
				return false;
		} else if (!municao.equals(other.municao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nroSkins != other.nroSkins)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
}
