package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.isReservedTable = false;
        this.numberOfPeople=0;
    }

    public void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    public void setReservedTable(boolean reservedTable) {
        isReservedTable = reservedTable;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.numberOfPeople*this.pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setReservedTable(true);
        setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        return allPeople();
    }

    @Override
    public void clear() {
        setReservedTable(false);
        setNumberOfPeople(0);
        this.beverages=new ArrayList<>();
        this.healthyFood=new ArrayList<>();
    }

    @Override
    public String tableInformation() {
        return String.format("Table - %d",getTableNumber()) + System.lineSeparator() +
                String.format("Size - %d",getSize()) + System.lineSeparator() +
                String.format("Type - %s",getClass().getSimpleName()) + System.lineSeparator() +
                String.format("All price - %.2f",this.pricePerPerson);
    }
}
