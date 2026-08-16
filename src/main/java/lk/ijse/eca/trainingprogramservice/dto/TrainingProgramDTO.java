package lk.ijse.eca.trainingprogramservice.dto;

import lk.ijse.eca.trainingprogramservice.entity.ProgramStatus;
import lk.ijse.eca.trainingprogramservice.entity.SkillLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingProgramDTO {
    private String trainingProgramId;

    private String programName;
    private String description;
    private SkillLevel skillLevel;
    private Integer durationWeeks;
    private Integer sessionPerWeek;
    private Double fee;
    private LocalDate startDate;
    private Integer maximumPlayers;
    private String location;
    private ProgramStatus status;
}
