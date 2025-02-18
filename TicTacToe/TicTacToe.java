import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            char[][] board = new char[3][3];
            for(int i=0; i<board.length; i++){
              for(int j=0; j<board[i].length; j++){
                board[i][j]='_';
              }
            }

            printBoard(board);

            int count = 0;
            int i=0;
            while(i<9){
              if(i%2==0){
                System.out.println("Turn: X");
                int[] index = getIndexes(board);
                board[index[0]][index[1]]='X';
                printBoard(board);
              }
              else{
                System.out.println("Turn: O");
                int[] index = getIndexes(board);
                board[index[0]][index[1]]='O';
                printBoard(board);
              }
              i++;
              if(i>3){
                count=checkWin(board);
                if(count==3){
                    System.out.println("------------- X Wins -----------------");
                    break;
                }
                else if(count==-3){
                    System.out.println("------------- O Wins -----------------");
                    break;
                }
              }  
            }

            scan.close();
        }

        public static int checkWin(char[][] board) {
        
          //Check each of 3 rows
          int count = 0;
  
          for (int i = 0; i < board.length; i++) {
              for (int j = 0; j < board[i].length; j++) {
                  if (board[i][j] == 'X') {
                      count++; //count each X as +1
                  } else if (board[i][j] == 'O') { 
                      count--; //count each O as -1. 
                  }
              }
              if (count == 3 || count == -3) {
                  return count;
              } else {
                  count = 0;
              }
  
          }
  
          for (int i = 0; i < 3; i++) {
              for (int j = 0; j < 3; j++) {
  
                  if (board[j][i] == 'X') {
                      count++; //count each X as +1
                  } else if (board[j][i] == 'O') { 
                      count--; //count each O as -1. 
                  }
              }
              if (count == 3 || count == -3) {
                  return count;
              } else {
                  count = 0;
              }
          }
  
          for (int i = 0; i < 3; i++) {
              if (board[i][i] == 'X') {
                  count++; //count each X as +1
              } else if (board[i][i] == 'O') { 
                  count--; //count each O as -1. 
              }
          }
  
          if (count == 3 || count == -3) {
              return count;
          } else {
              count = 0;
          }
  
          for (int i = 0; i < 3; i++) {
              if (board[i][2-i] == 'X') {
                  count++; //count each X as +1
              } else if (board[i][2-i] == 'O') { 
                  count--; //count each O as -1. 
              }
          }
  
          return count;
      }

      public static int[] getIndexes(char[][] board){

          System.out.println("-->Pick a row and column number ArrayWise: ");
          int row = scan.nextInt();
          int col = scan.nextInt();
          
          while(board[row][col]!='_'|| row>2 || col>2){
            System.out.println("Enter Valid Position");
            row = scan.nextInt();
            col = scan.nextInt();
          }
          return new int[] {row,col};
      }


        public static void printBoard(char[][] board){
          for(int i=0; i<board.length; i++){

            System.out.print("\n\t");
            for(int j=0; j<board[i].length; j++){

              System.out.print(board[i][j]+" ");
            }
            System.out.println("");
          }
        }
}
