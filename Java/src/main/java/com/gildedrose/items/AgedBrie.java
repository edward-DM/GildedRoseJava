package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemStrategy;

public class AgedBrie implements ItemStrategy {
    public ItemWrapper item;

    public AgedBrie(Item item) {
        this.item = new ItemWrapper(item);
    }

    @Override
    public void processQuality() {
        item.increaseQuality();
    }

    @Override
    public void processExpiredItem() {
        item.increaseQuality();
    }

    @Override
    public void processSellIn() {
        item.reduceSellIn();
    }
}
