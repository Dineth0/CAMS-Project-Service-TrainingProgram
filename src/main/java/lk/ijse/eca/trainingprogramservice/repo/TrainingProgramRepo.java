package lk.ijse.eca.trainingprogramservice.repo;

import lk.ijse.eca.trainingprogramservice.entity.TrainingProgram;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainingProgramRepo extends MongoRepository<TrainingProgram, String> {
}
