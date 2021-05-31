package kodlama.io.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

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
    private LocalDate birthYear;
}
