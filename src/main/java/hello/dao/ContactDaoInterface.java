package hello.dao;

import hello.been.Contact;

import java.util.List;

public interface ContactDaoInterface {

    List<Contact> getContacts(String pattern);
    Contact getContact(int contId);
}
