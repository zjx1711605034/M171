package com.example.yt.libiarymessage.EntryBeans;

public class Zhuche {
    private  String userpasw;
    private  String username;



    public Zhuche(String userpasw, String username) {
        this.userpasw = userpasw;
        this.username = username;
    }

    public String getUserpasw() {
        return userpasw;
    }

    public void setUserpasw(String userpasw) {
        this.userpasw = userpasw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Zhuche() {
    }

    @Override
    public String toString() {
        return "Zhuche{" +
                "userpasw='" + userpasw + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
