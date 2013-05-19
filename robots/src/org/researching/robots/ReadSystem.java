package org.researching.robots;
import java.io.IOException;
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
    
    public int nextUnsignedInt() throws IOException{
        int num = in.nextInt();
        if(num < 0){
            throw new IOException();
        }else{
            return num;
        }
    }

    public boolean hasNext() {
        return in.hasNext();
    }
}
