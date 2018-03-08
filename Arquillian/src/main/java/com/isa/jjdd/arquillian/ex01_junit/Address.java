package com.isa.jjdd.arquillian.ex01_junit;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Address {

    String city;

    String street;

    String houseNumber;

    String flatNumber;

}
