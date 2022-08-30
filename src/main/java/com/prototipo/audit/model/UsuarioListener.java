package com.prototipo.audit.model;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username = principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : principal.toString() ;
		
		UsuarioRevEntity revEntity = (UsuarioRevEntity) revisionEntity;
		revEntity.setUsuario(username);
		revEntity.setTimestemp(System.currentTimeMillis());
	}

}
