package com.platzi.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {
    @Id
    @Column(name = "id_item", nullable = false)
    private Integer idItem;
    @Id
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;
    @Column(columnDefinition = "Decimal(2,1)", nullable = false)
    private Double quantity;
    @Column(columnDefinition = "Decimal(5,2)", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
    private PizzaEntity pizza;
}
