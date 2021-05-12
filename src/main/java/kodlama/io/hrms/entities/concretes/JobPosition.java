package kodlama.io.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_positions")
public class JobPosition {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "job_position")
    private String position;
}
