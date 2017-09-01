package TimeTableSystem;

import java.util.Arrays;

public class CItem {
	
	private String company;
	private String mainLine;
	private String subLine;
	private String ticketType;
	private String lineName;
	private String [] info;
	private CStops [] stop;
	private int itemCount;
	
	
	public CItem (String [] info) {
		setData(info);
		stop = new CStops[50];
		this.info = info;
		itemCount = 0;
	}
	
	public void setData(String [] info) {
		company = info[0];
		mainLine = info[1];
		subLine = info[2];
		ticketType = info[3];
		lineName = info[4];
	}
	
	public String[] getInfo() {
		return info;
	}
	
	public int getItemCount() {
		return itemCount;
	}
	public String[] getMainLineSubLine() {
		String [] str = {mainLine,subLine};
		return str;
	}
	
	public String getMainLine() {
		return mainLine;
	}
	public String getSubLine() {
		return subLine;
	}
	
	public CStops getStop (int i) {
		return stop[i];
	}
	
	public void addStop(String[] info2, String [] days) {
		if (itemCount >= stop.length) {
			stop = Arrays.copyOf(stop, stop.length * 2);
		}
		stop[itemCount++] = new CStops(info2, days);
	}

	
	@Override public String toString() {
		String str= "";
		str = company + "," + mainLine + "," + subLine + "," + ticketType + "," + lineName;
		return str;
	}
	
}
