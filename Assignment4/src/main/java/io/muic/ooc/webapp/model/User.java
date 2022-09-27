package io.muic.ooc.webapp.model;



public class User {
    private String username;
    private long id;
    private String password;
    private String displayName;

    public User() {
    }

    public User(long id, String username, String password, String displayName) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.displayName = displayName;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
