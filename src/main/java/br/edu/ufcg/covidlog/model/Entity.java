package br.edu.ufcg.covidlog.model;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

/**
 * Entity is a community or group that demands any help.
 * 
 * @author adalbertocajueiro
 *
 */
public class Entity {
	private long id;
	private String name;
	
	 @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	 private GeoJsonPoint location;
	//precisa representar aqui as coordenadas do local
}
