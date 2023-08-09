package com.gildedrose.items;

import com.gildedrose.Item;

public class ConjuredItem extends ItemWrapper {
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void processQuality() {
        decreaseQuality();
        decreaseQuality();
    }

    @Override
    public void processExpiredItem() { // 2x faster than normal decrease of quality
        decreaseQuality();
        decreaseQuality();
        decreaseQuality();
        decreaseQuality();
    }

    @Override
    public void processSellIn() {
        decreaseSellIn();
    }
}
