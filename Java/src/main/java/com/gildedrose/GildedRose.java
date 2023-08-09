package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.ItemWrapper;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.Sulfuras;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            ItemWrapper wrapper;
            switch (item.name) {
                case AGED_BRIE:
                    wrapper = new AgedBrie(item);
                    break;
                case BACKSTAGE_PASSES:
                    wrapper = new BackstagePass(item);
                    break;
                case SULFURAS:
                    wrapper = new Sulfuras(item);
                    break;
                default:
                    wrapper = new NormalItem(item);
            }
            wrapper.update();
        }
    }

}
