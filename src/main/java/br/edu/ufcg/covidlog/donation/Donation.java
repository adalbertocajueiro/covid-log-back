package br.edu.ufcg.covidlog.donation;

import java.util.GregorianCalendar;

import br.edu.ufcg.covidlog.needs.Need;
import br.edu.ufcg.covidlog.util.KindOfNeed;

/**
 * A donation is provided by a donor to an entity. A donor has many options for donating 
 * to an entity. A donation can be simply involving money, food or service.
 * 
 * @author adalbertocajueiro
 *
 */
public class Donation {
	private long id;
	private KindOfNeed kind;
	private Need targetNeed;
	private boolean requiresTransport;
	private String description;
	private GregorianCalendar date;
}
