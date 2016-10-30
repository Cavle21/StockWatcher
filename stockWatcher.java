import java.io.IOException;

public class stockWatcher {

	/**
	 * StockWatcher pulls DOM information from stock ticker website,
	 * parses it, then shows price of stock.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		String line = null, price = "not found", name = "";
				
		
		stockConnection connection = new stockConnection(
				"https://www.google.com/finance?q=onvo&ei=CrYSWMDYIcbIecjDo-AF");	
		
		line = connection.readLiner();
		stockParser parser = new stockParser(line, "ONVO");	
		price = parser.parsePrice();
		name = parser.parseName();
		
		System.out.println(parser.getstockSticker() + ", " + name + ", " + price);
	}
}

