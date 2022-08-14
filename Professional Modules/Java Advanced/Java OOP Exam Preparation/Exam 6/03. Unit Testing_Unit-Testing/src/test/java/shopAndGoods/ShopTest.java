package shopAndGoods;


import org.junit.Before;

import javax.naming.OperationNotSupportedException;

public class ShopTest {

    private Goods goods1;
    private Goods goods2;
    private Goods goods3;
    private Goods goods4;

    private Shop shop;

    @Before
    public void setUp() throws OperationNotSupportedException {
        goods1=new Goods("Hrana","123");
        goods2=new Goods("Voda","435");
        goods3=new Goods("Stol","56456");
        goods4=new Goods("Cigari","3434");

        shop=new Shop();
        shop.addGoods("Shelves1",goods1);
        shop.addGoods(goods1);
    }
}