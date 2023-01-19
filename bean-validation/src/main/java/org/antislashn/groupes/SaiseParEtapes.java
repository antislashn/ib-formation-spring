package org.antislashn.groupes;

import javax.validation.constraints.NotNull;

public class SaiseParEtapes {
	@NotNull(message="step1 ne peut pas être null", groups= {Step1.class,Step2.class,Step3.class})
	private String etape1;
	
	@NotNull(message="step2 ne peut pas être null", groups= {Step2.class,Step3.class})
	private String etape2;
	
	@NotNull(message="step3 ne peut pas être null", groups= {Step3.class})
	private String etape3;

	public String getEtape1() {
		return etape1;
	}

	public void setEtape1(String etape1) {
		this.etape1 = etape1;
	}

	public String getEtape2() {
		return etape2;
	}

	public void setEtape2(String etape2) {
		this.etape2 = etape2;
	}

	public String getEtape3() {
		return etape3;
	}

	public void setEtape3(String etape3) {
		this.etape3 = etape3;
	}
	
	
}
