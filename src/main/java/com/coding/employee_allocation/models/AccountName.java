package com.coding.employee_allocation.models;

public enum AccountName {
	ANCESTRY("Ancestry"),
	BNYM("BNYM"),
	CALIBOLLC("Calibo LLC"),
	EXPERIAN("Experian"),
	FORD("Ford"),
	GURANTEEDRATE("GuranteedRate"),
	INVOICECLOUD("Invoice Cloud"),
	VATIKUTTIVENTURESLLC("Vatikutti Vetures LLC"),
	ZIPCOUSINC("Zip Co US Inc"),
	PAYPAL("PayPal"),
	JOHNSONCONTROLSINC("Jonhson Controls Inc"),
	WESTERENUNION("Western Union");

	private String accountNameDetail;
	AccountName(String string) {
		// TODO Auto-generated constructor stub
	}
	public String accountNameDetail()
	{
		return accountNameDetail;
		
	}
	
	@Override
	public String toString()
	{
		return accountNameDetail;
	}
	
	

}
