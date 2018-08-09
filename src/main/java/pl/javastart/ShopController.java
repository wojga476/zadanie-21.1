package pl.javastart;

import java.util.Map;

public class ShopController {

    private Shop shop;

    public ShopController(ShopRepository shopRepository) {
        shop = shopRepository.findShop();

    }

    public void sellItem(Human human, String itemName) throws OutOfStockException {

        if (shop.hasItem(itemName)) {
            Item item = shop.findItemByName(itemName);
            if (item.getAgeRestriction() > human.getAge()) {
                throw new TooYoungException();
            }
            if(!item.isLegal() && human.getJob().equals("Policjant")) {

            }

            shop.setMoney(item.getPrice());
            human.setMoney(human.getMoney() - item.getPrice());

            Map<Item, Integer> stock = shop.getStock();
            stock.put(item, 4);

            shop.playCashSound();

        } else {
            throw new OutOfStockException();
        }

    }

}
