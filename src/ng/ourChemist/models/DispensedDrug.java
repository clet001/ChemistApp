package ng.ourChemist.models;

import lombok.Data;

@Data
public class DispensedDrug {
    private int totalPrice;
    private Drug drug;
    private int quantity;
    private String id;


}
