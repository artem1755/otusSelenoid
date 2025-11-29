package ru.sb.model;

import lombok.Data;

@Data
public class UserModel {
  private String name;
  private String cource;
  private String email;
  private int age;
  private int id;

  public UserModel() {
  }

  public UserModel(int id,String name, String cource, String email, int age) {
    this.name = name;
    this.cource = cource;
    this.email = email;
    this.age = age;
    this.id = id;
  }
}
