package hello.controller;

import hello.been.Contact;
import hello.dao.ContactDao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

/**
 * @author Dmitriy Roy
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/contact", method = RequestMethod.GET, headers = "Accept=application/json")
    public Contact getContact(@RequestParam(value="userId", required=false) int userId) {
        System.out.println("\n------------>>>>>>>>>>>>>>>>> getContact333333333333()");

        ContactDao  contactDao = new ContactDao();
        return contactDao.getContact(userId);
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Contact> getContacts(@RequestParam(value="nameFilter", required=false) String nameFilter) {
        System.out.println("\n------------>>>>>>>>>>>>>>>>> getContacts()");

        return new ContactDao().getContacts(nameFilter);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Contact> getTestContact() {
        System.out.println("\n------------>>>>>>>>>>>>>>>>> getTestContact() - привет Всем!!!");
            List<Contact> outList = new ArrayList<>();
            outList.add(new Contact(123,"Вася"));
            outList.add(new Contact(234,"Петя"));
            outList.add(new Contact(345,"Миша_1234567980"));
            outList.add(new Contact(456,"Димаqwerty_23456"));
        return outList;
    }

}
