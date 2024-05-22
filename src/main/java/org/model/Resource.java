package org.model;

import java.util.Date;

public class Resource {
    private Long id;
    private String title;
    private String type;
    private String provider;
    private Date acquisitionDate;
    private String picture;
    private String quantity;
    private Boolean availability;

    public Resource(Long id, String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.provider = provider;
        this.acquisitionDate = acquisitionDate;
        this.picture = picture;
        this.quantity = quantity;
        this.availability = availability;
    }

    public Resource() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", provider='" + provider + '\'' +
                ", acquisitionDate=" + acquisitionDate +
                ", picture='" + picture + '\'' +
                ", quantity='" + quantity + '\'' +
                ", availability=" + availability +
                '}';
    }
}

