package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobs"})
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "position")
    @NotBlank
    @NotEmpty
    private String position;

    @OneToMany(mappedBy = "jobPosition")
    @JsonIgnore
    private List<Job> jobs;

    @OneToMany(mappedBy = "cv")
    @JsonIgnore
    private List<JobExperience> jobExperiences;
}
