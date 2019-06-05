package com.bvlsh.audit.models;

public class StatisticDTO {

	
	String inProcess;
	String canceled;
	String finished;
	
	
	public String getInProcess() {
		return inProcess;
	}
	public void setInProcess(String inProcess) {
		this.inProcess = inProcess;
	}
	public String getCanceled() {
		return canceled;
	}
	public void setCanceled(String canceled) {
		this.canceled = canceled;
	}
	public String getFinished() {
		return finished;
	}
	public void setFinished(String finished) {
		this.finished = finished;
	}
	
	
}
