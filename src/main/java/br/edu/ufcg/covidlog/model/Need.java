package br.edu.ufcg.covidlog.model;

import java.util.GregorianCalendar;

import br.edu.ufcg.covidlog.enums.KindOfNeed;

/**
 * the needs of entities are represented in this class
 * @author adalbertocajueiro
 *
 */


enum Status {
	PENDING, RESOLVED
}
public class Need {
	private long id;
	private KindOfNeed kind;
	private Status status;
	private String description;
	private GregorianCalendar date; //verificar se esta é a melhor forma de guardar data
}
