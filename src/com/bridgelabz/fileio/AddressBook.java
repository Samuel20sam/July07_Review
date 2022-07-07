package com.bridgelabz.fileio;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class AddressBook {

    static Scanner scanner = new Scanner(System.in);
    LinkedList<Contacts> person = new LinkedList<>();
    File file = new File("AddressBook.txt");

    public void addPerson() {
        System.out.println("Enter the First Name");
        String fName = scanner.next();
        System.out.println("Enter the Last Name");
        String lName = scanner.next();
        System.out.println("Enter the Address");
        String address = scanner.next();
        System.out.println("Enter the City");
        String city = scanner.next();
        System.out.println("Enter the State");
        String state = scanner.next();
        System.out.println("Enter the Zip");
        String zip = scanner.next();
        System.out.println("Enter the PhoneNumber");
        String phoneNumber = scanner.next();
        System.out.println("Enter the Email");
        String email = scanner.next();

        Contacts list = new Contacts(fName, lName, address, city, state, zip, phoneNumber, email);
        addToFile(list);
        person.add(list);
        System.out.println("Contact added is:" +person);
    }

    private void addToFile(Contacts detail){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(detail.getFirstName() + "\r\n" + detail.getLastName() + "\r\n" + detail.getAddress() + "\r\n" + detail.getCity() +
                    "\r\n" + detail.getState() + "\r\n" + detail.getZip() + "\r\n" + detail.getPhoneNumber() + "\r\n" + detail.getEmail() + "\r\n\r\n");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }
    public void readPeopleFromFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String name;
            while ((name = reader.readLine()) != null) {
                Contacts person1 = new Contacts(name, reader.readLine(), reader.readLine(), reader.readLine(),
                        reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine());
                person.add(person1);
                reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("something went wrong");
        }
    }
}