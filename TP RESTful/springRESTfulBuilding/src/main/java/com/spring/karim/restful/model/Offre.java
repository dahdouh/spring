
package com.spring.karim.restful.model;

import lombok.Data;

@Data
public class Offre {

    protected String id;
    protected String nomHotel;
    protected String typeChambre;
    protected String dateDisponibilite;
    protected double prix;

}
