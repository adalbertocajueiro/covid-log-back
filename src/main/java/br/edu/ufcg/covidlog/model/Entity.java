package br.edu.ufcg.covidlog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Entity is a community or group that demands any help.
 * 
 * @author adalbertocajueiro
 *
 */
@Document(collection = "entities")
public class Entity {
	@Id
	@JsonProperty
	private String id;
	private String name;
	
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private GeoJsonPoint location;
	 
	public Entity(String name, Double longitude, Double latitude) {
		this.name = name;
		this.location = new GeoJsonPoint(longitude, latitude);
	}
	 
	public Entity() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GeoJsonPoint getLocation() {
		return location;
	}

	public void setLocation(Double longitude, Double latitude) {
		this.location = new GeoJsonPoint(longitude, latitude);
	}
}
