package ng.ourChemist.repositories;

import ng.ourChemist.models.Drug;
import ng.ourChemist.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrugRepository extends MongoRepository<Drug,String> {

    }


