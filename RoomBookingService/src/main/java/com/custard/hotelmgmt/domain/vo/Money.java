package com.custard.hotelmgmt.domain.vo;

import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
public class Money {

    @Positive
    private final BigDecimal amount;

    public Money(BigDecimal amount){
        validateAmount(amount);
        this.amount = amount;
    }

    public Money add(Money otherMoney){
        validateAmount(otherMoney.amount);
        return new Money(this.amount.add(otherMoney.amount)); 
    }

    public Money substract(Money otherMoney){
        BigDecimal result = this.amount.subtract(otherMoney.amount);
        validateAmount(result);
        return new Money(result);
    }

    public void validateAmount(BigDecimal amount){
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalStateException("Money should not be less than zero");
        }
    }

    public boolean validateAmount(){
        return (amount == null || amount.compareTo(BigDecimal.ZERO) < 0);
    }

   

}
