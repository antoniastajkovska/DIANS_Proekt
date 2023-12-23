package mk.ukim.finki.dians.mapart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "galleries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonProperty("addr:postcode")
    @Column(name = "addr:postcode")
    private String addrPostcode;

    @JsonProperty("addr:street")
    @Column(name = "addr:street")
    private String addressStreet;

    private String email;

    private String phone;

    private Double lat;

    private Double lon;

    @JsonProperty("addr:housenumber")
    @Column(name = "addr:housenumber")
    private String addressHousenumber;

    @JsonProperty("opening_hours")
    @Column(name = "opening_hours")
    private String openingHours;
}
