public class CardioWorkout extends Workout {
    // ------------------Variables------------------
    private int cardioTime;
    private double distance;
    
    //------------------Constructors------------------
    public CardioWorkout(){
        super();
        cardioTime = 30;
        distance = 3.5;
    }
    
    public CardioWorkout(String name, int cardioTime, double distance){
        super(name);
        this.cardioTime = cardioTime;
        this.distance = distance;
    }
    
    // ------------------Setters------------------
    public void setCardioTime(int cardioTime){
        this.cardioTime = cardioTime;
    }
    
    public void setDistance(double distance){
        this.distance = distance;
    }
    
    // ------------------Getters------------------
    public int getCardioTime(){
        return cardioTime;
    }
    
    public double getDistance(){
        return distance;
    }

    // ------------------Other Methods------------------
    @Override
    public void displayWorkout(){
        System.out.println("--- " + super.getName() + " Details --- ");
        System.out.println("Time: " + cardioTime + " minutes");
        System.out.println("Distance: " + distance + " miles");
        System.out.println("--- End of " + super.getName() + " Details --- ");
    }
}