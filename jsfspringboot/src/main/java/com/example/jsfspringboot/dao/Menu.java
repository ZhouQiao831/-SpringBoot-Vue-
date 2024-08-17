package com.example.jsfspringboot.dao;

import lombok.Data;

@Data
public class Menu {
    private int id;
    private String name;
    private String path;
    private String type;
}
