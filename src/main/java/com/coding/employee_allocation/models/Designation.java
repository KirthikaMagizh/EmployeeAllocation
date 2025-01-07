package com.coding.employee_allocation.models;

public enum Designation {
	
	PRINCIPALENGINEER("Principal Engineer"),
	STAFFEENGINEER("Staff Engineer"),
	TECHNICALLEAD("Technical Lead"),
	ARCHITECT("Architect"),
	SENIORENGINEER("Senior Engineer"),
	ENGINEER("Engineer"),
	ASSOCENGINEER("Assoc Engineer");
	private String designationName;
	
	Designation(String string) {
		// TODO Auto-generated constructor stub
	}

	public String designationName()
	{
		return designationName;
	}
	
	@Override
	public String toString()
	{
		return designationName;
	}
	

}
