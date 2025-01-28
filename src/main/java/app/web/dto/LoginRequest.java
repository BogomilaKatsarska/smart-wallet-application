package app.web.dto;

import app.user.model.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    @Size(min=6, message = "username must be at least 6 symbols.")
    private String username;

    @Size(min = 6, message = "password must be at least 6 symbols.")
    private String password;

    @NotNull
    private Country country;
}
