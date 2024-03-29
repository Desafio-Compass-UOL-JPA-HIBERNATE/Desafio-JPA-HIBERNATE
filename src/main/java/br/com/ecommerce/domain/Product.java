package br.com.ecommerce.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *  Product Class
 */

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name" , nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "value" , nullable = false, scale = 2)
    private Double value;

    @NotNull
    @Size(min = 10)
    @Column(name = "description")
    private String description;


    public Product(){

    }


    public Product(String name, Double value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product\n{" + "\n  \"id\": " + id + ",\n  \"name\": \"" + name + "\",\n  \"value\": " + value + ",\n  \"description\": \"" + description + "\"\n}\n";
        //essa formatação é semelhante a do JSON
    }
}
