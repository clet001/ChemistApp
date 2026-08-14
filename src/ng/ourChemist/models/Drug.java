package ng.ourChemist.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data

public class Drug {
    private int name;
    @Id
    private String id;
    private String brand;
    private LocalDateTime expiryDate;
    private int price;

}
