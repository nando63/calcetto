package com.example.nando.myapplication;

import java.util.ArrayList;
import java.util.Iterator;

public class UserList {
    private static UserList ul;
    private ArrayList ulist;

    public static UserList getInstance() {
        if (ul == null) {
            ul = new UserList();
        }
        return ul;
    }

    private UserList () {
        ulist = new ArrayList();
        Utente u = new Utente();
        u.setName("utente");
        u.setUsername("utente");
        u.setEmail("utente@gmail.com");
        u.setPassword("password");
        u.setUtente(true);
        ulist.add(u);
        u = new Utente();
        u.setName("gestore");
        u.setUsername("gestore");
        u.setEmail("gestore@gmail.com");
        u.setPassword("password");
        u.setUtente(false);
        ulist.add(u);
    }

    public Utente check(String mUsername, String mPassword) {
        Iterator i = ulist.iterator();

        while (i.hasNext()) {
            Utente u = (Utente) i.next();
            if (u.getUsername().equals(mUsername)) {
                if (u.getPassword().equals(mPassword)) {
                    return u;
                }
            }
        }
        return null;
    }

    public void add(Utente u) {
        ulist.add(u);
    }

    public boolean exist(String mUsername) {
        Iterator i = ulist.iterator();

        while (i.hasNext()) {
            Utente u = (Utente) i.next();
            if (u.getUsername().equals(mUsername)) {
                return true;
            }
        }
        return false;
    }
}
