package org.example.dernekwebsitesi.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("HABER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Haber extends Etkinlik{

    private String haberLinki;

}
