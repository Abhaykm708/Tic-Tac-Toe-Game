import java.util.Scanner;

public class Tictoctoe {
    private static char[][] mat=new char[3][3];
    private static char currentPlayer='X';
    private static boolean gameOver=false;

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        initializeBoard();

        while (!gameOver) {
            printBoard();
            playerTurn(scanner);
            checkGameStatus();
            switchPlayer();
        }
    }

    private static void initializeBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j]=' ';
            }
        }
    }
    private static void printBoard(){
        System.out.println("current board");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[i][j]);
                if (j<2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i<2) {
                System.out.println("-------");
            }
        }
    }

    private static void playerTurn(Scanner scanner){
        int row,colomn;
        boolean validmove=false;

        while (!validmove) {
            System.out.println("Player " +currentPlayer+" enter yur move(row and colomn)");
            row=scanner.nextInt()-1;
            colomn=scanner.nextInt()-1;

            if (row>=0 && row<3 && colomn>=0 && colomn<3 && mat[row][colomn]==' ') {
                mat[row][colomn]=currentPlayer;
                validmove=true;
            }else {
                System.out.println("Invalid move! Please enter valid move");
                
            }
        }
    }
    private static void checkGameStatus(){
        if (checkwin()) {
            printBoard();
            System.out.println("Player "+currentPlayer+" Win!..");
            gameOver=true;
        }else if (checkDraw()) {
            printBoard();
            System.out.println("Game Draw!..");
            gameOver=true;
        }
    }

    private static boolean checkwin(){
        for (int i = 0; i < 3; i++) {
            if (mat[i][0]==currentPlayer && mat[i][1]==currentPlayer && mat[i][2]==currentPlayer ) {
                return true;
            }
            if (mat[0][i]==currentPlayer && mat[1][i]==currentPlayer && mat[2][i]==currentPlayer) {
                return true;
            }
        }
        if (mat[0][0]==currentPlayer && mat[1][1]==currentPlayer && mat[2][2]==currentPlayer) {
            return true;
        }
        if (mat[0][2]==currentPlayer && mat[1][1]==currentPlayer && mat[2][0]==currentPlayer) {
            return true;
        }
        return false;
    }

    private static boolean checkDraw(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[i][j]==' ') {
                    return false;
                }
            }
        }
        return true;
    }
     private static void switchPlayer(){
        currentPlayer=(currentPlayer=='X')?'O':'X';
     }
}
