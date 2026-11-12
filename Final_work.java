public class  = Final_work.java

 	public static void main(String[] args) {



             //user oprion slection
        int option =  0;

        while (true){

            //name placeholder for user name
            system.out.println("Hello " + "name " );
            option = input(0,3);

            //option menu
            system.out.println("1 workout: 
            2 plan:
            3 calorie tracker: 
            0 exit: ");

            switch (option){
                case 1:
                    workout();
                case 2:
                    plan();
                case 3:
                    calorieTracker();
                case 0:
                    system.out.println("Goodbye");
                    system.exit(0);
            }
        }
        //track workout or create a new one
        public void workout(){
            system.out.println("Workout");
        }
        //tracker for calories
        public void calorieTracker(){
            system.out.println("Calorie Tracker");
        }
        //workout planer
        public void plan(){
            system.out.println("Plan");
        }
        //calorie calculator
        public int calCalc(){

        }
        //check for invalid option input
        public int input (int min, int max){
            try {
                input = input.nextInt();
            } catch (InputMismatchException e){
                system.out.println("Invalid input");
                return -1;
            }
            if (input < min || input > max){
                system.out.println("Invalid input");
                return -1;
            }
            return input;
        }
  
