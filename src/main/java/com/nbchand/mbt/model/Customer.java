package com.nbchand.mbt.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(
        columnNames = {"account_number"},
        name = "UK_Customer_Account_Number"
))
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer_SEQ_GEN")
    @SequenceGenerator(name = "Customer_SEQ_GEN", sequenceName = "Customer_SEQ", allocationSize = 1)
    private Integer id;

    private String name;
    private String location;

    @Column(name = "account_number")
    private String accountNumber;
}
