import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //declare basic variable
        Random Rand = new Random();

        //for the end of program when user wants to reset the program
        boolean Reset_Input = true;

        //Set scanner(user input function) as sc and get it ready
        Scanner sc = new Scanner(System.in);


        //loop it in a do-while so a reset is possible
        do {
            //reset the "reset Input" to false;
            Reset_Input = false;

            //declare variables but there special cause there in a loop
            int Rolls = 0;
            int Sides = 0;
            Boolean ValidInput = false;

            //start the actual thingy, thing
            System.out.println("-----------------------Welcome To The Dice Roller-----------------------");

            //The error handling Block and main code
            while (!ValidInput) {

                //first, try to run this code, if valid, the boolean will be true and move on
                try {

                    //check for user input, Declare variable of that input, convert input into a integer(number) and change the var Rolls to it
                    System.out.println("input number of rolls: ");
                    Rolls = sc.nextInt();

                    //use same method for getting the sides as the rolls
                    System.out.println("input number of Sides For the die: ");
                    Sides = sc.nextInt();

                    //make sure input can never be zero
                    if ((Rolls > 0) && (Sides > 0)) {
                        ValidInput = true;
                    } else {
                        System.out.println("Error - must be Greater than 0");
                        sc.nextLine();
                    }
                }

                //this is for when its invalid, stopping everything and redoing the try block
                catch (Exception e) {

                    System.out.println("Resetting... Enter a valid number: ");
                    sc.nextLine();

                }
            }

            //after getting user input, make an array
            int[] Results = new int[Rolls];

            //the script to actually calculate what to generate
            for (int _i = 0; _i < Rolls; _i++) {

                //randomize the input so the max is user's choice
                int new_side = Rand.nextInt(Sides) + 1;
                //store each random number into an array
                Results[_i] = new_side;
                System.out.println("die " + (_i + 1) + ": " + new_side);

            }

            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Results: " + Arrays.toString(Results));
            System.out.println("-----------------------------------------------------------------------------------");

            //end code or restart the code(in progress)
            System.out.println("Redo? yes or no?: ");
            sc.nextLine();
            String Answer = sc.nextLine();

            try {

                //what checks if the user says 'yes', 'no', or it reached an error
                if (Answer.equalsIgnoreCase("yes")) {

                    Reset_Input = true;
                    System.out.println("Resetting...");

                } else if (Answer.equalsIgnoreCase("no")) {

                    //closes the entire program
                    sc.close();
                    System.out.println("-----------------------Thanks for Rolling-----------------------");

                }
            } catch (Exception e) {
                System.out.println("Error - Please put 'yes' or 'no'");
                sc.nextLine();
            }
        }
        //THIS FUCKING WHILE LOOP WONT WORK FUCKKK. WORK!! WHY ARENT YOU WORKING
        while (Reset_Input);
    }
}