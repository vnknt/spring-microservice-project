package com.ingbootcamp.servicecommon.contracts;

import lombok.Data;

import java.io.Serializable;

@Data
public class Notification implements Serializable {
    private String title;
    private String description;
}
