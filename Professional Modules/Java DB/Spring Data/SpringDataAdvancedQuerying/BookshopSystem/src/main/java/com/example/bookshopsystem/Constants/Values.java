package com.example.bookshopsystem.Constants;

import com.example.bookshopsystem.entities.enums.EditionTypes;

import java.math.BigDecimal;

public enum Values {
    ;
    public static final EditionTypes EDITION_TYPE =EditionTypes.GOLD;
    public static final Integer NUMBER_OF_COPIES =5000;
    public static final BigDecimal LOWER_PRICE =BigDecimal.valueOf(5);
    public static final BigDecimal UPPER_PRICE=BigDecimal.valueOf(40);
}
