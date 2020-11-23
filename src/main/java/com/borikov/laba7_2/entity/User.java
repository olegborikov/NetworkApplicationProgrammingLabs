package com.borikov.laba7_2.entity;

import java.time.LocalDate;

public class User {
    private Long userId;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;

    public User(Long userId, String name, String surname, String patronymic, LocalDate birthday) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) {
            return false;
        }
        if (patronymic != null ? !patronymic.equals(user.patronymic) : user.patronymic != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    @Override
    public int hashCode() {
        int hashcode = userId != null ? userId.hashCode() : 0;
        hashcode = 31 * hashcode + (name != null ? name.hashCode() : 0);
        hashcode = 31 * hashcode + (surname != null ? surname.hashCode() : 0);
        hashcode = 31 * hashcode + (patronymic != null ? patronymic.hashCode() : 0);
        hashcode = 31 * hashcode + (birthday != null ? birthday.hashCode() : 0);
        return hashcode;
    }

    @Override
    public String toString() {
        final StringBuilder stringRepresentation = new StringBuilder("User{");
        stringRepresentation.append("userId=").append(userId);
        stringRepresentation.append(", name='").append(name).append('\'');
        stringRepresentation.append(", surname='").append(surname).append('\'');
        stringRepresentation.append(", patronymic='").append(patronymic).append('\'');
        stringRepresentation.append(", birthday=").append(birthday);
        stringRepresentation.append('}');
        return stringRepresentation.toString();
    }
}
