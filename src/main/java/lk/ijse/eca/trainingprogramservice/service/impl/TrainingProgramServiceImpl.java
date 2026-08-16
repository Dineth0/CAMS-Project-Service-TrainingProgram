package lk.ijse.eca.trainingprogramservice.service.impl;

import lk.ijse.eca.trainingprogramservice.client.UserClient;
import lk.ijse.eca.trainingprogramservice.dto.TrainingProgramDTO;
import lk.ijse.eca.trainingprogramservice.entity.Role;
import lk.ijse.eca.trainingprogramservice.entity.TrainingProgram;
import lk.ijse.eca.trainingprogramservice.repo.TrainingProgramRepo;
import lk.ijse.eca.trainingprogramservice.service.TrainingProgramService;
import lk.ijse.eca.trainingprogramservice.util.VarList;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TrainingProgramServiceImpl implements TrainingProgramService {

    private final TrainingProgramRepo trainingProgramRepo;
    private final ModelMapper modelMapper;
    private final UserClient userClient;

    @Override
    public int addTrainingProgram(TrainingProgramDTO trainingProgramDTO, String email) {
        try {
            Role role = userClient.getUserRole(email);

            if (role != Role.ADMIN) {
                return 403;
            }
        } catch (Exception e) {
            return VarList.Not_Found;
        }
        TrainingProgram entity = modelMapper.map(trainingProgramDTO, TrainingProgram.class);

        if (entity.getTrainingProgramId() != null && trainingProgramRepo.existsById(entity.getTrainingProgramId())) {
            return VarList.Conflict;
        }

        try {
            TrainingProgram savedEntity = trainingProgramRepo.save(entity);

            trainingProgramDTO.setTrainingProgramId(savedEntity.getTrainingProgramId());

            return VarList.Created;
        } catch (Exception e) {
            return VarList.Internal_Server_Error;
        }



    }

    @Override
    public int updateTrainingProgram(TrainingProgramDTO trainingProgramDTO) {
        try{
            if (trainingProgramRepo.existsById(trainingProgramDTO.getTrainingProgramId())) {
                trainingProgramRepo.save(modelMapper.map(trainingProgramDTO, TrainingProgram.class));
                return VarList.Updated;
            }else {
                return VarList.Not_Found;
            }
        }catch (Exception e){
            return VarList.Internal_Server_Error;
        }

    }

    @Override
    public int deleteTrainingProgram(String id) {
        try{
            if (trainingProgramRepo.existsById(id)) {
                trainingProgramRepo.deleteById(id);
                return VarList.OK;
            }else {
                return VarList.Not_Found;
            }
        }catch (Exception e){
            return VarList.Internal_Server_Error;
        }

    }

    @Override
    public List<TrainingProgramDTO> getAllTrainingPrograms() {
        List<TrainingProgram> programList = trainingProgramRepo.findAll();
        if (programList.isEmpty()) {
            return new ArrayList<>();
        }
        return modelMapper.map(programList, new TypeToken<List<TrainingProgramDTO>>() {}.getType());
    }

    @Override
    public long getTrainingProgram() {
        return trainingProgramRepo.count();
    }

    @Override
    public TrainingProgramDTO searchTrainingProgram(String id) {
        Optional<TrainingProgram> program = trainingProgramRepo.findById(id);
        return program.map(trainingProgram -> modelMapper.map(trainingProgram, TrainingProgramDTO.class)).orElse(null);
    }
}