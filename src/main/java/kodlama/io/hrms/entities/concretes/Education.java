package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @ManyToOne
   @JoinColumn(name = "cv_id")
   private Cv cv;
}
