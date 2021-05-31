package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "employer_id")
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobs"})
public class Employer extends User{
    @Column(name = "company_name")
    @NotBlank
    @NotEmpty
    private String companyName;
    @Column(name = "web_site")
    @NotBlank
    @NotEmpty
    private String webSite;
    @Column(name = "phone_number")
    @NotBlank
    @NotEmpty
    private String phoneNumber;
    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<Job> jobs;
}
