package fr.uvsq.cprog.collex;
import java.io.*;

public interface Command {
    public String execute(String s) throws IOException;
}
