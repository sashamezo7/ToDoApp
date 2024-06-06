package org.example.maxpetapi.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.maxpetapi.entity.UsersEntity;

public class Sarcina {

    private int id;


    private String cerinta;

    private String username;

    private int activ;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }


    public String getCerinta() {
        return cerinta;
    }

    public int getActiv() {
        return activ;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setCerinta(String cerinta) {
        this.cerinta = cerinta;
    }

    public void setActiv(int activ) {
        this.activ = activ;
    }
}
