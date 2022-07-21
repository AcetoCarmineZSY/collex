package fr.uvsq.cprog.collex;

public class QUIT implements Command{
    public String execute(String s) {
        System.exit(0);
        return "exit";
    }
}
