package DefiningClasses.Exercises._7_Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons=new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public List<Parent> getParents() {
        return parents;
    }


    public List<Child> getChildren() {
        return children;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return this.name + "\n"
                + "Company:\n" + (this.company == null ? "" : this.company.print() + "\n")
                + "Car:\n" + (this.car == null ? "" : this.car.print() + "\n");

    }
}
