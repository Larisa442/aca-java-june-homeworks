package com.aca.NarekHakobyan.homework1;

import java.util.ArrayList;
import java.util.Scanner;

public class shop {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Pen video", Type.Video, 0, 2, 6500, 3, VideoQuality.VGA, SoundFormat.MP4));
        items.add(new Item("Pen record", Type.Record, 8, 9, 14000, 1, VideoQuality.NONE, SoundFormat.MP3));
        items.add(new Item("USB flash record", Type.Record, 8, 9, 11000, 4, VideoQuality.NONE, SoundFormat.MP3));
        items.add(new Item("USB flash video", Type.Video, 0, 2, 9000, 2, VideoQuality.VGA, SoundFormat.MP4));
        items.add(new Item("Watch", Type.Record, 8, 5, 5000, 8, VideoQuality.HD, SoundFormat.MP3));
        Manager manager = new Manager(items);

        Scanner in = new Scanner(System.in);
        System.out.println("Test cases\n1)Show all list of items\n2)Sell item function\n3)Sold and Stock AMD functions\n" +
                           "4)List of Record type items\n5)List of Video type items\n6)Change price function\n7)Wrong input parameters" +
                "in constructor\n8)Wrong parameters for addItem function\n9)exit");
        System.out.print("Please enter test case number: ");
        int testCase;
        br:
        while (true) {
            System.out.print("Please enter test case number: ");
            testCase = in.nextInt();
            switch (testCase) {
                case 1:
                    testListOfItem(manager);
                    break;
                case 2:
                    testSellItem(manager);
                    break;
                case 3:
                    testStockSellAMD(manager);
                    break;
                case 4:
                    testListOfItemByType(Type.Record, manager);
                    break;
                case 5:
                    testListOfItemByType(Type.Video, manager);
                    break;
                case 6:
                    testChangePrice(manager);
                    break;
                case 7:
                    testWrongInput();
                    break;
                case 8:
                    ArrayList<Item> items1 = new ArrayList<Item>();
                    Manager manager1 = new Manager(items1);
                    testWrongAdd(manager1);
                    break;
                case 9:
                    break br;
                default:
                    System.out.println("Please enter right test case number");
                    continue br;
            }
        }
    }

    private static void testListOfItem(Manager manager) {
        manager.listOfItems();
    }

    private static void testSellItem(Manager manager) {
        System.out.println("Before sale item list");
        manager.listOfItems();
        manager.sellItem("Pen video");
        System.out.println("After sale item list");
        manager.listOfItems();
    }

    private static void testStockSellAMD(Manager manager) {
        System.out.println("Before sale Stock AMD: " + manager.getStockAMD());
        System.out.println("Before sale Sale AMD: " + manager.getSoldAMD());
        manager.sellItem("Pen video");
        System.out.println("After sale Stock AMD: " + manager.getStockAMD());
        System.out.println("After sale Sale AMD: " + manager.getSoldAMD());
    }

    private static void testListOfItemByType(Type type, Manager manager) {
        manager.listOfItemsByType(type);
    }

    private static void testChangePrice(Manager manager) {
        System.out.println("Before changing of price");
        manager.listOfItems();
        manager.changePrice("Pen Video", 1000);
        manager.changePrice("Pen Record", 2000);
        manager.changePrice("USB flash record", 3000);
        manager.changePrice("USB flash video", 4000);
        System.out.println("After changing of price");
        manager.listOfItems();
    }

    private static void testWrongInput() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("1", Type.Record, -8, 5, 5000, 8, VideoQuality.VGA, SoundFormat.MP4));
        items.add(new Item("2", Type.Record, 8, -5, 5000, 8, VideoQuality.VGA, SoundFormat.MP4));
        items.add(new Item("3", Type.Record, 8, 5, -5000, 8, VideoQuality.VGA, SoundFormat.MP4));
        items.add(new Item("4", Type.Record, 8, 5, 5000, -8, VideoQuality.VGA, SoundFormat.MP4));
        Manager manager = new Manager(items);

        manager.listOfItems();
    }

    private static void testWrongAdd(Manager manager) {
        manager.addItem("1", Type.Record, -8, 5, 5000, 8, VideoQuality.VGA, SoundFormat.MP4);
        manager.listOfItems();
        manager.addItem("2", Type.Record, 8, -5, 5000, 8, VideoQuality.VGA, SoundFormat.MP4);
        manager.listOfItems();
        manager.addItem("3", Type.Record, 8, 5, -5000, 8, VideoQuality.VGA, SoundFormat.MP4);
        manager.listOfItems();
        manager.addItem("4", Type.Record, 8, 5, 5000, -8, VideoQuality.VGA, SoundFormat.MP4);
        manager.listOfItems();
    }
}
