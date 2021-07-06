package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


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
    @NotNull
    private int openPositions;
    @Column(name = "latest_apply_time")
    @NotNull
    private LocalDate latestApplyTime;
    @Column(name = "is_active")
    @NotNull
    private boolean active;
    @Column(name = "created_time")
    @CreationTimestamp
    private LocalDate createdTime;
    @Column(name = "is_validated")
    @NotNull
    private boolean validate;

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

    @ManyToOne()
    @JoinColumn(name = "work_place_id")
    private WorkPlace workPlace;

    @ManyToOne()
    @JoinColumn(name = "work_time_id")
    private WorkTime workTime;

    @OneToMany(mappedBy = "job")
    @JsonIgnore
    private List<Favorite> favorite;
}
