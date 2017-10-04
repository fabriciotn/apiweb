package com.fabriciotn.apiweb.auditoria;

import org.hibernate.envers.RevisionListener;

public class AuditListner implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		AuditEntity revEntity = (AuditEntity) revisionEntity;
		revEntity.setUsuario("usuário");
		revEntity.setIp("127.0.0.1");
	}

}
