package edu.uestc.angel.view;


public class MainMenu {
    public static void main(String[] args) {
        EntryMenu entryMenu = new EntryMenu();
        String command="3";
        do {
            entryMenu.displayMenu();
            command = entryMenu.readInput();
            entryMenu.process(command);
        }while (!command.equals("3"));








    }
}
