package kfisherp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SaleCommand {

    private String itemId;
    private Integer qty;
}