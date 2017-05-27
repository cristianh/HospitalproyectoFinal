package eam.desarrollo.hospital.reports;

public class DataBean {
	private String category;
	private String serie;
	private double value;
	
	
	
	public DataBean(String category, String serie, double value) {
		this.category = category;
		this.serie = serie;
		this.value = value;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	
}