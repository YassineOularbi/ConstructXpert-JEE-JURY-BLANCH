package org.model;

import java.util.Date;

public class Vehicle extends Resource{
    public Vehicle(Long id, String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability) {
        super(id, title, type, provider, acquisitionDate, picture, quantity, availability);
    }

    public Vehicle() {
        super();
    }
}
