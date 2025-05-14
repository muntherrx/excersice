import java.util.Scanner;
public class MiniShell {
    public static void main(String[] args) {
        
                ShellCommandHandler manager = new ShellCommandHandler();

                Scanner scan = new Scanner(System.in);
                String comand;
                System.out.println("welcome to MiniShell, type 'help' for commands ");

                for(int i=1;i>0;i++){
                    System.out.print(manager.getCurrentDirectory().getAbsolutePath() + " > ");
                    comand = scan.nextLine();
                    String trimmed = comand.trim();
                    String[] parts = trimmed.split("\\s+", 2);
                    String command = parts[0];
                    String argument = "";
                    if (parts.length > 1) {
                        argument = parts[1];
                    }

                    switch (command) {
                        case "pwd":
                            manager.printWorkingDirectory();
                            break;
                        case "ls":
                            manager.listDirectory();
                            break;
                        case "cd":
                            manager.changeDirectory(argument);
                            break;
                        case "mkdir":
                            manager.makeDirectory(argument);
                            break;
                        case "touch":
                            manager.createFile(argument);
                            break;
                        case "help":
                            manager.printHelp();
                            break;
                        case "exit":
                            System.out.println("Exiting MiniShell.");
                            scan.close();
                            return;
                        default:
                            System.out.println("Unknown command, Type 'help' to see available commands.");
                    }
                }
            }
        }



