package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemStrategy;

public class NormalItem implements ItemStrategy {

    public ItemWrapper item;

    public NormalItem(Item item) {
        this.item = new ItemWrapper(item);
    }

    @Override
    public void processQuality() {
        item.increaseQuality();
    }

    @Override
    public void processExpiredItem() {
        item.decreaseQuality();
    }

    @Override
    public void processSellIn() {
        item.reduceSellIn();
    }
}
