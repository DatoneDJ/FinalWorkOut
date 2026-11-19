import java.util.Scanner;
import java.util.vector;
import java.util.InputMismatchException;
import java.time.LocalDate;

public class  Final_work{


 	public static void main(String[] args) {

        System.out.println("enter user name: ");

        System.out.println("enter password: ");

        //user oprion slection
        int option =  0;

        while (true){

            //name placeholder for user name
            System.out.println("Hello " + "name " );

            //option menu
            System.out.println("1 workout: \n" +
            "2 plan: \n" +
            "3 calorie tracker: \n" +
            "0 exit: ");

            option = input(0,3);

            switch (option){
                case 1:
                    workout();
                    break;
                case 2:
                    plan();
                    break;
                case 3:
                    calorieTracker();   
                    break;
                case 0:
                    System.out.println("Goodbye");
                    System.exit(0);
            }
        }
    }
        //track workout or create a new one
        public static int workout(){
            System.out.println("Workout");
            switch (input(0,2)){
                case 1:
                    System.out.println("Track workout");
                    break;
                case 2:
                    System.out.println("Create new workout");
                    break;
                case 0:
                    System.out.println("Back");
                    return (0);
            }
        }
    
        //tracker for calories
        public static double calorieTracker(){
            double calTotal = 0;
            double dailyCal = 0;
            Vector<String> meals = new Vector<String>(); 
            Vector<Double> mealCalories = new Vector<Double>(); 
            while (true){
            System.out.println("Calorie Tracker");
            System.out.println("todays meals: " + meals.size());
            System.out.println("calories consumed: " + calTotal + " / " + dailyCal + " daily calories");   
            switch (input(0,2)){
                case 1:
                    System.out.println("Track calories");
                    
                    dailyCal += calCalc();
                    System.out.println("you need " + dailyCal + " daily calories");
                    break;
                case 2:
                    System.out.println("enter a new meal");
                    meals.add(inputString());
                    mealCalories.add(calCalc());
                    break;
                case 0:
                    System.out.println("Back");
                    return (0);
            }
        }
        }
        //workout planer
        public static void plan(){
            System.out.println("Plan");
        }
        //calorie calculator
        public static double calCalc(){
             double weight;
             double height;
                int age;
            
            //weight unit option selection
            switch (input(0,2)){
                case 1:
                    System.out.println("enter weight in kg: ");
                    weight = inputDouble();
                    break;
                case 2:
                    System.out.println("enter weight in lb: ");
                    weight = inputDouble();
                    break;

                case 0:
                    System.out.println("Back");
                    return (0);
            }
                    //height unit option selection
                    switch (input(0,2)){
                         
                        case 1:
                            System.out.println("enter height in cm: ");
                            height = inputDouble();
                            break;
                        case 2:
                            System.out.println("enter height in ft: ");
                            height = inputDouble();
                            break;
                        case 0:
                            System.out.println("Back");
                            return (0);
                    }

                    switch (input(0,120)){
                        case 1:
                            System.out.println("enter age: ");
                            age = input();
                            break;
                        case 0:
                            System.out.println("Back");
                            return (0);
                    }
                    //gender selection
                    switch (input(0,2)){
                        case 1:
                            System.out.println("man: ");
                            return = (10 * weight) + (6.25 * height) - (5 * age) + 5;
                            
                            
                        case 2:
                            System.out.println("woman: ");
                            return = (10 * weight) + (6.25 * height) - (5 * age) - 161;
                        case 0:
                            System.out.println("Back");
                            return (0);
                    }

            }

        //check for invalid option input
        public static int input (int min, int max){
          int input;
          while (true){
            System.out.println("Enter a number: ");
           try {
                input = System.in.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Invalid input");
            
            }
            if (input < min || input > max){
                System.out.println("Invalid input plaease enter a number between " + min + " and " + max);
            }
            else {
                break;
          }
            return input;
        }
        public static double inputDouble (){
            double input;
            while (true){
                System.out.println("Enter a number: ");
           try {
                input = System.in.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("Invalid input");
                
            }
            }
           
            return input;
        }
  
  }
}

