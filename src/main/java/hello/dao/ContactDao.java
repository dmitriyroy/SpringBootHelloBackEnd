package hello.dao;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.sql.DataSource;
import hello.been.Contact;

import java.util.*;


import org.springframework.stereotype.Component;

/**
 * @author Dmitriy Roy
 *
 */
public class ContactDao implements ContactDaoInterface {


    public ContactDao() {
    }

    @Override
    public Contact getContact(int contactId) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< getContact(); contactId = " + contactId);
        
        String SQL_QUERY = "SELECT id as \"contId\",name "
                         + "FROM test_database.users "
                         + "WHERE id = ? ";

//        Contact contact = (Contact) jdbcTemplate.queryForObject(SQL_QUERY,
//                new Object[]{contactId},
//                new BeanPropertyRowMapper(Contact.class));
        Connection conn = null;
/*
        int countRs = 0;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(SQL_QUERY);
            ps.setInt(1, contactId);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while(rs.next()){
                countRs++;
            }

            System.out.println("countRs = " + countRs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
        */
//        return contact;
        return new Contact(contactId,SQL_QUERY);

    }
    @Override
    public List<Contact> getContacts(String pattern) {
        List<Contact> contactList = new ArrayList<Contact>();
        contactList.add(new Contact(111, "Marmelad*1=" + pattern));
        contactList.add(new Contact(222, "Marmelad*2=" + pattern));
        contactList.add(new Contact(333, "Marmelad*3=" + pattern));
        contactList.add(new Contact(444, "Marmelad*4=" + pattern));
        return contactList;
    }
}
