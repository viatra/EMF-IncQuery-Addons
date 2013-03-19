package hu.bme.mit.obsolete.incquery.cep.eventmodel;

public class Timewindow {
	private Long length;
	
	public Timewindow(Long length) {
		this.length = length;
	}
	
	public Long getLength() {
		return length;
	}
	
	public void setLength(Long length) {
		this.length = length;
	}
}