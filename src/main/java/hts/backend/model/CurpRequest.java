package hts.backend.model;

public class CurpRequest {

	private String curp;
	
	public CurpRequest(){}

	public CurpRequest(String curp) {
		super();
		this.curp = curp;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	
}