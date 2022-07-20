package com.nbchand.mbt.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Bank_SEQ_GEN")
    @SequenceGenerator(name = "Bank_SEQ_GEN", sequenceName = "Bank_SEQ", allocationSize = 1)
    private Integer id;

    private String name;
    private String location;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "bank_id", foreignKey = @ForeignKey(name = "FK_Customer_Bank"))
    private List<Customer> customers;
}
