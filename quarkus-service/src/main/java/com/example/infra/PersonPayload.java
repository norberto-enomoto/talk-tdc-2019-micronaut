package com.example.infra;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PersonPayload {

  @NotBlank
  private String name;

  @NotNull
  @Positive
  private Integer age;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonPayload that = (PersonPayload) o;
    return Objects.equals(name, that.name) &&
        Objects.equals(age, that.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }

  @Override
  public String toString() {
    return "PersonPayload{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

}