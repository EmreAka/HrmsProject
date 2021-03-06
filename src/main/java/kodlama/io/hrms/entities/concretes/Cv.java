package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cvs")
public class Cv {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;
   @Column(name = "photo")
   private String photo;
   @Column(name = "github_link")
   private String githubLink;
   @Column(name = "linkedin_link")
   private String linkedinLink;
   @Column(name = "description")
   private String description;
   @Column(name = "created_date")
   @CreationTimestamp
   private LocalDate createdDate;
   @Column(name = "is_active")
   @NotNull
   private boolean active;
   @UpdateTimestamp
   @Column(name = "latest_update_date")
   private LocalDate latestUpdateDate;

   @ManyToOne
   @JoinColumn(name = "employee_id")
   private Employee employee;

   @OneToMany(mappedBy = "cv")
   private List<Education> educations;

   @OneToMany(mappedBy = "cv")
   private List<ForeignLanguage> foreignLanguages;

   @OneToMany(mappedBy = "cv")
   private List<JobExperience> jobExperiences;

   @OneToMany(mappedBy = "cv")
   private List<TechnologyAndProgrammingLanguage> technologyAndProgrammingLanguages;

}
