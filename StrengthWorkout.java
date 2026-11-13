public class StrengthWorkout extends Workout {
    // ------------------Variables------------------
    private String muscleGroup;
    private double weight;
    private int sets, reps;
    
    //------------------Constructors------------------
    public StrengthWorkout(){
        super();
        muscleGroup = "Chest";
        weight = 125;
        sets = 4;
        reps = 8;
    }
    
    public StrengthWorkout(String name, String muscleGroup, double weight, int sets, int reps){
        super(name);
        this.weight = weight;
        this.muscleGroup = muscleGroup;
        this.sets = sets;
        this.reps = reps;
    }
    
    // ------------------Setters------------------    
    public void setMuscleGroup(String muscleGroup){
        this.muscleGroup = muscleGroup;
    }
    
    public void setWeight(double weight){
        this.weight = weight;
    }
    
    public void setSets(int sets){
        this.sets = sets;
    }
    
    public void setReps(int reps){
        this.reps = reps;
    }
    
    // ------------------Getters------------------
    public String getMuscleGroup(){
        return muscleGroup;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public int getSets(){
        return sets;
    }
    
    public int getReps(){
        return reps;
    }
    
    // ------------------Other Methods------------------
    @Override
    public void displayWorkout(){
        System.out.println("--- " + super.getName() + " Details --- ");
        System.out.println("Muscle Group: " + muscleGroup);
        System.out.println("Weight: " + weight + " lbs ");
        System.out.println("Sets x Reps: " + sets + "x" + reps);
        System.out.println("--- End of " + super.getName() + " Details --- ");
    }
}