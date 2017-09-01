package FileManagementSystem;

public class CommandParser {
	private int command = Command.NONE;
	private String[] args = null;	//把计
	private int errorCode = 0;
	//岿粇絏0タ絋, -1岿粇, -2把计岿粇
	
	//篶
	public CommandParser(String commandLine) {
		this.setCommand(commandLine);
	}
	
	public int getCommand() {
		return command;
	}
	
	//耞琌猭
	public boolean isValid() {
		if (errorCode != 0)
			return false;
		return true;
	}
	

	/* Command摸Θ跑计
	public static final int NONE = 0;
	public static final int CD = 1;
	public static final int BACK = 2;
	public static final int TOUCH = 3;
	public static final int MKDIR = 4;
	public static final int LS = 5;
	public static final int SEARCH = 6;
	 */
	
	//肚﹃
	public String commandString() {
		String commandString[] = {"none","cd","cd..","touch","mkdir","ls","search"};
		if (command >= 0 && command <= 6)
			return commandString[command];
		else
			return null;
	}
	
	//肚把计
	public String[] getArgs() {
		return args;
	}
	
	private void setCommand(String commandLine) {
		if (commandLine == null)
			return;
		String [] tokens = commandLine.split("\\s+");
		if (tokens.length >0) {
			if (tokens[0].equals("cd") == true) {
				this.command = Command.CD;
				if (tokens.length != 2)
					this.errorCode = -2;	//把计岿粇
			}
			else if (tokens[0].equals("cd..") == true) {
				this.command = Command.BACK;
				if (tokens.length != 1)
					this.errorCode = -2;	//把计岿粇
			}
			else if (tokens[0].equals("touch") == true) {
				this.command = Command.TOUCH;
				if (tokens.length != 2)
					this.errorCode = -2;	//把计岿粇
			}
			else if (tokens[0].equals("mkdir") == true) {
				this.command = Command.MKDIR;
				if (tokens.length != 2)
					this.errorCode = -2;	//把计岿粇
			}
			else if (tokens[0].equals("ls") == true) {
				this.command = Command.LS;
				if (tokens.length != 1)
					this.errorCode = -2;	//把计岿粇
			}
			else if (tokens[0].equals("search") == true) {
				this.command = Command.SEARCH;
				if (tokens.length != 2)
					this.errorCode = -2;	//把计岿粇
			}
			else {
				this.errorCode = -1;		//岿粇
				return;
			}
			
			//狦﹚Τ把计獽args
			if (tokens.length -1 > 0) {
				this.args = new String [tokens.length -1];
				for (int i = 1; i < tokens.length; i++) {
					this.args[i - 1] = tokens[i];
				}
			}
		}			
	}
	
}
