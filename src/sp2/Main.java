package sp2;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		InputData input = new InputData();
		input.checkCountParameters(args);
		input.setMode(args[0]);
		input.setYear(args[1]);
		input.setNameFileExport(args[2]);

		LoadingFiles files = new LoadingFiles();
		files.loadFiles();
		
		Window app = new Window(files, input);
	//	app.start();
		
	}
	
	
	
}
