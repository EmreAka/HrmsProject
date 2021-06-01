package kodlama.io.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "educations")
public class Education {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;
   @Column(name = "cv_id")
   private int cvId;
   @Column(name = "school_name")
   private String schoolName;
   @Column(name = "field")
   private String field;
   @Column(name = "begin_date")
   private LocalDate beginDate;
   @Column(name = "finish_date")
   private LocalDate finishDate;
   @Column(name = "created_date")
   private LocalDate createdDate;
}
