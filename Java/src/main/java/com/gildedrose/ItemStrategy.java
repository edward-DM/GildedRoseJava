package com.gildedrose;

public interface ItemStrategy {
    void processQuality();
    void processExpiredItem();
    void processSellIn();
}
