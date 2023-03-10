package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Musicien {
	@Value("${musicien.partition}") private String partition;
	@Autowired private Instrument instrument;
	
	public Musicien() {
		System.out.println("contructeur : "+partition);
	}
	public void jouer() {
		System.out.println(partition);
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
