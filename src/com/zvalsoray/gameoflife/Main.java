package com.zvalsoray.gameoflife;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] inmap = {
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        };

        GameLife gmap = new GameLife(inmap);
        gmap.printmap();

        while(true)
        {
            gmap.printmap();
            System.out.println("For stop press 'q', to continue any other character, then press enter.");
            String qcom = scanner.next();
            if (qcom.charAt(0) == 'q')
            {
                break;
            }
            gmap.nextMapGen();
        }
    }
}