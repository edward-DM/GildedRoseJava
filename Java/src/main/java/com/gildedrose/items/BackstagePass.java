package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends ItemWrapper {

    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    public void processQuality() {
        increaseQuality();
        if (item.sellIn < 11) {
            increaseQuality();
        }
        if (item.sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    public void processExpiredItem() {
        item.quality = 0;
    }

    @Override
    public void processSellIn() {
        decreaseSellIn();
    }

}
