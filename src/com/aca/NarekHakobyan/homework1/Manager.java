package com.aca.NarekHakobyan.homework1;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager implements Management {
    private ArrayList<Item> items = new ArrayList<Item>();
    private int soldAMD = 0;
    private int stockAMD = 0;

    private static boolean isCorrectInput(Item item) {
        if(item.price <= 0 || item.quantity < 0 || item.recDuration < 0 || item.memory < 0) {
            System.out.println("Some parameter of item is wrong. Please check");
            return false;
        }
        return true;
    }

    private static void listOfItems(Item item) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tList of items");
        System.out.println("Name\t\t\t\t\tType\t\t\tMemory\t\t\t\t\tRecording Duration\t\tPrice\t\tQuantity\t\tVideo Quality\t\tSound Quality");
        System.out.printf("%-20s\t%-12s\t%-20s\t%-12s\t\t\t%-8d\t%-8d\t\t%-8s\t\t\t%-8s\n", item.name, item.type,
                          item.memory == 0 ? "no inside memory" : item.memory + "GB", item.recDuration + " hours", item.price,
                          item.quantity, (item.videoQuality.name().equals(VideoQuality.NONE.name()) ? "" : item.videoQuality.name()),
                          item.soundFormat.name());
    }

    private static int action(Item i) {
        int action;
        Scanner in = new Scanner(System.in);
        act:
        while (true) {
            if (!isCorrectInput(i)) {
                listOfItems(i);
                System.out.println("Please check appropriate action\n1)Skip item\n2)Add anyway\n3)Correct the parameters");
                action = in.nextInt();
                switch (action) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    default:
                        System.out.println("Please enter right action number");
                        continue act;
                }
            }
            return 2;
        }
    }

    private static void updateInput(Item i) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Please enter new RAM: ");
            i.memory = in.nextInt();
            System.out.print("\nPlease enter new Recording Duration: ");
            i.recDuration = in.nextInt();
            System.out.print("\nPlease enter new Price: ");
            i.price = in.nextInt();
            System.out.print("\nPlease enter new Quantity: ");
            i.quantity = in.nextInt();
        } while(!isCorrectInput(i));
    }

    Manager(ArrayList<Item> item) {
        act:
        for (Item i : item) {
            switch (action(i)) {
                case 1:
                    continue act;
                case 2:
                    items.add(i);
                    break;
                case 3:
                    updateInput(i);
                    items.add(i);
                    break;
            }
            stockAMD += i.quantity * i.price;
        }
    }

    public void changePrice(String name, int price) {
        for (Item i : this.items) {
            if (i.name.equals(name)) {
                i.price = price;
                return;
            }
        }
    }

    public void addItem(String Name, Type type, int memory, int recDuration, int price, int quantity, VideoQuality videoQuality,
                        SoundFormat soundFormat) {
        Item item = new Item(Name, type, memory, recDuration, price, quantity, videoQuality, soundFormat);
        switch (action(item)) {
            case 1:
                break;
            case 2:
                items.add(item);
                break;
            case 3:
                updateInput(item);
                items.add(item);
                break;
        }
        stockAMD += item.quantity * item.price;
    }

    public int getStockAMD() {
        return stockAMD;
    }

    public int getSoldAMD() {
        return soldAMD;
    }

    public void sellItem(String name) {
        for (Item i : this.items) {
            if (i.name.equals(name)) {
               if (i.quantity > 0) {
                    i.quantity--;
                    stockAMD -= i.price;
                    soldAMD += i.price;
                    return;
                }
            }
        }
        System.out.printf("All %s's sold\n",  name);
    }

    public void listOfItems() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tList of items");
        System.out.println("Name\t\t\t\t\tType\t\t\tMemory\t\t\t\t\tRecording Duration\t\tPrice\t\tQuantity\t\tVideo Quality\t\tSound Quality");
        for (Item item : items) {
            System.out.printf("%-20s\t%-12s\t%-20s\t%-12s\t\t\t%-8d\t%-8d\t\t%-8s\t\t\t%-8s\n", item.name, item.type,
                              item.memory == 0 ? "no inside memory" : item.memory + "GB", item.recDuration + " hours", item.price,
                              item.quantity, (item.videoQuality.name().equals(VideoQuality.NONE.name()) ? "" : item.videoQuality.name()),
                              item.soundFormat.name());
        }
    }

    public void listOfItemsByType(Type type) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tList of items");
        System.out.println("Name\t\t\t\t\tType\t\t\tMemory\t\t\t\t\tRecording Duration\t\tPrice\t\tQuantity\t\tVideo Quality\t\tSound Quality");
        for (Item item : items) {
            if (item.type.equals(type))
                System.out.printf("%-20s\t%-12s\t%-20s\t%-12s\t\t\t%-8d\t%-8d\t\t%-8s\t\t\t%-8s\n", item.name, item.type,
                                  item.memory == 0 ? "no inside memory" : item.memory + "GB", item.recDuration + " hours", item.price,
                                  item.quantity, (item.videoQuality.name().equals(VideoQuality.NONE.name()) ? " " : item.videoQuality.name()),
                                  item.soundFormat.name());
        }
    }
}