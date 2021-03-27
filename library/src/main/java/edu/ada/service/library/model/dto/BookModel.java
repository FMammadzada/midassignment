package edu.ada.service.library.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@Data
public class BookModel implements Serializable {
    private String name;
    private int userId;

}
