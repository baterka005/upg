package sp2;

public class MessengerData {
	
	public String nameTown;
	public int[] population;
	public int[] work;
	public int[] crimi;
	
    public MessengerData(String nameTown, int[] population, int[] work, int[] crimi) {
    	this.nameTown = nameTown;
    	this.population = population;
    	this.work = work;
    	this.crimi = crimi;
    }
    
    public String getNameTown() {
		return nameTown;
	}

	public void setNameTown(String nameTown) {
		this.nameTown = nameTown;
	}

	public int[] getPopulation() {
		return population;
	}

	public void setPopulation(int[] population) {
		this.population = population;
	}

	public int[] getWork() {
		return work;
	}

	public void setWork(int[] work) {
		this.work = work;
	}

	public int[] getCrimi() {
		return crimi;
	}

	public void setCrimi(int[] crimi) {
		this.crimi = crimi;
	}
}
