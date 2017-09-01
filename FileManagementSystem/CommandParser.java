package FileManagementSystem;

public class CommandParser {
	private int command = Command.NONE;
	private String[] args = null;	//�Ѽ�
	private int errorCode = 0;
	//���~�N�X�G0�N���T, -1�N����O���~, -2�N��Ѽƿ��~
	
	//�غc�l
	public CommandParser(String commandLine) {
		this.setCommand(commandLine);
	}
	
	public int getCommand() {
		return command;
	}
	
	//�P�_���O�O�_���X�k
	public boolean isValid() {
		if (errorCode != 0)
			return false;
		return true;
	}
	

	/* �bCommand���O�ŧi�������ܼ�
	public static final int NONE = 0;
	public static final int CD = 1;
	public static final int BACK = 2;
	public static final int TOUCH = 3;
	public static final int MKDIR = 4;
	public static final int LS = 5;
	public static final int SEARCH = 6;
	 */
	
	//�^�ǫ��O�N���r��
	public String commandString() {
		String commandString[] = {"none","cd","cd..","touch","mkdir","ls","search"};
		if (command >= 0 && command <= 6)
			return commandString[command];
		else
			return null;
	}
	
	//�^�ǰѼ�
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
					this.errorCode = -2;	//�Ѽƿ��~
			}
			else if (tokens[0].equals("cd..") == true) {
				this.command = Command.BACK;
				if (tokens.length != 1)
					this.errorCode = -2;	//�Ѽƿ��~
			}
			else if (tokens[0].equals("touch") == true) {
				this.command = Command.TOUCH;
				if (tokens.length != 2)
					this.errorCode = -2;	//�Ѽƿ��~
			}
			else if (tokens[0].equals("mkdir") == true) {
				this.command = Command.MKDIR;
				if (tokens.length != 2)
					this.errorCode = -2;	//�Ѽƿ��~
			}
			else if (tokens[0].equals("ls") == true) {
				this.command = Command.LS;
				if (tokens.length != 1)
					this.errorCode = -2;	//�Ѽƿ��~
			}
			else if (tokens[0].equals("search") == true) {
				this.command = Command.SEARCH;
				if (tokens.length != 2)
					this.errorCode = -2;	//�Ѽƿ��~
			}
			else {
				this.errorCode = -1;		//���O���~
				return;
			}
			
			//�p�G���w���ѼƫK�[�Jargs
			if (tokens.length -1 > 0) {
				this.args = new String [tokens.length -1];
				for (int i = 1; i < tokens.length; i++) {
					this.args[i - 1] = tokens[i];
				}
			}
		}			
	}
	
}
