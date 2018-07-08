/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchcard;

import java.util.Scanner;

/**
 *
 * @author zhuang001
 */
public class ScratchCard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()) {
            processOneStencil(sc);
        }
    }

    private static void processOneStencil(Scanner sc) {
        int h=sc.nextInt();
        int w=sc.nextInt();
        sc.nextLine();
        char[][] grid=new char[h][w];
        for (int i=0;i<h;i++) {
            String line=sc.nextLine();
            for (int j=0;j<w;j++) {
                grid[i][j]=line.charAt(j);
            }
        }
        String phrase=sc.nextLine();
        generateStencil(grid,phrase);
        for (int i=0;i<h;i++) {
            for (int j=0;j<w;j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private static void generateStencil(char[][] grid, String phrase) {
        int cIdx=0;
        for (int i=0;i<grid.length;i++) {
            char[] row=grid[i];
            for (int j=0;j<row.length;j++) {
                if (row[j]==phrase.charAt(cIdx)) {
                    row[j]='.';
                    cIdx++;
                    if (cIdx>=phrase.length())
                        return;
                } else {
                    row[j]='#';
                }
            }
        }
        if (cIdx<phrase.length()) {
            for (int i=0;i<grid.length;i++) {
                char[] row=grid[i];
                for (int j=0;j<row.length;j++) {
                    row[j]='x';
                }
            }
        }
    }
    
}
