package ng.ourChemist.repositories;

import ng.ourChemist.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DispensedDrugsRepository extends MongoRepository<User, String> {

}
