package lk.ijse.eca.trainingprogramservice.service;

import lk.ijse.eca.trainingprogramservice.dto.TrainingProgramDTO;

import java.util.List;

public interface TrainingProgramService {
    int addTrainingProgram(TrainingProgramDTO trainingProgramDTO,String email);
    int updateTrainingProgram(TrainingProgramDTO trainingProgramDTO);
    int deleteTrainingProgram(String id);
    List<TrainingProgramDTO> getAllTrainingPrograms();
    public TrainingProgramDTO searchTrainingProgram(String id);

    long getTrainingProgram();

}
