package lk.ijse.eca.trainingprogramservice.controller;

import jakarta.validation.Valid;
import lk.ijse.eca.trainingprogramservice.dto.ResponseDTO;
import lk.ijse.eca.trainingprogramservice.dto.TrainingProgramDTO;
import lk.ijse.eca.trainingprogramservice.service.TrainingProgramService;
import lk.ijse.eca.trainingprogramservice.util.VarList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/trainingProgram")

@RequiredArgsConstructor
public class TrainingProgramController {
    private final TrainingProgramService trainingProgramService;

    @PostMapping("/addTrainingProgram")
    public ResponseEntity<ResponseDTO> addTrainingProgram(@Valid @RequestBody TrainingProgramDTO trainingProgramDTO, @RequestHeader("X-User-Email") String email) {
        try{
            int response = trainingProgramService.addTrainingProgram(trainingProgramDTO, email);
            switch (response) {
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Training Program Created", trainingProgramDTO));
                }
                case VarList.Conflict -> {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body(new ResponseDTO(VarList.Conflict, "Training Program Already exists", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body(new ResponseDTO(VarList.Internal_Server_Error, "Error While Saving", null));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }


    }
    @PutMapping("/updateTrainingProgram/{trainingProgramId}")
    public ResponseEntity<ResponseDTO> updateTrainingProgram(@PathVariable String trainingProgramId, @RequestBody TrainingProgramDTO trainingProgramDTO) {
        try{
            trainingProgramDTO.setTrainingProgramId(trainingProgramId);
            int response = trainingProgramService.updateTrainingProgram(trainingProgramDTO);

            switch (response) {
                case VarList.Updated -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Training Program Updated", trainingProgramDTO));
                }
                case VarList.Not_Found -> {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(new ResponseDTO(VarList.Not_Found, "Training Program Not found", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Internal_Server_Error, "Error while updating", null));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @GetMapping("/getAllTrainingPrograms")
    public ResponseEntity<ResponseDTO> getAllTrainingPrograms() {
        try{
            List<TrainingProgramDTO> courses = trainingProgramService.getAllTrainingPrograms();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(VarList.OK,"success", courses));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @DeleteMapping("/deleteTrainingProgram/{id}")
    public ResponseEntity<ResponseDTO> deleteTrainingProgram(@PathVariable String id) {
        try{
            int response = trainingProgramService.deleteTrainingProgram(id);
            if(response == VarList.OK){
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseDTO(VarList.OK, "Training Program Deleted", null));
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseDTO(VarList.Not_Found, "Training Program Not Found", null));
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }
    @GetMapping("/count")
    public ResponseEntity<ResponseDTO> getCountTrainingProgram() {
        try {
            long count = trainingProgramService.getTrainingProgram();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(VarList.OK, "Success", count));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getTrainingProgramById(@PathVariable String id) {
        try {
            TrainingProgramDTO programDTO = trainingProgramService.searchTrainingProgram(id);
            if (programDTO != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseDTO(VarList.OK, "Success", programDTO));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseDTO(VarList.Not_Found, "Training Program Not Found", null));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

}
