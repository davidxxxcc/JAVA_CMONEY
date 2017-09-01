package TimeTableSystem;

public class CStops {
	
	private String stop;
	private int runs;
	private int departureTime;
	private String [] days = new String [7];
	
	public CStops(String [] info, String [] days) {
		setData(info,days);
	}
	
	public void setData(String [] info, String[] days) {
		
		stop = info[0];
		
//		for(int i = 0; i < days.length; i++) {
//			if (days[i].equals("1"))
//				this.days[i] = true;
//			else
//				this.days[i] = false;
//		}
		
		try {
			runs = Integer.parseInt(info[1]);
		}
		catch(Exception e) {
			runs = 0;
		}
		try {
			departureTime = Integer.parseInt(info[2]);
		}
		catch(Exception e) {
			departureTime = 0;
		}
		
		this.days = days;
	}
	
	
	public String dayToString() {
		String str = "";
		for (int i = 0; i < days.length; i++) {
				if (i < days.length -1)
					str += days[i] + ",";
				else
					str += days[i];
		}
		return str;
	}
	
	@Override public String toString() {
		String str= "";
		str = stop + "," + runs + "," + departureTime + "," + dayToString();
		return str;
	}


}
