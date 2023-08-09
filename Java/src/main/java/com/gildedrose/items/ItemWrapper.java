package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class ItemWrapper {

    public Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    protected final void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected final void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected final void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    public final void update() {
        processQuality();
        processSellIn();
        if (item.sellIn < 0) {
            processExpiredItem();
        }
    }

    public abstract void processQuality();

    public abstract void processExpiredItem();

    public abstract void processSellIn();
}
