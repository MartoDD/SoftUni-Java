package Temp;

public class Mission {

    private String codeName;
    private State state;

    @Override
    public String toString(){
        return String.format("Code Name: %s State: %s",this.codeName,this.state);

    }
}
