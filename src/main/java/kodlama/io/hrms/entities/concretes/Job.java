package kodlama.io.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    @NotBlank
    @NotEmpty
    private String description;
    @Column(name = "max_salary")
    private int maxSalary;
    @Column(name = "min_salary")
    private int minSalary;
    @Column(name = "open_positions")
    @NotBlank
    @NotEmpty
    private int openPositions;
    @Column(name = "latest_apply_time")
    @NotBlank
    @NotEmpty
    private LocalDate latestApplyTime;
    @Column(name = "is_active")
    @NotBlank
    @NotEmpty
    private boolean active;
    @Column(name = "created_time")
    @NotBlank
    @NotEmpty
    @Temporal(TemporalType.DATE)
    private Date createdTime;

    //many to one
    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
}
