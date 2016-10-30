import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class stockConnection {

		private String URL = "";
		private InputStreamReader inStream;

	/**
	 * connects to the stock related website to be parsed.
	 * @throws IOException
	 */
	public stockConnection(String URL){
		this.URL = URL;
	}
	
	public String readLiner() throws IOException{
		URL url = new URL("https://www.google.com/finance?q=onvo&ei=CrYSWMDYIcbIecjDo-AF");
		URLConnection urlConn = url.openConnection();
		InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
		BufferedReader buff = new BufferedReader(inStream);
		
		String lineBuff = "not found";
		String line = buff.readLine();
		while(line != null){
			if(line.contains("[\"ONVO\",")){
				int target = line.indexOf("[\"ONVO\",");
				int end = line.indexOf("]", target);
				int start = target;
			
				lineBuff = line.substring(start, end+1);
			}
			line = buff.readLine();
		}
		return lineBuff;
	}	
	
	public void setURL (String URL){
		this.URL = URL;
	}
	
	public String getURL() {
		return this.URL;
	}
}
