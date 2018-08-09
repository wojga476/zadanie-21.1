package pl.javastart;

import java.util.Map;
import java.util.Set;

public class Shop {

    private int money;
    private Map<Item, Integer> stock;

    public Shop(int money, Map<Item, Integer> stock) {
        this.money = money;
        this.stock = stock;
    }

    void playCashSound() {
        /* zakładamy, że ta metoda odtwarza dźwięk https://www.youtube.com/watch?v=Wj_OmtqVLxY, nie musimy jej implementować,
        sprawdzamy tylko czy została uruchomiona */
    }

    public boolean hasItem(String itemName) {
        Set<Item> items = stock.keySet();
        for (Item item : items) {
            if(item.getName().equals(itemName)) {
                Integer count = stock.get(item);
                if(count > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public Item findItemByName(String itemName) {
        for (Item item : stock.keySet()) {
            if(item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public int getMoney() {
        return money;
    }

    public Map<Item, Integer> getStock() {
        return stock;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setStock(Map<Item, Integer> stock) {
        this.stock = stock;
    }

}
