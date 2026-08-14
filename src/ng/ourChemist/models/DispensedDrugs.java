package ng.ourChemist.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
public class DispensedDrugs {
    private User dispensedBy;
    private List<DispensedDrug> dispensedDrugs = new ArrayList<>();
    private String id;
    private LocalDate dispensedDateTime;

}
