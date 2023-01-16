package demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Musicien {
	@Autowired private String partition;
	@Autowired private String bar;
	@Autowired private Instrument instrument;	
	
	{
		System.out.println("Musicien");
	}
	public Musicien() {
		System.out.println("Musicien constructeur par défaut - partition : "+partition);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Musicien postContruct par défaut - partition : "+partition);
	}
	
	@PreDestroy
	public void preDestroyed() {
		System.out.println("Musicien @PreDestroy  - partition : "+partition);
	}
	public void jouer() {
		System.out.println(partition);
		System.out.println(bar);
		instrument.jouer();
	}
	public String getPartition() {
		return partition;
	}
	public void setPartition(String partition) {
		this.partition = partition;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	
}
