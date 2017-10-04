package com.fabriciotn.apiweb.auditoria;

import javax.persistence.Entity;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity(name = "revinfo_cust")
@RevisionEntity(AuditListner.class)
public class AuditEntity extends DefaultRevisionEntity {
	
	private static final long serialVersionUID = 1L;

	public String usuario;
	public String ip;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
