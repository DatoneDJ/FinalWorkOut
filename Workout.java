public class Workout {
    // ------------------Variables------------------
    private String name;
    
    //------------------Constructors------------------
    public Workout(){
        name = "Example Workout";
    }
    
    public Workout(String name){
        this.name = name;
    }
    
    // ------------------Setters------------------
    public void setName(String name){
        this.name = name;
    }
    
    // ------------------Getters------------------
    public String getName(){
        return name;
    }

    // ------------------Other Methods------------------
    public void displayWorkout(){
        System.out.println("--- " + name + " Details --- ");
        System.out.println("--- Generic Workout " + name + " Has No Details --- ");
    }
}