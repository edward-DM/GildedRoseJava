package com.gildedrose.items;

import com.gildedrose.Item;

public class ItemWrapper extends Item {

    public ItemWrapper(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void increaseQuality() {
        if (super.quality < 50) {
            super.quality = super.quality + 1;
        }
    }

    public void decreaseQuality() {
        if (super.quality > 0) {
            super.quality = super.quality - 1;
        }
    }

    public void reduceSellIn() {
        if (super.sellIn < 0)
            super.sellIn = super.sellIn - 1;
    }

    public Item toItem() {
        return new Item(super.name, super.sellIn, super.quality);
    }
}
