package com.dev.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDto {
    private String orderId;
    private String name;
    private String email;
    private long amount;

//
//    private PaymentRequestDto(String item, long amount){
//        this.item = item;
//        this.amount = amount;
//    }
//    public static Builder builder(){
//        return new Builder();
//    }
//    public static class Builder{
//        private String item;
//        private long amount;
//
//        public PaymentRequestDto build(){
//            return new PaymentRequestDto(this.item, this.amount);
//        }
//
//        public Builder setItem(String item){
//            this.item = item;
//            return this;
//        }
//
//        public Builder setAmount(long amount){
//            this.amount = amount;
//            return this;
//        }
//    }

}
