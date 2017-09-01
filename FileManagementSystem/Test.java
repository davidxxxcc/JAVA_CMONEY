package FileManagementSystem;
import java.util.Scanner;
public class Test {
	public static CFileManager fm = new CFileManager();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String dirPath ;
		
		while (true) {
			dirPath = fm.getCurrentDir().getPath();
			System.out.print(dirPath + ">");
			String commandLine = sc.nextLine();
			CommandParser parser = new CommandParser(commandLine);
			if (parser.isValid() == false) {
				System.out.println("«ü¥O¿ù»~! ");
			}
			else if (parser.getCommand() == Command.MKDIR) {
				String itemName = parser.getArgs()[0];
				if (fm.mkdir(itemName) == true) {
					continue;
				}
			}
			else if (parser.getCommand() == Command.CD) {
				String itemName = parser.getArgs()[0];
				if (fm.cd(itemName) == true) {
					continue;
				}
			}
			else if (parser.getCommand() == Command.BACK) {
				if (fm.cdBack() == true) {
					continue;
				}
			}
			else if (parser.getCommand() == Command.LS) {
				System.out.print(fm.curDir.ls());
			}
			else if (parser.getCommand() == Command.SEARCH) {
				String itemName = parser.getArgs()[0];
				String [] findings = fm.search(itemName);
				for (int i = 0; i < findings.length; i++) {
					System.out.print(findings[i] + "\r\n");
				}
				System.out.println("");
				continue;
			}
			else if (parser.getCommand() == Command.TOUCH) {
				String itemName = parser.getArgs()[0];
				if (fm.touch(itemName) == true) {
					continue;
				}
			}
			else {
				System.out.println("«ü¥O" + parser.commandString());
				if (parser.getArgs() != null) {
					for (int i = 0; i < parser.getArgs().length; i++)
						System.out.println(parser.getArgs()[i]);
				}
			}
		}

		
	}

}
