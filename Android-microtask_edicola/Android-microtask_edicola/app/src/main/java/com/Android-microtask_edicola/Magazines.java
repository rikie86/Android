
package com.Android_microtask_edicola;


public final class Magazines
{

	private static Magazines istance = null; 

	private String[] titles;
	private String[] covers;
	private boolean[] isForSale;

	private Magazines() {};

	public Magazines(String[] t, String[] c, boolean[] d){
		this.titles = t;
		this.covers = c;
		this.isForSale = d;
	}

	public static Magazines getIstance(){	
		if (istance == null)
			istance = new Magazines();		
		return istance;	
	}

	public void setTitles(String[] Callback_body){	
		istance.titles = Callback_body;	
	} 

	public void setCovers(String[] Callback_body){	
		istance.covers = Callback_body;	
	}

	public void setAvailability(boolean[] Callback_availability){	
		istance.isForSale = Callback_availability;
	}

	public String[] getTitles(){	
		return istance.titles;	
	} 

	public String[] getCovers(){	
		return istance.covers;	
	}

	public boolean[] getAvailability(){	
		return istance.isForSale;
	}
}
