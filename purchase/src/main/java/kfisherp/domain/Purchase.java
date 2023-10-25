package kfisherp.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import kfisherp.PurchaseApplication;
import kfisherp.domain.PurchaseCreated;
import lombok.Data;

@Entity
@Table(name = "Purchase_table")
@Data
//<<< DDD / Aggregate Root
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseNo;

    private String purchaseType;

    private Date purchaseDate;

    private Date warehouseArrivalDate;

    private Date storageFeePaymanetDate;

    private Boolean storageFeePaymentStatus;

    private String mainShipName;

    private String productName;

    @Embedded
    private AccountId accountId;

    @ElementCollection
    private List<PurchaseDetail> purchaseDetails;

    @PostPersist
    public void onPostPersist() {
        PurchaseCreated purchaseCreated = new PurchaseCreated(this);
        purchaseCreated.publishAfterCommit();
    }

    public static PurchaseRepository repository() {
        PurchaseRepository purchaseRepository = PurchaseApplication.applicationContext.getBean(
            PurchaseRepository.class
        );
        return purchaseRepository;
    }

    //<<< Clean Arch / Port Method
    public void sale(SaleCommand saleCommand) {
        //implement business logic here:

        FishSold fishSold = new FishSold(this);
        fishSold.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
