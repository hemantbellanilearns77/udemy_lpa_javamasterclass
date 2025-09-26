package com.hb.study.udemy_lpa_javamasterclass.section10_collections.exercises.exercise44;


import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import java.util.ArrayList;

public class MobilePhone {

    String myNumber;
    ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contactToAdd){
        boolean notFoundAndAdded = false;
        if(findContact(contactToAdd.getName()) == -1) {
            this.myContacts.add(contactToAdd);
            notFoundAndAdded = true;
        }
        return notFoundAndAdded;
    }

    public boolean updateContact(Contact contactToUpdate, Contact contactWithUpdates){
        boolean foundAndUpdated = false;
        int foundPosition = findContact(contactToUpdate);
        if(foundPosition != -1) {
            this.myContacts.set(foundPosition, contactWithUpdates);
            foundAndUpdated = true;
        }
        return foundAndUpdated;
    }

    public boolean removeContact(Contact contactToBeRemoved){
        boolean contactRemoved = false;
        int foundPos = findContact(contactToBeRemoved);
        if(foundPos != -1) {
            this.myContacts.remove(foundPos);
            contactRemoved = true;
        }
        return contactRemoved;
    }

    public int findContact(Contact contactToFind) {
        return this.myContacts.indexOf(contactToFind);
    }

    public int findContact(String string) {
        int contactFoundAtPos = -1;
        for(int loopCounter = 0; loopCounter < this.myContacts.size(); loopCounter++) {
            if(this.myContacts.get(loopCounter).getName().equalsIgnoreCase(string) ) {
                contactFoundAtPos = loopCounter;
            }
        }
        return contactFoundAtPos;
    }

    public Contact queryContact(String name) {
        Contact foundContact = null;
        int position = findContact(name);
        if(position >=0 ) {
            foundContact = myContacts.get(position);
        }
        return foundContact;
    }

    public void printContacts(){
        if(!this.myContacts.isEmpty()) {
            StringBuilder pribtContactsTextBlock = new StringBuilder();
            pribtContactsTextBlock.append("Contact List:CommonConstants.NEWLINE");
            int listOrderNumber = 1;
            for (Contact nextContact : this.myContacts) {
                pribtContactsTextBlock.append(listOrderNumber).append(". ").append(nextContact.getName()).append(" -> ").append(nextContact.getPhoneNumber()).append("CommonConstants.NEWLINE");
            }
            ConsoleStyler.styleOutput(pribtContactsTextBlock.toString());
        }
    }
}
