package com.nbchand.mbt.pojo;

import lombok.*;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankRequest {
    private Integer id;
    private String name;
    private String location;
    private List<Integer> customers;
}
