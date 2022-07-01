package WorkingWithAbstractions.Exercise._4_TrafficLights;

public class TrafficLight {

    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public void switchColor(){
        switch (this.color){
            case RED:
                this.color=Color.GREEN;
                break;
            case GREEN:
                this.color= Color.YELLOW;
                break;
            case YELLOW:
                this.color=Color.RED;
        }
    }

    @Override

    public String toString(){
        return this.color.name();
    }
}
