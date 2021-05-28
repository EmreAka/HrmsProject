package kodlama.io.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
//    @Column(name = "job_position_id")
//    private int jobPositionId; //this is going to be removed here...
    @Column(name = "description")
    private String description;
//    @Column(name = "city_id")
//    private int cityId; //this is going to be removed here...
    @Column(name = "max_salary")
    private int maxSalary;
    @Column(name = "min_salary")
    private int minSalary;
    @Column(name = "open_positions")
    private int openPositions;
    @Column(name = "latest_apply_time")
    private LocalDate latestApplyTime;
    @Column(name = "is_active")
    private boolean active;
    @Column(name = "created_time")
    @Temporal(TemporalType.DATE)
    private Date createdTime;
//    @Column(name = "employer_id")
//    private int employerId; //this is going to be removed here...
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
