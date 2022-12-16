package jpabook.jpashop.domain.item;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
