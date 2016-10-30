import java.io.IOException;

public class stockParser {
	
	private String stockSticker;
	private String stockPrice;
	private String stockName;
	private String stockValues;

	public stockParser(String line, String stockSticer){
		this.stockSticker = stockSticer;
		
		
		while(line != null){
			//System.out.println(line);
			String regex = "\"" + stockSticer + "\",";			
			if(line.contains(regex)){
				int start = line.indexOf(regex);
				int end = line.indexOf("]");
				
				String newLine = line.substring(start, end);
				this.stockValues = newLine;
				break;
			}else {
				System.out.println("Error: could not find " + stockSticker + " Information");
				break;
			}
		}
	}
	
	/**
	 * parser grabs a long string and finds a specific price using a regex shown. Then returns the price.
	 * This indexOf is on the assumption that the website's DOM has not changed.
	 * @param line: the buffered string from the connected webstie
	 * @param price: the price that is extracted from line
	 * @return price: the price of the stock ticker
	 * @throws IOException
	 */
	public String parsePrice() throws IOException{
		String price = "10";
		String line = this.stockValues;
		
		
		//to see the stream
		//System.out.println(line);				
		int target = line.indexOf("\"" + stockSticker + "\",");
		int deci = line.indexOf(".", target);
		int start = deci;
				
		while(line.charAt(start) != '\"'){
			start--;
		}
			
		price = line.substring(start + 1, deci + 3);
		this.stockPrice = price;
		return price;
	}
	
	public String parseName() throws IOException{
		String name = " ";
		String line = this.stockValues;
		//System.out.println(line);
								
		int target = line.indexOf("\"" + stockSticker + "\",");
		//System.out.println(target);
		int comma = line.indexOf(",", target);
		//System.out.println(comma);
		int end = comma;
		end += 2;
				
		while(line.charAt(end) != '\"'){
					end++;
		}
				
		name = line.substring(comma + 2, end);		
		this.stockName = name;
		return this.stockName;
	}
	
	public void setstockSticker(String stockSticker) {
		this.stockSticker = stockSticker;
	}
	
	public String getstockSticker(){
		return this.stockSticker;
	}
	
	public void setstockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	public String getstockPrice(){
		return this.stockPrice;
	}
	
}
