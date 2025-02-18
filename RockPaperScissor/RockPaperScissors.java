import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("\nLet's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");

        String decide = scan.nextLine();
        if(!decide.equals("yes")){
            System.out.println("Darn, some other time...!");
            System.exit(0);
        }
        System.out.println("\nGreat!");
        System.out.println("\nrock... paper... scissors... shoot!");
        String userChoice = scan.nextLine();
        if((!userChoice.equals("rock"))&&(!userChoice.equals("paper"))&&(!userChoice.equals("scissors"))){
            System.out.println("Invalid option exitting the game!");
            System.exit(0);
        }
        
        String computerChoice = compChoice();
        System.out.println("\nYour choice is "+userChoice+" and Computer's choice is "+computerChoice);
        System.out.println(result(userChoice,computerChoice));

        scan.close();
    }

    public static String compChoice(){
        int choiceInt = (int)Math.random()*3;
        switch(choiceInt){
            case 0: return "rock";
            case 1: return "paper";
            case 2: return "scissors";
        }
        return "";
    }

    public static String result(String yourChoice, String computerChoice) {
        String result = "";
        if(yourChoice.equals(computerChoice)){
            result="\nIt's a tie";
        }
        else if((yourChoice.equals("rock") && computerChoice.equals("scissors"))||
        (yourChoice.equals("paper") && computerChoice.equals("rock"))||
        (yourChoice.equals("scissors") && computerChoice.equals("paper")))
        {
            result="\nYou win";
        }
        else{
            result="\nYou lose";
        }

        return result;
      }
}
