package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemStrategy;

public class Sulfuras implements ItemStrategy {
    public ItemWrapper item;

    public Sulfuras(Item item) {
        this.item = new ItemWrapper(item);
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
