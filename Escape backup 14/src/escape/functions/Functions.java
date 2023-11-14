package escape.functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//for functions to help with our game
public class Functions{
	
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		//string builders let you add to a string
		try{
			BufferedReader buffr = new BufferedReader(new FileReader(path));
			String line;
			while((line = buffr.readLine()) != null)
				builder.append(line + "\n");
			
			buffr.close();
		}catch(IOException d){
			d.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}

}
		