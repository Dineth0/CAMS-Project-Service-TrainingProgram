package lk.ijse.eca.trainingprogramservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "training_programs")
public class TrainingProgram {
    @Id
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
