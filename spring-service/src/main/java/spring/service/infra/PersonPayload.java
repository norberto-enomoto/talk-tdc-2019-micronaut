package spring.service.infra;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.service.domain.Person;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonPayload {

  @NotBlank
  private String name;

  @NotNull
  @Positive
  private Integer age;

  @JsonIgnore
  public Person toPerson() {
    return Person.builder()
        .name(getName())
        .age(getAge())
        .build();
  }

}