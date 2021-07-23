package br.com.Apex.ApexLegends;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lenda {
		
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long Id_Lenda;
	
	private String nome;
	private String tipo;
	private int kills;
	private int nroSkins;
	
	public long getId_Lenda() {
		return Id_Lenda;
	}
	public void setId_Lenda(long id_Lenda) {
		Id_Lenda = id_Lenda;
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
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getNroSkins() {
		return nroSkins;
	}
	public void setNroSkins(int nroSkins) {
		this.nroSkins = nroSkins;
	}
	@Override
	public String toString() {
		return "Lenda [Id_Lenda=" + Id_Lenda + ", nome=" + nome + ", tipo=" + tipo + ", kills=" + kills + ", nroSkins="
				+ nroSkins + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id_Lenda ^ (Id_Lenda >>> 32));
		result = prime * result + kills;
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
		Lenda other = (Lenda) obj;
		if (Id_Lenda != other.Id_Lenda)
			return false;
		if (kills != other.kills)
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
