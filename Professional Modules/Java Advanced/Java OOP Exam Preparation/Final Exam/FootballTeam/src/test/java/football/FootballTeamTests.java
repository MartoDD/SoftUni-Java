package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {

    Footballer footballer1;
    Footballer footballer2;
    Footballer footballer3;
    Footballer footballer4;

    FootballTeam footballTeam = new FootballTeam("Manchester", 4);

    @Before
    public void setUp() {
        footballer1 = new Footballer("Asparuh");
        footballer2 = new Footballer("Berbatov");
        footballer3 = new Footballer("Mesi");
        footballer4 = new Footballer("Ronaldo");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Manchester", footballTeam.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWithInvalidName() {
        FootballTeam footballTeam = new FootballTeam(null, 4);
    }

    @Test
    public void testGetVacantPositions() {
        Assert.assertEquals(4, footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVacantPositionsWithInvalidValue() {
        FootballTeam footballTeam = new FootballTeam("Barselona", -1);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(4, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerWhenThereIsNoMoreCapacity() {
        footballTeam.addFootballer(footballer1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerThatDoesNotExist() {
        footballTeam.removeFootballer("Marto");
    }

    @Test
    public void testRemoveFootballer() {
        footballTeam.removeFootballer("Berbatov");
        Assert.assertEquals(3, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleWithInvalidName() {
        footballTeam.footballerForSale("Marto");
    }

    @Test
    public void testFootballerForSale() {
        Footballer footballer = footballTeam.footballerForSale("Ronaldo");
        Assert.assertFalse(footballer.isActive());
    }

    @Test
    public void testGetStatistics(){
        FootballTeam footballTeamTest = new FootballTeam("Ludogorec",1);
        footballTeamTest.addFootballer(footballer1);

        Assert.assertEquals("The footballer Asparuh is in the team Ludogorec.",footballTeamTest.getStatistics());
    }

}
