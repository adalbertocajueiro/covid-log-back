package br.edu.ufcg.covidlog.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.edu.ufcg.covidlog.enums.KindOfNeed;
import br.edu.ufcg.covidlog.enums.StatusOfNeed;

/**
 * the needs of entities are represented in this class
 * @author adalbertocajueiro
 *
 */
@Document(collection = "needs")
public class Need {
	@Id
	@JsonProperty
	private String id;
	private KindOfNeed kind;
	private StatusOfNeed status;
	private String entityId;
	private String description;
	private LocalDateTime date;
	
	public Need(KindOfNeed kind, StatusOfNeed status, String entityId, String description, LocalDateTime date) {
		this.kind = kind;
		this.status = status;
		this.entityId = entityId;
		this.description = description;
		this.date = date;
	}
	 
	public Need() {

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

	public StatusOfNeed getStatus() {
		return status;
	}

	public void setStatus(StatusOfNeed status) {
		this.status = status;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
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
