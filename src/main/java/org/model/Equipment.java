package org.model;

import java.util.Date;

public class Equipment extends Resource{
    public Equipment(Long id, String title, String type, String provider, Date acquisitionDate, String picture, String quantity, Boolean availability) {
        super(id, title, type, provider, acquisitionDate, picture, quantity, availability);
    }

    public Equipment() {
        super();
    }
}
