package sp2;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;


import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;







/**
 * Trida {@code Platno} slouzi k vytvoreni platna, na ktery kreslime cely vykres. Vykres se pote ulozi do formatu SVG nebo se tiskne.
 * @author Pavla Svitilova
 *
 */
public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	/** Sirka platna. */
	public int width = 800;
	/** Vyska platna. */
	public int height = 800;
	/**Promenna pro pristup k JPanelu.*/
	private JPanel map;
	
	public Window(LoadingFiles load, InputData input){
		this.map = new LoadingMap(load, input);
		this.setTitle("A13B0427P");
		this.setSize(width, height);
		this.getContentPane().setBackground(Color.white);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	//vycentruje okno 
		buttons();
		
	}
	
	/**
	 * Metoda, ktera vytvori platno.
	 * @param args
	 * @param cr
	 * @throws IOException
	 */
	public void start(){
		this.add(map);
		this.setVisible(true);
	}
	
	/**
	 * Metoda, ktera inicializuje tlacitka.
	 */
	private void buttons() {
				JPanel buttonPanel = new JPanel();
				
				JButton toStartButton = new JButton("|<");

				toStartButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//saveSVG(panel);
					}
				});
				
				buttonPanel.add(toStartButton);
				
				
				JButton previousButton = new JButton("<");

				previousButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//saveSVG(panel);
					}
				});
				
				buttonPanel.add(previousButton);
				
				
				JButton nextButton = new JButton(">");

				nextButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//saveSVG(panel);
					}
				});
				
				buttonPanel.add(nextButton);
				
				JButton toEndButton = new JButton(">|");

				toEndButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//saveSVG(panel);
					}
				});
				
				buttonPanel.add(toEndButton);
				
				
				JButton run = new JButton("Run");

				run.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//saveSVG(panel);
					}
				});
				
				buttonPanel.add(run);
				JButton info = new JButton("Dalsi info");

				info.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						//saveSVG(panel);
					}
				});
				
				buttonPanel.add(info);
				
				
				
				
				JButton svgButton = new JButton("Export");

				svgButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					//	saveSVG(panel);
					}
				});
				
					buttonPanel.add(svgButton);

						JButton closeButton = new JButton("Zavrit");
						closeButton.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
							System.exit(1);
						}});
						
						buttonPanel.add(closeButton);


						this.add(buttonPanel, BorderLayout.SOUTH);	
	}
	
	/**
	 * Metoda, ktera ulozi vykres do formatu SVG.
	 * @param jp
	 */
	
	private void saveSVG(JPanel jp) {
	    DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();

	    String svgNS = "http://www.w3.org/2000/svg";
	    Document document = domImpl.createDocument(svgNS, "svg", null);
	    
	    SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
	    
	    jp.paint(svgGenerator);


  		try {
  	        OutputStream outputStream = new FileOutputStream("vykres");
  	        Writer out = new OutputStreamWriter(outputStream, "UTF-8");
  
  			svgGenerator.stream(out, true); 
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
	}

	

 
	


}
