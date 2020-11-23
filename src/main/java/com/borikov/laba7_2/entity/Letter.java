package com.borikov.laba7_2.entity;

import java.time.LocalDate;

public class Letter {
    private Long letterId;
    private String theme;
    private String text;
    private LocalDate departureDate;
    private long senderId;
    private long receiverId;

    public Letter(Long letterId, String theme, String text, LocalDate departureDate, long senderId, long receiverId) {
        this.letterId = letterId;
        this.theme = theme;
        this.text = text;
        this.departureDate = departureDate;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public Long getLetterId() {
        return letterId;
    }

    public void setLetterId(Long letterId) {
        this.letterId = letterId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Letter letter = (Letter) o;
        if (senderId != letter.senderId) {
            return false;
        }
        if (receiverId != letter.receiverId) {
            return false;
        }
        if (letterId != null ? !letterId.equals(letter.letterId) : letter.letterId != null) {
            return false;
        }
        if (theme != null ? !theme.equals(letter.theme) : letter.theme != null) {
            return false;
        }
        if (text != null ? !text.equals(letter.text) : letter.text != null) {
            return false;
        }
        return departureDate != null ? departureDate.equals(letter.departureDate) : letter.departureDate == null;
    }

    @Override
    public int hashCode() {
        int hashcode = letterId != null ? letterId.hashCode() : 0;
        hashcode = 31 * hashcode + (theme != null ? theme.hashCode() : 0);
        hashcode = 31 * hashcode + (text != null ? text.hashCode() : 0);
        hashcode = 31 * hashcode + (departureDate != null ? departureDate.hashCode() : 0);
        hashcode = 31 * hashcode + (int) (senderId ^ (senderId >>> 32));
        hashcode = 31 * hashcode + (int) (receiverId ^ (receiverId >>> 32));
        return hashcode;
    }

    @Override
    public String toString() {
        final StringBuilder stringRepresentation = new StringBuilder("Letter{");
        stringRepresentation.append("letterId=").append(letterId);
        stringRepresentation.append(", theme='").append(theme).append('\'');
        stringRepresentation.append(", text='").append(text).append('\'');
        stringRepresentation.append(", departureDate=").append(departureDate);
        stringRepresentation.append(", senderId=").append(senderId);
        stringRepresentation.append(", receiverId=").append(receiverId);
        stringRepresentation.append('}');
        return stringRepresentation.toString();
    }
}
