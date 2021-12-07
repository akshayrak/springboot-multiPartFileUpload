package com.example.demo.beans;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.context.annotation.Bean;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    private int id;
    private String channel;
    private String name;
    private int age;
    @Lob
    private byte[] files;
    public Employee()
    {

    }
    // public Employee(int id, String channel, String name, int age ) {
    //     this.id = id;
    //     this.channel = channel;
    //     this.name = name;
    //     this.age = age;
       
    // }
    public Employee(int id, String channel, String name, int age) {
        this.id = id;
        this.channel = channel;
        this.name = name;
        this.age = age;
        //this.files = files;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public byte[] getFiles() {
        return files;
    }

    public void setFiles(byte[] files) {
        this.files = files;
    }
    
}
