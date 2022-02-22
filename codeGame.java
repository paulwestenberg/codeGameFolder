import java.util.Random;
import java.util.Scanner;

public class codeGame {

    //create random 4 digit number:
    Random rand = new Random();
    int answer = rand.nextInt(10000);

    public int lives=101;

    //how many lives
    public String liveCount(){
        return "You have " + lives + "lives left";
    }

    //guess
    public String guessFunction(int guess){
        lives-=1;
        if (guess==answer){
            return "Congratulations!";
        }
        else{
            return "Incorrect";
        }
    }

    //higher or lower
    public String higherLower(int guess){
        lives-=10;
        if (guess<=answer){
            return "Higher or equal";
        }
        else{
            return "Lower";
        }
    }


    public static void main(String arg[]){

        //System.out.println("Hello World");
        codeGame cG = new codeGame();

        System.out.println("Answer: " + cG.answer);

        Scanner sc = new Scanner(System.in);

        System.out.println("Try to find the 4 digit number!");

        do{

            System.out.println("To know how many lives you have left, enter 0");
            System.out.println("To take a guess, enter 1 XXXX (-1 life)");
            System.out.println("To know higher or lower, enter 2 XXXX (-10 lives)");
            System.out.println("What would you like to do? ");
            String guess = sc.nextLine();

            String[] guessArray = guess.split(" ");

            //convert to get command and value:
            int command=-1;
            int value=-1;
            if (guessArray.length==1){
                command = Integer.parseInt(guessArray[0]);
            }
            else if (guessArray.length==2) {
                command = Integer.parseInt(guessArray[0]);
                value = Integer.parseInt(guessArray[1]);
            }

            if (command == 0){
                System.out.println(cG.liveCount());
            }
            else if (command == 1){
                System.out.println(cG.guessFunction(value));
            }
            else if (command == 2){
                System.out.println(cG.higherLower(value));
            }
        }
        while(cG.lives>0);
    }

}
