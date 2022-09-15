package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GiftFactoryTests {

    Gift gift;
    Gift gift2;
    Gift gift3;
    Gift gift4;

    GiftFactory giftFactory=new GiftFactory();

    @Before
    public void setUp(){
        gift=new Gift("Pet",32.2);
        gift2=new Gift("Bike",14.12);
        gift3=new Gift("Shoe",23.4);
        gift4=new Gift("Book",13.2);

        giftFactory.createGift(gift);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        giftFactory.createGift(gift4);

    }

    @Test
    public void testGetCount(){

        Assert.assertEquals(4,giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateDuplicateGift(){
        giftFactory.createGift(gift);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNull(){
        giftFactory.removeGift(null);
    }
    @Test
    public void testRemoveTrue(){
        Assert.assertTrue(giftFactory.removeGift("Pet"));
    }
    @Test
    public void testRemoveFalse(){
        Assert.assertFalse(giftFactory.removeGift("Koko"));
    }
    @Test
    public void testGetLeastMagic(){
        Assert.assertEquals(gift4,giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresent(){
        Assert.assertEquals(gift,giftFactory.getPresent("Pet"));
    }

    /*@Test
    public void testGetPresents(){
        List<Gift>expected = new ArrayList<>();
        expected.add(gift);
        expected.add(gift2);
        expected.add(gift3);
        expected.add(gift4);
        Collection<Gift> expectedUnmodifiable=Collections.unmodifiableCollection(expected);

        Assert.assertEquals(expectedUnmodifiable,giftFactory.getPresents());
    }*/
}
