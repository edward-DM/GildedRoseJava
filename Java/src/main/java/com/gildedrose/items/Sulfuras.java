package com.gildedrose.items;

import com.gildedrose.Item;

public class Sulfuras extends ItemWrapper {

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public void processQuality() {
        // do nothing
    }

    @Override
    public void processExpiredItem() {
        // do nothing
    }

    @Override
    public void processSellIn() {
        // do Nothing
    }
}
