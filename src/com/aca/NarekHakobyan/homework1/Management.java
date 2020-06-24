package com.aca.NarekHakobyan.homework1;

public interface Management {
    void changePrice(String name, int price);
    void addItem(String Name, Type type, int ram, int recDuration, int price, int quantity, VideoQuality videoQuality,
                 SoundFormat soundFormat);
    int getStockAMD();
    int getSoldAMD();
    void sellItem(String name);
    void listOfItems();
    void listOfItemsByType(Type type);
}
