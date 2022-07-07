package com.bridgelabz.fileio;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start with Displaying Welcome to Address Book ");
        AddressBook addressBook = new AddressBook();
        addressBook.readPeopleFromFile();
        addressBook.addPerson();
    }
}
