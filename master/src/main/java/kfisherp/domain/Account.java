package kfisherp.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import kfisherp.MasterApplication;
import lombok.Data;

@Entity
@Table(name = "Account_table")
@Data
//<<< DDD / Aggregate Root
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountName;

    private String representative;

    private String businessRegistrationNumber;

    @Embedded
    private Address address;

    private String industry;

    private String category;

    private String customerType;

    public static AccountRepository repository() {
        AccountRepository accountRepository = MasterApplication.applicationContext.getBean(
            AccountRepository.class
        );
        return accountRepository;
    }
}
//>>> DDD / Aggregate Root
