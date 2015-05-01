package sp2;


public class InputData {
	
	private Mod mode;
	private int year;
	private String nameFileExport;
	
	/**
	 * Zkontroluje, zda je pocet parametru spravny.
	 * @param args
	 */
	public void checkCountParameters(String args[]) {
		if (args.length != 3) {
			error("Spatny pocet parametru.");
		}
	}
	
	/**
	 * Zkontroluje, zda je prvni parametr v poradku.
	 * @param args
	 */
	private Mod checkMod(String mode) {
		
		switch(mode) {
		case "POP": return Mod.POP;
		case "WRK": return Mod.WRK;
		case "CRM": return Mod.CRM;
		default: error("Zadali jste spatny rezim programu.");
		}
		return null;

	}
	
	/**
	 * Zkontroluje, zda je druhy parametr v poradku.
	 * @param year
	 * @return
	 */
	private int checkYear(String year) {
		int newYear = Integer.parseInt(year);
		if (newYear >= 2000 && newYear <= 2013) {
			return newYear;
		}
		error("Zadali jste spatny rok.");
		return 0;
	}
	
	/**
	 * Chybova hlaska.
	 * @param msg
	 */
	private void error(String msg) {
		System.out.println(msg);
		System.exit(0);
	}
	
	public Mod getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = checkMod(mode);
	}

	public int getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = checkYear(year);
	}

	public String getNameFileExport() {
		return nameFileExport;
	}

	public void setNameFileExport(String nameFileExport) {
		this.nameFileExport = nameFileExport;
	}
	
	
}
