package org.researching.robots;
import java.util.Scanner;

public class ReadSystem{

    private static final Scanner in = new Scanner(System.in);  
    
    private static final ReadSystem readSystem = new ReadSystem();
    
    private ReadSystem(){
        
    }

    public static final ReadSystem getInstance(){
        return readSystem;
    }

    public String nextLine() {
        return in.nextLine();
    }

    public int nextInt() {
        return in.nextInt();
    }
}
