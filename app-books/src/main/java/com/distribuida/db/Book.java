package com.distribuida.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    public static final Long serialVersionUID = 1L;
    private Long id;
    private Author author;
    private String isbn;
    private String title;
    private BigDecimal price;
}
