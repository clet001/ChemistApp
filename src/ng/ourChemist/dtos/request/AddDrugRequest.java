package ng.ourChemist.dtos.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class AddDrugRequest {

    private String brand;
    private String name;
    private int price;
    private int quantity;
    private int costPrice;
    private int purchaseQuantity;
    private LocalDate expiryDate;



}
