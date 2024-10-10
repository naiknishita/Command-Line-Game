/*
 * Author: Nishita Naik
 * Roll No: 28
 * Title: TicTacToe Game
 * Startdate: 05/08/2025
 * Description: Its is a game of two player, each player gets cahnge to play alternately.
 * Players are assigned characyter X and O.
 * Player have to place its charater when its their turn in a 3*3 matrics.
 * The player has to put row and column number.
 * To win the game the has to place its character in 3 consecutive position it can horizintal, vertival and diagonal in the matrics.
 * 
 */



import java.util.Scanner;

public class TicTacToe 
{

    private static char[][] Board = new char[3][3];
    private static char currentPlayer;

    public static void main(String[] args) 
    {

        setPlayer();

        setupBoard();
        displayBoard();

        while (true) 
        {
            playerMove();
            displayBoard();
            if (checkWin()) 
            {
                System.out.println("Congratulations...! Player " + currentPlayer + " has won the game!");
                
                break;
            }
            if (isBoardFull()) 
            {
                System.out.println("It's a draw!");
                System.out.println("Better luck next time.");
                break;
            }
            changePlayer();
        }
    }

    private static void setPlayer() 
    {
        Scanner c = new Scanner(System.in);
        System.out.print("Player 1 , select your choice (X or O):");
        String ch = c.nextLine();
        if(ch.equals("X"))
        {
            currentPlayer='X';
        }
        else if(ch.equals("O"))
        {
            currentPlayer='O';
        }
        else
        {
            System.out.println("Please enter valid choice.");
            setPlayer();
        }
    }

    private static void setupBoard() 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                Board[i][j] = '-';
            }
        }
    }

    private static void displayBoard() 
    {
        System.out.println("Current Board :");
        System.out.println("    1   2   3");
        for (int i = 0; i < 3; i++) 
        {
            System.out.print(i+1);
            for (int j = 0; j < 3; j++) 
            {
                System.out.print(" | " + Board[i][j] );
            }
            System.out.print(" |");
            System.out.println();
        }
    }

    private static void playerMove() 
    {
        Scanner pos = new Scanner(System.in);
        int row, col;

        while (true) 
        {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = pos.nextInt() - 1;
            col = pos.nextInt() - 1;

            if (!isValid(row, col)) 
            {
                System.out.println("Invalid move, try again.");
            } 
            else 
            {
                if(isEmpty(row, col))
                {
                    Board[row][col] = currentPlayer;
                    break;
                }
                else
                {
                    System.out.println("This position is already filled. Try another position.");
                    //changePlayer();
                    
                }  
            }
        }
    }

    private static boolean isEmpty(int row, int col) {
        return Board[row][col] == '-';
    }

    private static boolean isValid(int row, int col) 
    {
        return row >= 0 && row < 3 && col >= 0 && col < 3 ;
    }

    private static void changePlayer() 
    {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWin() 
    {
        return ( checkRows() || checkDiagonals() || checkColumns() );
    }

    private static boolean checkDiagonals() {
        if ( Board[0][0] == currentPlayer && Board[1][1] == currentPlayer && Board[2][2] == currentPlayer ) 
        {
            return true;
        }
        if ( Board[0][2] == currentPlayer && Board[1][1] == currentPlayer && Board[2][0] == currentPlayer ) 
        {
            return true;
        }
        return false;
    }

    private static boolean checkRows() 
    {
        for (int i = 0; i < 3; i++) 
        {
            if ( Board[i][0] == currentPlayer && Board[i][1] == currentPlayer && Board[i][2] == currentPlayer ) 
            {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) 
        {
            if ( Board[0][i] == currentPlayer && Board[1][i] == currentPlayer && Board[2][i] == currentPlayer ) 
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isBoardFull() 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (Board[i][j] == '-') 
                {
                    return false;
                }
            }
        }
        return true;
    }
}
