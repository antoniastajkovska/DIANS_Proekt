package mk.ukim.finki.dians.mapart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA entity annotation, specifying the table name
@Entity
@Table(name = "galleries")
// Lombok annotations for generating getters, setters, toString, etc.
@Data
// Lombok annotation for generating an all-args constructor
@AllArgsConstructor
// Lombok annotation for generating a no-args constructor
@NoArgsConstructor
// Jackson annotation to ignore unknown properties during deserialization
@JsonIgnoreProperties(ignoreUnknown = true)
public class Gallery {

    // JPA annotation for specifying the primary key
    @Id
    // JPA annotation for automatic generation of the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Gallery name
    private String name;

    // Jackson annotation to map the JSON property "addr:postcode" to the corresponding field
    @JsonProperty("addr:postcode")
    // JPA annotation for mapping to a database column
    @Column(name = "addr:postcode")
    private String addrPostcode;

    // Jackson annotation to map the JSON property "addr:street" to the corresponding field
    @JsonProperty("addr:street")
    // JPA annotation for mapping to a database column
    @Column(name = "addr:street")
    private String addressStreet;

    // Gallery email
    private String email;

    // Gallery phone
    private String phone;

    // Gallery latitude
    private Double lat;

    // Gallery longitude
    private Double lon;

    // Jackson annotation to map the JSON property "addr:housenumber" to the corresponding field
    @JsonProperty("addr:housenumber")
    // JPA annotation for mapping to a database column
    @Column(name = "addr:housenumber")
    private String addressHousenumber;

    // Jackson annotation to map the JSON property "opening_hours" to the corresponding field
    @JsonProperty("opening_hours")
    // JPA annotation for mapping to a database column
    @Column(name = "opening_hours")
    private String openingHours;
}