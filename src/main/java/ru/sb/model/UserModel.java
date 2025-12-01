package ru.sb.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
  private int id;
  private String name;
  private String cource;
  private String email;
  private int age;
}