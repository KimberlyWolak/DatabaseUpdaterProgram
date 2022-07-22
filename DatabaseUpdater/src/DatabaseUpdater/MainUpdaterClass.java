package DatabaseUpdater;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class MainUpdaterClass {

	public static void main(String[] args) {	
		HashMap<String,String> updateDBListMap = new HashMap<>();
		HashMap<String,JSONObject>  actualDBList =  new HashMap<>();
		JSONArray updateDBList = new JSONArray();		
		try {
			actualDBList = JsonUtil.readJsonFile();
			updateDBListMap = JsonUtil.extractJsonFileInfo();
			updateDBList = JsonUtil.updateAndCreateJsonObject(updateDBListMap,actualDBList);
			JsonUtil.writeJsonFile(updateDBList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}	
}
