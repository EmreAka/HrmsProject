package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "employee_id")
@Table(name = "employees")
public class Employee extends User{
    @Column(name = "first_name")
    @NotBlank
    @NotEmpty
    private String firstName;
    @Column(name = "last_name")
    @NotBlank
    @NotEmpty
    private String lastName;
    @Column(name = "national_id")
    @NotBlank
    @NotEmpty
    private String nationalId;
    @Column(name = "birth_year")
    @NotNull
    private LocalDate birthYear;

    @OneToMany(mappedBy = "employee")
    private List<Cv> cvs;
}
