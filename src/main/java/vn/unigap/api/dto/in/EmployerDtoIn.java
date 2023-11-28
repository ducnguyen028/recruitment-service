package vn.unigap.api.dto.in;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.unigap.common.Common;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployerDtoIn {
    @NotEmpty
    @Size(max = 255, message = "Email should not be greater than 255")
    @Email
    private String email;

    @NotEmpty
    @Size(max = 255, message = "Name should not be greater than 255")
    private String name;

    @NotNull
    private int provinceId;

    private String description;
    public String getEmail() {
        return Common.toLowerCase(email);
    }
}
