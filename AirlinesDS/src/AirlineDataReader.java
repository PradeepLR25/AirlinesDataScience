import java.util.HashMap;
import java.io.File;
import java.util.*;

public class AirlineDataReader {
	
	public String filename = new String();
	private HashMap<String, ArrayList<String>> AirlineData = new HashMap<String, ArrayList<String>>();
	
	//constructor
	public AirlineDataReader(String filename) {
	this.filename = filename;
	this.AirlineData = getData(filename);
		
	}
	
	public HashMap<String, ArrayList<String>> getAirlineData(){
		return AirlineData;
	}
	
	//reads in data into a Hashmap that uses the header from the file as key,
	//and stores the value as the corresponding column as an arraylist
	private HashMap<String, ArrayList<String>> getData(String filname) {
		File datafile = new File(filename);
		HashMap<String, ArrayList<String>> dataString = new HashMap<String, ArrayList<String>>();
		ArrayList<ArrayList<String>> columnDataString = new ArrayList<ArrayList<String>>();
		
		try {
			Scanner scanData = new Scanner(datafile);
			//stores headers as keys in an arraylist, to be used later
			String[] headerKey = scanData.nextLine().split(",");
			for (String header : headerKey) {
				columnDataString.add(new ArrayList<String>());
			}
			int count = 0;
			//stores each column in their own ArrayList
			while(scanData.hasNextLine()) {
				String[] rowData =  scanData.nextLine().split(",");
				for(int i =0; i<rowData.length; i++) {
					ArrayList<String> subList = columnDataString.get(i);
					subList.add(rowData[i]);
					}
			}
			//creates the HashMap from the arrayList of headerkeys, and the
			//arraylist of arraylists.
			for(int j = 0; j<headerKey.length; j++) {
				dataString.put(headerKey[j], columnDataString.get(j));
			}
			scanData.close();
		} catch(Exception error){
			System.out.println(error);	
		}
		return dataString;
	}
	
	

	
	
	
	
	
}
