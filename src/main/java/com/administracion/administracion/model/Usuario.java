package com.administracion.administracion.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1562055728863550711L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, name = "apto")
	private Long apto;

	@Column(nullable = false, name = "nombre")
	private String name;

	@Column(length = 100, name = "correo")
	private String email;

	@Column(unique = true, name = "telefono")
	private Long telephoneNumber;

	public Usuario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getApto() {
		return apto;
	}

	public void setApto(Long apto) {
		this.apto = apto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(Long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, telephoneNumber, apto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(telephoneNumber, other.telephoneNumber) && Objects.equals(apto, other.apto);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", torre=" + apto + ", name=" + name + ", email=" + email + ", telephoneNumber="
				+ telephoneNumber + "]";
	}

}
