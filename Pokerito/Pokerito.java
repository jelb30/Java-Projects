import java.util.Scanner;

public class Pokerito {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Let's play Pokerito. Type anything when you're ready.");
        scan.nextLine();
        //INSTRUCIONS
        System.out.println("It's like Poker, but a lot simpler.");
        System.out.println("\t1)There are two players, you and the computer.");
        System.out.println("\t2)The dealer will give each player one card.");
        System.out.println("\t3)Then, the dealer will draw five cards (the river)");
        System.out.println("\t4)The player with the most river matches wins!");
        System.out.println("\t5)If the matches are equal, everyone's a winner!");
        System.out.println("\n\tReady? Type anything if you are.");
        scan.nextLine();
        
        //Drawing Random card for USER !
        System.out.println("Click Enter to Draw your card !");
        scan.nextLine();
        System.out.println("\n\n Here's Your Card!");
        int userCard=randomCard(0);

        //Drawing Random card for COMPUTER !
        System.out.println("Click Enter to Draw computers card !");
        scan.nextLine();
        System.out.println("\n\n Here's Computer's Card!");
        int compCard=randomCard(0);

        //Drarwing 5 random cards for USER !
        System.out.println("Now, the dealer will draw five cards for you. Press enter to continue.");
        scan.nextLine();

        int yourMatches = countingCards(userCard,scan);

        //Drarwing 5 random cards for COMPUTER !
        System.out.println("Now, the dealer will draw five cards for computer. Press enter to continue.");
        scan.nextLine();

        int computerMatches = countingCards(compCard,scan);

        System.out.println("Press Enter to chek the results");
        scan.nextLine();

        System.out.println("\nYour Number of Matchess : "+yourMatches);
        System.out.println("Computers Number of Matches : "+computerMatches);
        
        //COMPARING THE COUNTS !
        if(yourMatches>computerMatches){
            System.out.println("You won!");
        }
        else if(yourMatches<computerMatches){
            System.out.println("You Lost, Better Luck Next Time!");
        }
        else{
            System.out.println("Looks Like No one wins it");
        }

         scan.close();
    }

    //FUNCTION THAT DRAWS 5 RANDOM CARD AND CHECKS THE MATCHES OF PLAYERS !
    public static int countingCards(int cardnum, Scanner scan){
        int matches=0;
        //Scanner scan = new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
           double rand1 = Math.random();
           int rand = (int)(rand1*13);
           rand+=1;
           
           System.out.println("Card :" +(i+1));
           int drawcard =randomCard(rand);
           if(drawcard==cardnum){
               matches++;
           }
           
           scan.nextLine();
        }
        //scan.close();
        return matches;
    }

    // FUNCTION THAT PRINTS RANDOM CARDS AND RETURNS ITS VALUES !!
    public static int randomCard(int card){
        if(card==0){
            double card1 = Math.random();
            card = (int)(card1*13);
            card+=1;
        }

        switch(card){
            case 1:
            System.out.println("   _____\n"+
            "  |A _  |\n"+ 
            "  | ( ) |\n"+
            "  |(_'_)|\n"+
            "  |  |  |\n"+
            "  |____V|\n");
            return card;

            case 2:
            System.out.println("   _____\n"+              
            "  |2    |\n"+ 
            "  |  o  |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____Z|\n");
            return card;

            case 3:
            System.out.println("   _____\n" +
            "  |3    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____E|\n");
            return card;

            case 4:
            System.out.println( "   _____\n" +
            "  |4    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  | o o |\n"+
            "  |____h|\n");
            return card;

            case 5:
            System.out.println( "   _____ \n" +
            "  |5    |\n" +
            "  | o o |\n" +
            "  |  o  |\n" +
            "  | o o |\n" +
            "  |____S|\n");
            return card;

            case 6:
            System.out.println("   _____ \n" +
            "  |6    |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  |____6|\n");
            return card;

            case 7:
            System.out.println("   _____ \n" +
            "  |7    |\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |____7|\n");
            return card;

            case 8:
            System.out.println("   _____ \n" +
            "  |8    |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  |____8|\n");
            return card;

            case 9:
            System.out.println("   _____ \n" +
            "  |9    |\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |____9|\n");
            return card;

            case 10:
            System.out.println("   _____ \n" +
            "  |10  o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |___10|\n");
            return card;

            case 11:
            System.out.println("   _____\n" +
            "  |J  ww|\n"+ 
            "  | o {)|\n"+ 
            "  |o o% |\n"+ 
            "  | | % |\n"+ 
            "  |__%%[|\n");
            return card;

            case 12:
            System.out.println("   _____\n" +
            "  |Q  ww|\n"+ 
            "  | o {(|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%O|\n");
            return card;

            case 13:
            System.out.println("   _____\n" +
            "  |K  WW|\n"+ 
            "  | o {)|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%>|\n");
            return card;

        }
        return 0;

    }

}
