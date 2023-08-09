package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class GildedRoseTest {

    @Test
    void _preCheck() {
        assertThat(true).isTrue();
        assertThat(false).isFalse();

        try {
            assertTrue(false);
        } catch (AssertionError e) {
            return;
        }
        fail("Shouldn't happen, check maven config or project structure");
    }

    @Test
    void qualityDecreasesTwiceAsFastAfterExpiry() {
        Item item = new Item("potion", -1, 4);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isEqualTo(2);

        shop.updateQuality();
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void qualityIsNeverNegative() {
        Item item = new Item("potion", 1, 0);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isGreaterThanOrEqualTo(0);
    }

    @Test
    void agedBrieIncreasesInQuality() {
        Item item = new Item("Aged Brie", 1, 1);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isGreaterThanOrEqualTo(2);
    }

    @Test
    void qualityOfItemIsNeverMoreThan50() {
        Item item = new Item("Aged Brie", 1, 50);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality(); // increases quality of brie
        assertThat(item.quality).isLessThanOrEqualTo(50);
    }

    @Test
    void sulfurasDoesntNeedToBeSoldOrDecreasesInQuality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 50);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void backstagePassesIncreaseBy2() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isEqualTo(3);
    }

    @Test
    void backstagePassesIncreaseBy3() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isEqualTo(4);
    }

    @Test
    void backstagePassesDropTo0() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    @Disabled
    void conjusredItemsDegradeTwiceAsFast() {
        Item item = new Item("Conjured potion", 5, 10);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void sulfurasHasQuality80AndNeverDegrades() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 80);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isEqualTo(80);
        assertThat(item.sellIn).isEqualTo(5); // sellIn also stays the same? hmkay
    }

    @Test
    void sellInDecreasesAfterEachUpdate() {
        Item item = new Item("potion", 5, 4);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.sellIn).isEqualTo(4);
    }

    @Test
    void qualityDecreasesAfterEachUpdate() {
        Item item = new Item("potion", 5, 4);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isEqualTo(3);
    }

    @Test
    void agedBrieShouldIncreaseTwiceAsFastInQualityAfterExpiry() {
        Item item = new Item("Aged Brie", 0, 30);
        GildedRose shop = new GildedRose(new Item[]{item});

        shop.updateQuality();
        assertThat(item.quality).isEqualTo(32);
        shop.updateQuality();
        assertThat(item.quality).isEqualTo(34);
    }

}
