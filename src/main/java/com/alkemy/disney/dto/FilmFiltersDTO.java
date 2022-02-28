package com.alkemy.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class FilmFiltersDTO {
    private String name;
    private String genreId;
    private String order;

    public boolean isAsc(){return order.compareToIgnoreCase("ASC")==0;}
    public boolean isDesc(){return order.compareToIgnoreCase("DESC")==0;}
}
