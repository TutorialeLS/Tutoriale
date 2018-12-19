package app;

public enum Pizza {
	MARGHERITA(true, true, false, false),
	CAPRICIOSA(true, true, true, false),
	PROSCIUTTO(true, true, false, true);
	
	private boolean tomatoSauce;
	private boolean cheese;
	private boolean mushrooms;
	private boolean ham;

	public boolean isTomatoSauce() {
		return tomatoSauce;
	}

	public void setTomatoSauce(boolean tomatoSauce) {
		this.tomatoSauce = tomatoSauce;
	}

	public boolean isCheese() {
		return cheese;
	}

	public void setCheese(boolean cheese) {
		this.cheese = cheese;
	}

	public boolean isMushrooms() {
		return mushrooms;
	}

	public void setMushrooms(boolean mushrooms) {
		this.mushrooms = mushrooms;
	}

	public boolean isHam() {
		return ham;
	}

	public void setHam(boolean ham) {
		this.ham = ham;
	}

	private Pizza(boolean tomatoSauce, boolean cheese, boolean mushrooms, boolean ham) {
		this.tomatoSauce = tomatoSauce;
		this.cheese = cheese;
		this.mushrooms = mushrooms;
		this.ham = ham;
	}
    public String toString() {
        //przypisanie nazwy pizzy
        StringBuffer str= new StringBuffer();
        //informacja o składnikach
        if(tomatoSauce) {
            str.append(" sos pomidorowy ");
        }
        if(cheese) {
            str.append("ser ");
        }
        if(mushrooms) {
            str.append("pieczarki ");
        }
        if(ham) {
            str.append("szynka ");
        }
          
        return str.toString();
    }
}