package org.example.dernekwebsitesi.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@DiscriminatorValue("DUYURU")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Duyuru extends Etkinlik{

    private String resimUrl;

}
