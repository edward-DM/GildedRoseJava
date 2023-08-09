package com.gildedrose;

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
            process(item);
        }
    }

    private void process(Item item) {
        processQuality(item);
        processSellIn(item);

        if (item.sellIn < 0) {
            processedExpiredItem(item);
        }
    }

    private void processQuality(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            increaseQuality(item);

        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            increaseQuality(item);
            if (item.name.equals(BACKSTAGE_PASSES)) {
                if (item.sellIn < 11) {
                    increaseQuality(item);
                }

                if (item.sellIn < 6) {
                    increaseQuality(item);
                }
            }
        } else if (item.name.equals(SULFURAS)) {
            return;
        } else if (item.quality > 0) {
            decreaseQuality(item);
        }
    }

    private void processSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void processedExpiredItem(Item item) {
        if (!item.name.equals(AGED_BRIE)) {
            if (!item.name.equals(BACKSTAGE_PASSES)) {
                if (!item.name.equals(SULFURAS)) {
                    decreaseQuality(item);
                }
            } else {
                item.quality = 0;
            }
        } else {
            increaseQuality(item);
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
