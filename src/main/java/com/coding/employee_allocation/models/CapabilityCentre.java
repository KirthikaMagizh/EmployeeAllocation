package com.coding.employee_allocation.models;

import lombok.Data;


public enum CapabilityCentre {
	
	
	PRODUCTANDPLATFORM("Product and Platform"),
	DEPCLOUD("DEP-Cloud"),
	DEVAA("DEVAA"),
	DEPQUALITY("DEP-Quality");
	
	CapabilityCentre(String string) {
		
		this.capabilityCentreName=string;
		
		
 	}

	private String capabilityCentreName;
	
	public String capabilityCentreName()
	{
		return capabilityCentreName;
		
	}
	
	@Override
	public String toString()
	{
		return capabilityCentreName;
	}

	
	

}

