package org.example;

import java.rmi.MarshalledObject;

public class MapConsoleRenderer {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

    public void renderer(){
        for (int i=0; i<=Map.yVertical; i++){
            System.out.print("\n");
            for (int j=0; j<=Map.xHorizontal; j++){
                System.out.print(ANSI_RED_BACKGROUND+"\u2B1B "+ANSI_RESET);
            }


        }
    }




}
