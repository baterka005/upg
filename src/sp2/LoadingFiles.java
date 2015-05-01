package sp2;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadingFiles {
	
	/** */
	private ArrayList<MessengerDistrict> titles = new ArrayList<MessengerDistrict>();	
	/** */
	private ArrayList<MessengerData> data = new ArrayList<MessengerData>();
	
	public void loadFiles(){
		loadData("data_okresy.txt");
		loadDistricts("okresy.txt");
	}
	
	public List<DistrictItem> getDistrict(){
		List<DistrictItem> district = new ArrayList<DistrictItem>();
		
		for(int i = 0; i < data.size(); i++){			
			for(int j = 0; j < titles.size(); j++){
				if (data.get(i).equals("Benešov")){
					System.out.println(data.get(i).getNameTown()+"    "+titles.get(j).getName());
					district.add(new DistrictItem(titles.get(j), data.get(i)));				
				}
			}
		}
		
		return district;
	}


	/**
	 * Nacte soubor s daty jednotlivych okresu. Informace o poctu obyvatel, podil pracovni sily a podil trestne cinnosti.
	 * @param fileName
	 */
	private void loadData(String fileName) {
		String nameTown = null;
		int[] population = null;
		int[] work = null;
		int[] crimi = null;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(
			        new InputStreamReader(new FileInputStream(fileName)));
		} catch (FileNotFoundException e) {
			System.out.println("Chyba pri praci se souborem.");
		}
		
		    String line;
		    int numberLine = 0;
				   
		    try {
				while ((line = br.readLine()) != null) {
					
					if (numberLine % 4 == 0){
						nameTown = line;
					}else if (numberLine % 4 == 1){
						population = parseLine(line);
					}else if (numberLine % 4 == 2){
						work = parseLine(line);
					}else if (numberLine % 4 == 3){
						crimi = parseLine(line);
						data.add(new MessengerData(nameTown, population, work, crimi));
					}
					numberLine++;

				}
			} catch (IOException e) {
				System.out.println("Nepodarilo se otevrit soubor");
			}
	
	}
	/**
	 * Rozdeli radku podle carky na jednotliva cisla.
	 * @param line
	 * @return
	 */
	private int [] parseLine(String line){
		String [] resultS = line.split(",");
		int [] result = new int[resultS.length];
		
		for (int i = 0; i < resultS.length; i++){
			result[i] = Integer.parseInt(resultS[i]);
		}
		
		return result;
	}
	
	/**
	 * Nacte soubor, kde jsou ulozeny jednotlive okresy. Informace o okresech a jejich souradnice.
	 * @param fileName
	 */
	private void loadDistricts(String fileName) {
		String line = null;
		String name = null;
		String shortcut = null;
		String nuts3 = null;
		String nuts4 = null;
		List<MessengerCoordinates> coordinates = null;
		String field[];
		MessengerDistrict msgDis;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(
			        new InputStreamReader(new FileInputStream(fileName)));
		} catch (FileNotFoundException e) {
			System.out.println("Soubor nenalezen");
		}
		   		   
		   
		    int count = 1;
		    try {
				while ((line = br.readLine()) != null) {
				    if(count % 2 == 0) {
				    	//souradnice splitovani pomoci zavorek a carek!!
				    	coordinates = parseCoordinate(line);
				    	msgDis = new MessengerDistrict(shortcut, name, nuts4, nuts3, coordinates); 
			    		titles.add(msgDis);
				    } else {
				    	String pom = line.replace(",", ":");
				    	field = pom.split(":");

			    		shortcut = field[1];
			    		name = field[3];
			    		nuts4 = field[5];
			    		nuts3 = field[7];	
				    }
				    count++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	
	} 
	
	/**
	 * Rozdeli radku na jednotliva cisla.
	 * @param line
	 * @return
	 */
	private List<MessengerCoordinates> parseCoordinate(String line){
		String field[];
		String f[];
		String newLine = line.substring(1, line.length()-1);
    	f = newLine.split("\\),\\(");
    	double x, y;
    	List<MessengerCoordinates> coordinates = new ArrayList<MessengerCoordinates>();
    	MessengerCoordinates msg;
    	
    	for(int i = 0; i < f.length-1;i++) {
    		field = f[i].trim().split(",");
    		//sem ulozim x-ovou souradnici
			x = Double.parseDouble(field[0]);
    		//sem ulozim y-ovou souradnici
    		y = Double.parseDouble(field[1]);
    		msg = new MessengerCoordinates(x, y);
    		coordinates.add(msg);
    		
    	}
    	return coordinates;
	}
	
}
