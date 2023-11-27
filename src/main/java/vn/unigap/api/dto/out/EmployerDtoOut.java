package vn.unigap.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.api.entity.jpa.Employer;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployerDtoOut {
    private Long id;
    private String email;
    private String name;
    private Integer provinceid;
    private String description;

    public static EmployerDtoOut from(Employer emp){
        return EmployerDtoOut.builder()
                .id(emp.getId())
                .email(emp.getEmail())
                .name(emp.getName())
                .provinceid(emp.getProvince())
                .description(emp.getDescription())
                .build();


    }

}
