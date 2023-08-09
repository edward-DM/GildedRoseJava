package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.ItemWrapper;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.Sulfuras;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        List<ItemWrapper> itemList = Arrays.stream(items)
            .map(ItemWrapper::new)
            .collect(Collectors.toList());

        for (ItemWrapper item : itemList) {
            ItemStrategy itemStrat;
            switch (item.name) {
                case AGED_BRIE:
                    itemStrat = new AgedBrie(item);
                    break;
                case BACKSTAGE_PASSES:
                    itemStrat = new BackstagePass(item);
                    break;
                case SULFURAS:
                    itemStrat = new Sulfuras(item);
                    break;
                default:
                    itemStrat = new NormalItem(item);
            }
            process(itemStrat);
        }
        items = itemList.stream()
            .map(ItemWrapper::toItem)
            .toArray(Item[]::new);
    }

    private void process(ItemStrategy item) {
        item.processQuality();
        item.processSellIn();
        item.processExpiredItem();
    }

    private void processQuality(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            increaseQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        } else if (item.name.equals(SULFURAS)) {
            return;
        } else if (item.quality > 0) {
            decreaseQuality(item);
        }
    }

    private void processSellIn(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    private void processedExpiredItem(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            increaseQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = 0;
        } else if (item.name.equals(SULFURAS)) {
            return; //do nothing
        } else {
            decreaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

}
