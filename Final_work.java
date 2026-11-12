public class  = Final_work.java

 	public static void main(String[] args) {



        int option =  0;

       
        int option =  0;

        while (true){
            system.out.println("Hello " + "name " );
            option = input.nextInt();

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
                    break;
            }
        }
        public void workout(){
            system.out.println("Workout");
        }
        public void calorieTracker(){
            system.out.println("Calorie Tracker");
        }
        public void plan(){
            system.out.println("Plan");
  
        }
