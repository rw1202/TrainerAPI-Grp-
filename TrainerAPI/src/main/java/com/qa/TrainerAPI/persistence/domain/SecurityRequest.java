package com.qa.TrainerAPI.persistence.domain;

public class SecurityRequest {

	private String userName;
	private String password;
	private boolean enabled;
	private String role;
	
	public SecurityRequest(Trainer trainer, String password) {
		this.userName = trainer.getUsername();
		this.password = password;
		this.enabled = true;
		this.role = "ROLE_TRAINER";
	}
	
}
