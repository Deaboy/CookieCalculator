package com.deaboy.CookieCalculator;

public enum BuildingType
{
	CURSOR,
	GRANDMA,
	FARM,
	FACTORY,
	MINE,
	SHIPMENT,
	ALCHEMY_LAB,
	PORTAL,
	TIME_MACHINE,
	ANTIMATTER_CONDENSER;
	
	public String getName(boolean plural)
	{
		switch (this)
		{
		case CURSOR:
			return plural ? "cursors" : "cursor";
		case GRANDMA:
			return plural ? "grandmas" : "grandma";
		case FARM:
			return plural ? "farms" : "farm";
		case FACTORY:
			return plural ? "factories" : "factory";
		case MINE:
			return plural ? "mines" : "mine";
		case SHIPMENT:
			return plural ? "shipments" : "shipment";
		case ALCHEMY_LAB:
			return plural ? "alchemy labs" : "alchemy lab";
		case PORTAL:
			return plural ? "portals" : "portal";
		case TIME_MACHINE:
			return plural ? "time machines" : "time machine";
		case ANTIMATTER_CONDENSER:
			return plural ? "antimatter condensers" : "antimatter condenser";
		default:
			return plural ? "buildings" : "building";
		}
	}
	
	public static BuildingType fromString(String string)
	{
		string.toLowerCase();
		string.replaceAll("_", " ");
		
		if (string.equals("cursor") || string.equals("cursors") || string.equals("0"))
			return CURSOR;
		else if (string.equals("grandma") || string.equals("grandmas") || string.equals("1"))
			return GRANDMA;
		else if (string.equals("farm") || string.equals("farms") || string.equals("2"))
			return FARM;
		else if (string.equals("factory") || string.equals("factories") || string.equals("3"))
			return FACTORY;
		else if (string.equals("mine") || string.equals("mines") || string.equals("4"))
			return MINE;
		else if (string.equals("shipment") || string.equals("shipments") || string.equals("5"))
			return SHIPMENT;
		else if (string.equals("alchemy lab") || string.equals("alchemy labs") || string.equals("lab") || string.equals("labs") || string.equals("6"))
			return ALCHEMY_LAB;
		else if (string.equals("portal") || string.equals("portals") || string.equals("7"))
			return PORTAL;
		else if (string.equals("time machine") || string.equals("time machines") || string.equals("time") || string.equals("8"))
			return TIME_MACHINE;
		else if (string.equals("antimatter condenser") || string.equals("antimatter condensers") || string.equals("antimatter") || string.equals("condenser") || string.equals("condensers") || string.equals("9"))
			return ANTIMATTER_CONDENSER;
		else
			return null;
	}
}
