package org.example;

import java.rmi.MarshalledObject;

public class MapConsoleRenderer {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOXSQUARE = "\u2B1B";
    public static final  String lionEmoji = "\uD83E\uDD81";
    public static final  String deerEmoji = "\uD83E\uDD8C";


    public void renderer(){
        for (int i=0; i<=Map.yVertical; i++){
            System.out.print("\n");
            for (int j=0; j<=Map.xHorizontal; j++){
                System.out.print(ANSI_RED_BACKGROUND+ANSI_BOXSQUARE+ANSI_RESET);
            }
        }
    }







}
