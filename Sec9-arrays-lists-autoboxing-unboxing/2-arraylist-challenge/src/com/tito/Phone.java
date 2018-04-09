package com.tito;


import java.util.ArrayList;

public class Phone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

  public Phone(String myNumber) {
    this.myNumber = myNumber;
    this.myContacts = new ArrayList<Contacts>();
  }

  public boolean addContact(Contacts contacts) {
    if (findContact(contacts.getName()) >= 0) {
      System.out.println("contact is already on file");
      return false;
    }

    myContacts.add(contacts);
    return true;
  }

  public boolean updateContact(Contacts oldContact, Contacts newContact) {
    int foundPosition = findContact(oldContact);
    if (foundPosition < 0) {
      System.out.println(oldContact.getName() + " was not found");
      return false;
    } else if (findContact(newContact.getName()) != -1) {
        System.out.println("contact with name " + newContact.getName() + " already exists --> update unsuccessful");
        return false;
    }

    this.myContacts.set(foundPosition, newContact);
    System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
    System.out.println(oldContact.getPhoneNumber() + " was replaced with " + newContact.getPhoneNumber());
    return true;
  }

  public boolean removeContact(Contacts contact) {
    int foundPosition = findContact(contact);
    if (foundPosition < 0) {
      System.out.println(contact.getName() + " was not found");
      return false;
    }
    this.myContacts.remove(foundPosition);
    System.out.println(contact.getName() + " was deleted");
    return true;
  }

  private int findContact(Contacts contact) {
    return  this.myContacts.indexOf(contact);
  }

  private int findContact(String contactName) {
    for (int i = 0; i < this.myContacts.size(); i++) {
      Contacts contact = this.myContacts.get(i);
      if (contact.getName().equals(contactName)) {
        return i;
      }
    }
    return -1;
  }

  public String queryContact(Contacts contact) {
    if (findContact(contact) >= 0) {
      return contact.getName();
    }
    return null;
  }

  public Contacts queryContact(String name) {
    int position = findContact(name);
    if (position >= 0) {
      return this.myContacts.get(position);
    }

    return null;
  }

  public void printContacts() {
    System.out.println("contacts list:");
    for (int i = 0; i < this.myContacts.size(); i++) {
      System.out.println((i + 1) + "." + this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getPhoneNumber());
    }
  }
}
