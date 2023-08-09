package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.ConjuredItem;
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
            ItemWrapper _item;

            switch (item.name) {
                case AGED_BRIE:
                    _item = new AgedBrie(item);
                    break;
                case BACKSTAGE_PASSES:
                    _item = new BackstagePass(item);
                    break;
                case SULFURAS:
                    _item = new Sulfuras(item);
                    break;
                default:
                    _item = new NormalItem(item);
            }

            if (item.name.startsWith("Conjured")) {
                _item = new ConjuredItem(item);
            }

            _item.update();
        }
    }

}
