package com.platzi.pizza.persistence.entity;

import com.platzi.pizza.persistence.audit.AuditPizzaListener;
import com.platzi.pizza.persistence.audit.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Table(name = "pizza")
@EntityListeners({
        AuditableEntity.class,
        AuditPizzaListener.class,
        AuditingEntityListener.class
})
@Getter
@Setter
@NoArgsConstructor
public class PizzaEntity extends AuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(name = "name", unique = true, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "price", nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @Column(name = "vegetarian", columnDefinition = "TINYINT")
    private Boolean vegetarian;

    @Column(name = "vegan", columnDefinition = "TINYINT")
    private Boolean vegan;

    @Column(name = "available", columnDefinition = "TINYINT", nullable = false)
    private Boolean available;

    @Override
    public String toString() {
        return "PizzaEntity{" +
                "idPizza=" + idPizza +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", available=" + available +
                '}';
    }
}
