package com.aca.NarekHakobyan.homework1;

public class Item {
    String name;
    int memory;
    int recDuration;
    int price;
    int quantity = 0;
    Type type;
    VideoQuality videoQuality;
    SoundFormat soundFormat;

    Item(String name, Type type, int memory, int recDuration, int price, int quantity, VideoQuality videoQuality, SoundFormat soundFormat) {
        this.name = name;
        this.type = type;
        this.memory = memory;
        this.recDuration = recDuration;
        this.price = price;
        this.quantity = quantity;
        this.videoQuality = videoQuality;
        this.soundFormat = soundFormat;
    }
}
