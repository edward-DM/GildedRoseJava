package com.gildedrose.items;

import com.gildedrose.Item;

public class NormalItem extends ItemWrapper {

    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public void processQuality() {
        decreaseQuality();
    }

    @Override
    public void processExpiredItem() {
        processQuality();
    }

    @Override
    public void processSellIn() {
        decreaseSellIn();
    }
}
