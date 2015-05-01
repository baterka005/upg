package sp2;

import java.util.List;

public class MessengerDistrict {
	
	
	private String shortcut;
	private String name;
	private String nuts4;
	private String nuts3;
	private List<MessengerCoordinates> coordinate;
	
    
    public MessengerDistrict(String shortcut, String name, String nuts4, String nuts3, List<MessengerCoordinates> coordinate){
        this.shortcut = shortcut;
        this.name = name;
        this.nuts4 = nuts4;
        this.nuts3 = nuts3;
        this.coordinate = coordinate;
    }

	public String getShortcut() {
		return shortcut;
	}

	public String getName() {
		return name;
	}

	public String getNuts4() {
		return nuts4;
	}

	public String getNuts3() {
		return nuts3;
	}

	public List<MessengerCoordinates> getCoordinate() {
		return this.coordinate;
	}
    
    
}

