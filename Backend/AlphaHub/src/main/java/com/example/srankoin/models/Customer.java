package com.example.srankoin.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//Main Customer entity class
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String Customer;

    private String PhoneNumbers;

    private String Email;

    private String FullName;

    private String BillingAddress;

    private String ShippingAddress;

    @OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<TicketFake> tickets;


}
