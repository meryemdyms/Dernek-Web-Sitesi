package org.example.dernekwebsitesi.jwt;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dernekwebsitesi.model.Role;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    @NotEmpty
    private String username;

    @NotEmpty
   private String password;

    @NotNull
    private Role role;
}

