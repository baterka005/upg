package sp2;

import java.util.List;

public class DistrictItem {
	
	private MessengerDistrict messengerDistrict;
	private MessengerData messengerData;
	
	public DistrictItem(MessengerDistrict messengerDistrict,
			MessengerData messengerData) {
		
		this.messengerDistrict = messengerDistrict;
		this.messengerData = messengerData;
	}
	
	public int[] getPOP(){
		return this.messengerData.getPopulation();
	}
	
	public int[] getCRM(){
		return this.messengerData.getCrimi();
	}
	
	public int[] getWRK(){
		return this.messengerData.getWork();
	}
	
	public String getName(){
		return messengerDistrict.getName();
	}
	
	public String getShortcut(){
		return messengerDistrict.getShortcut();
	}
	
	public String getNuts3(){
		return messengerDistrict.getNuts3();
	}
	
	public String getNuts4(){
		return messengerDistrict.getNuts4();
	}
	
	public List<MessengerCoordinates> getCoordinates(){
		return messengerDistrict.getCoordinate();
	}

}
