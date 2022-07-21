package fr.uvsq.cprog.collex;

public class WrongCommand implements Command {
    public String execute(String s) {
        System.out.print("Cannot execute command" + s);
        return "\n";
    }
}
