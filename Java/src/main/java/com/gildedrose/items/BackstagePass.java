package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemStrategy;

public class BackstagePass implements ItemStrategy {

    public ItemWrapper item;

    public BackstagePass(Item item) {
        this.item = new ItemWrapper(item);
    }

    @Override
    public void processQuality() {
        item.increaseQuality();
        if (item.sellIn < 11) {
            item.increaseQuality();
        }
        if (item.sellIn < 6) {
            item.increaseQuality();
        }
    }

    @Override
    public void processExpiredItem() {
        item.quality = 0;
    }

    @Override
    public void processSellIn() {
        item.reduceSellIn();
    }
}
