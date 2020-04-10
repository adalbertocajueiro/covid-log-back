package br.edu.ufcg.covidlog.model;

import java.time.LocalDateTime;


import br.edu.ufcg.covidlog.enums.KindOfNeed;

/**
 * A donation is provided by a donor to an entity. A donor has many options for donating 
 * to an entity. A donation can be simply involving money, food or service.
 * 
 * @author adalbertocajueiro
 *
 */
public class Donation {
	private String id;
	private KindOfNeed kind;
	private Need targetNeed;
	private String userId;
	private boolean requiresTransport;
	private String description;
	private LocalDateTime date;
	
	public Donation(KindOfNeed kind, Need targetNeed, String userId, Boolean requiresTransport, String description, LocalDateTime date) {
		this.kind = kind;
		this.targetNeed = targetNeed;
		this.userId = userId;
		this.requiresTransport = requiresTransport;
		this.description = description;
		this.date = date;
	}
	
	public Donation() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public KindOfNeed getKind() {
		return kind;
	}

	public void setKind(KindOfNeed kind) {
		this.kind = kind;
	}

	public Need getTargetNeed() {
		return targetNeed;
	}

	public void setTargetNeed(Need targetNeed) {
		this.targetNeed = targetNeed;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isRequiresTransport() {
		return requiresTransport;
	}

	public void setRequiresTransport(boolean requiresTransport) {
		this.requiresTransport = requiresTransport;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}	
}
