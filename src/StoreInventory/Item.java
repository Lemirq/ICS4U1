package StoreInventory;

import java.util.Random;

public class Item {
    private int stockNum, stockAmt;
    private String name;
    private Random rand = new Random();

    public Item(String name) {
        this.name = name;
        this.stockNum = rand.nextInt(00000000, 99999999);
    }

    public String getName() {
        return name;
    }

    public int getStockAmt() {
        return stockAmt;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStockAmt(int stockAmt) {
        this.stockAmt = stockAmt;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    void discontinueItem() {
        name = "discontiued";
        stockAmt = 0;
    }
}
