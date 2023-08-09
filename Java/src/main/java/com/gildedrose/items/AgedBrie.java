package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends ItemWrapper {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void processQuality() {
        super.increaseQuality();
    }

    @Override
    public void processExpiredItem() {
        super.increaseQuality();
    }

    @Override
    public void processSellIn() {
        super.decreaseSellIn();
    }
}
