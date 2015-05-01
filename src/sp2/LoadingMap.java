package sp2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

import javax.swing.JPanel;

public class LoadingMap extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Districts district;

	public LoadingMap(LoadingFiles load, InputData input) {
		this.district = new Districts(load.getDistrict());
		
//		System.out.println(district.districts.get(0).getName());
//		System.out.println(Arrays.toString(district.districts.get(0).getPOP()));
//		System.out.println(Arrays.toString(district.districts.get(0).getWRK()));
//		System.out.println(Arrays.toString(district.districts.get(0).getCRM()));
	}
	
	public void paint(Graphics g){
//		resizeWindow();		
		paint2D((Graphics2D)g);
	
	}
	
	private void paint2D(Graphics2D g2) {
		g2.drawRect(0, 0, this.getWidth(), 100);
	}

	
}
