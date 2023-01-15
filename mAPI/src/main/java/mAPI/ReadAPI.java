package mAPI;

public class ReadAPI {
	String [] WebPage;
	int state_province;
	String alpha_two_code;
	String name;
	String country;
	String [] domains;
	public String[] getWebPage() {
		return WebPage;
	}
	public void setWebPage(String[] webPage) {
		WebPage = webPage;
	}
	public int getState_province() {
		return state_province;
	}
	public void setState_province(int state_province) {
		this.state_province = state_province;
	}
	public String getAlpha_two_code() {
		return alpha_two_code;
	}
	public void setAlpha_two_code(String alpha_two_code) {
		this.alpha_two_code = alpha_two_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getDomains() {
		return domains;
	}
	public void setDomains(String[] domains) {
		this.domains = domains;
	}
	
	
}
