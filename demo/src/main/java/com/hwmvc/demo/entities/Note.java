package com.hwmvc.demo.entities;


import lombok.Data;

import java.util.UUID;

@Data
public class Note {
    private UUID id;
    private String title;
    private String content;
}
