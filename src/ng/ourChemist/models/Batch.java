package ng.ourChemist.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.YearMonth;
@Data
@Document
public class Batch {
    private int quantityLeft;
    private int costPrice;
    private int purchaseQuantity;

    @Id
    private String id;


    private int drugId;
    private LocalDate purchaseDate;
    private YearMonth expiryYearMonth;

}

