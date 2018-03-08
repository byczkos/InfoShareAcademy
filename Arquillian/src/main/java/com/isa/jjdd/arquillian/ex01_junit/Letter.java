package com.isa.jjdd.arquillian.ex01_junit;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Letter {
    Address sender;

    Address receiver;

    Envelope size;

}
