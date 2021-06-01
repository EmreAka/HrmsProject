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
@Table(name = "foreign_languages")
public class ForeignLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "cv_id")
    private int cvId;
    @Column(name = "language_name")
    private String languageName;
    @Column(name = "language_level")
    private char languageLevel;
    @Column(name = "created_date")
    private LocalDate createdDate;
}
