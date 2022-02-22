import java.util.Random;
import java.util.Scanner;

public class codeGame {

    //create random 4 digit number:
    Random rand = new Random();
    int answer = rand.nextInt(10000);

    public int lives=101;

    //how many lives
    public String liveCount(){
        return "You have " + lives + " lives left";
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

    //right digit
    public String correctDigit(int guess){
        lives-=12;
        String temp = Integer.toString(guess);
        String temp2 = Integer.toString(answer);
        String output = "";
        int[] guessArray = new int[temp.length()];
        int[] answerArray = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            guessArray[i] = temp.charAt(i) - '0';
            answerArray[i] = temp2.charAt(i) - '0';
        }

        for (int i = 0; i < temp.length(); i++){
            if (guessArray[i] == answerArray[i]){
                output += "G";
            }
            else{
                output += "B";
            }
        }
        return output;
    }

    public static void main(String arg[]){

        //System.out.println("Hello World");
        codeGame cG = new codeGame();

        //System.out.println("Answer: " + cG.answer);

        Scanner sc = new Scanner(System.in);

        System.out.println("Try to find the 4 digit number!");

        do{

            System.out.println("To know lives, enter 0");
            System.out.println("To guess, enter 1 XXXX (-1 life)");
            System.out.println("Higher or lower, enter 2 XXXX (-10 lives)");
            System.out.println("Correct digits, enter 3 XXXX (-12 lives)");
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
            else if (command == 3){
                System.out.println(cG.correctDigit(value));
            }
        }
        while(cG.lives>0);
    }

}
