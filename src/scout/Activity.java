package scout;

public class Activity {

    private String activityName;
    private int points;

    public Activity(){
        
    }
    
    public Activity(String activityName, int points) {
        this.activityName = activityName;
        this.points = points;
    }
    
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String name) {
        this.activityName = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
