import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;

public class User {
    private String username;
    private Vector<Workout> customWorkouts = new Vector<>();
    private Vector<Vector<Workout>> weekPlan = new Vector<>();
    private Vector<Vector<Object>> records = new Vector<>();
    private Workout[] workoutRecords;
    
    //------------------Constructors------------------
    
    public User() {
        username = "Placeholder";
    }
    
    public User(String username){
        this.username = username;
    }
    
    //------------------Setters------------------
    public void setUsername(String username){
        this.username = username;
    }
    
    //------------------Getters------------------
    public String getUsername(){
        return username;
    }
    
    public Workout getCustomWorkout(int index){
        return customWorkouts.get(index);
    }
    
    public Vector<Workout> getWeekPlan(int index){
        return weekPlan.get(index); // Note that it returns a vector of workouts, specifically the index of the day
    }
    
    //------------------Methods------------------
    public void addWorkout(String type, String name, String muscleGroup, double weight, int sets, int reps, int cardioTime, double distance){
        switch (type) {
            case "Strength": {
                StrengthWorkout custom = new StrengthWorkout(name,muscleGroup,weight,sets,reps);
                customWorkouts.add(custom);
                break;
            }
            case "Cardio": {
                CardioWorkout custom = new CardioWorkout(name,cardioTime,distance);
                customWorkouts.add(custom);
                break;
            }
        }
                
    }
    
    public void addToPlan(int day, Workout workout){ // Use day as index for the day of the week
        while (day >= weekPlan.size()){
            weekPlan.add(new Vector<Workout>());
        }
        System.out.println(weekPlan.size());
        weekPlan.get(day).add(workout);
    }
    
    public void resetPlan(){
        weekPlan.clear();
    }
    
    // Display methods
    public void displayUserInfo(){
        System.out.println(username);
    }
    
    public void displayCustomWorkouts(){
        for (Workout workout : customWorkouts){
           System.out.println(workout.getName());
        }
    }
    
    /*public void displayWorkoutRecords() {
        for (Workout workout : customWorkouts){
           System.out.println(workout.getName());
        }
    }*/
    
    public void writeRecords(){
        
        // Will try opening and catch if it can't open/make file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(username + ".txt"));
            
            // Will first write user info
            writer.write("Username:\n" + username + "\nCustom Workouts:\n");
            
            
            for (Workout workout : customWorkouts){
                writer.write(workout.getName() + ",");

                // Checks if the workout is a strength or cardio workout, or neither

                if (workout instanceof StrengthWorkout strengthWorkout){
                    writer.write("Strength Workout,");
                    writer.write(strengthWorkout.getMuscleGroup() + ",");
                    writer.write(strengthWorkout.getWeight() + ",");
                    writer.write(strengthWorkout.getSets() + "," + strengthWorkout.getReps() + ",");
                }
                else if (workout instanceof CardioWorkout cardioWorkout){
                    writer.write("Cardio Workout,");
                    writer.write(cardioWorkout.getCardioTime() + ",");
                    writer.write(cardioWorkout.getDistance() + ",");
                } else {
                    writer.write("Generic Workout,");
                }

                System.out.println(workout.getName() + " saved to records.");
            }
        writer.write("\nCurrent Weekly Plan:\n");
        System.out.println("--------------");
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readCustomWorkouts(){
        
        // Will try opening and catch if unable
        try {
            BufferedReader reader = new BufferedReader(new FileReader(username + ".txt"));
            int index = 0;
            Vector<Workout> readWorkouts = new Vector<>();
            Vector<Vector<Object>> records = new Vector<>();
            
            // Will read file line by line
            String fileLine;
            reader.readLine();
            username = reader.readLine();
            reader.readLine();
            
            // Will run through each custom workout until the weekly plan
            while(!(fileLine = reader.readLine()).equals("Current Weekly Plan:")){
                System.out.println("HIHIHIHIHI");
                String[] lineSplit = fileLine.split(",");
                records.add(new Vector<>());
                
                for (int stringIndex = 0; stringIndex < lineSplit.length; stringIndex++) {
                    records.get(index).add(lineSplit[stringIndex]);
                    //System.out.println(records.get(index).get(stringIndex));
                }
                
                index++;
            }
            
            // Will read the weekly plan
            while((fileLine = reader.readLine()) != null){
                
            }
            
            System.out.println("--------------");
            
            // Will add objects to the local custom workouts vector and pass them to the global custom workouts vector
            //System.out.println(records.size());       Checking for size of vector
            for (int objectIndex = 0; objectIndex < index; objectIndex++){
                if (records.get(objectIndex).get(1).equals("Strength Workout")){ // Will cast values to their intended type
                    readWorkouts.add(new StrengthWorkout(
                            (String) records.get(objectIndex).get(0),
                            (String) records.get(objectIndex).get(2),
                            Double.parseDouble((String) records.get(objectIndex).get(3)),
                            Integer.parseInt((String)records.get(objectIndex).get(4)),
                            Integer.parseInt((String)records.get(objectIndex).get(5))
                    ));
                } else if (records.get(objectIndex).get(1).equals("Cardio Workout")){
                    readWorkouts.add(new CardioWorkout(
                            (String) records.get(objectIndex).get(0),
                            Integer.parseInt((String)records.get(objectIndex).get(2)),
                            Double.parseDouble((String) records.get(objectIndex).get(3))
                    ));
                }
            }
            //System.out.println(readWorkouts.size());      Checking for size of vector
            customWorkouts = readWorkouts;
            
        reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}