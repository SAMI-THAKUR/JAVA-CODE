package GAME;

import java.util.Scanner;

public class tic_tac_toe {
    public static boolean havewon(char[][]b , char play)
    {
           for(int row=0 ; row<b.length ; row++)
           {
               if(b[row][0] == play && b[row][1]==play && b[row][2]==play)
               {
                   return true ;
               }
           }

        for(int col=0 ; col<b.length ; col++)
        {
            if(b[0][col] == play && b[1][col]==play && b[2][col]==play)
            {
                return true ;
            }
        }


            if (b[0][0]== play && b[1][1]==play && b[2][2]==play)
            {
                return true ;
            }

            if ( b[0][2] ==play && b[1][1]==play && b[2][0]==play)
            {
                return true ;
            }
            return false ;
    }
    public static void print(char[][] b)
    {
        for(int row=0 ; row<b.length ; row++)
        {
            for (int col=0 ; col<b[row].length ; col ++)
            {
                System.out.print(b[row][col] + " | ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        char board [][] = new char[3][3];
        for(int row=0 ; row<board.length ; row++)
        {
            for (int col=0 ; col<board[row].length ; col ++)
            {
                board[row][col]= ' ';
            }
        }

        char player = 'X';
        boolean gameocver = false ;
        while (!gameocver)
        {
            print(board);
            System.out.println("player " + player + " enter : ");
            System.out.println("ENTER ROW");
            int row = sc.nextInt();
            System.out.println("ENTER COLUMN");
            int col = sc.nextInt();
            if (board[row][col]==' ')
            {
                board[row][col] = player ;
                gameocver = havewon(board , player);
                if(gameocver){
                    System.out.println("player " + player + " won");
                }
                else {
                    if (player == 'X')
                    {
                        player = 'O';
                    }
                    else {
                        player = 'X';
                    }
                }
            }
            else {
                System.out.println("INVALID MOVE");
            }
        }
        print(board);

    }
}
