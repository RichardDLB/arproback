package com.portfolio.back.Security;

import com.portfolio.back.Security.Entity.Rol;
import com.portfolio.back.Security.Entity.Usuario;
import com.portfolio.back.Security.Enums.RolNombre;
import com.portfolio.back.Security.Repository.IRolRepository;
import com.portfolio.back.Security.Repository.IUsuarioRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityDataInitializer implements ApplicationRunner {

    private final IRolRepository rolRepository;
    private final IUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final String adminName;
    private final String adminUsername;
    private final String adminEmail;
    private final String adminPassword;

    public SecurityDataInitializer(
            IRolRepository rolRepository,
            IUsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            @Value("${app.admin.name:}") String adminName,
            @Value("${app.admin.username:}") String adminUsername,
            @Value("${app.admin.email:}") String adminEmail,
            @Value("${app.admin.password:}") String adminPassword) {
        this.rolRepository = rolRepository;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.adminName = adminName;
        this.adminUsername = adminUsername;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    @Override
    public void run(ApplicationArguments args) {
        for (RolNombre roleName : RolNombre.values()) {
            if (!rolRepository.findByRolNombre(roleName).isPresent()) {
                rolRepository.save(new Rol(roleName));
            }
        }

        boolean noAdminConfigured = isBlank(adminName)
                && isBlank(adminUsername)
                && isBlank(adminEmail)
                && isBlank(adminPassword);
        if (noAdminConfigured) {
            return;
        }
        if (isBlank(adminName) || isBlank(adminUsername) || isBlank(adminEmail)
                || isBlank(adminPassword) || adminPassword.length() < 12) {
            throw new IllegalStateException(
                    "Configure APP_ADMIN_NAME, APP_ADMIN_USERNAME, APP_ADMIN_EMAIL y "
                    + "APP_ADMIN_PASSWORD (mínimo 12 caracteres)");
        }
        if (usuarioRepository.existsByNombreUsuario(adminUsername)) {
            return;
        }

        Rol adminRole = rolRepository.findByRolNombre(RolNombre.ROLE_ADMIN)
                .orElseThrow(() -> new IllegalStateException("No está inicializado ROLE_ADMIN"));
        Usuario admin = new Usuario(adminName, adminUsername, adminEmail,
                passwordEncoder.encode(adminPassword));
        admin.setRoles(Collections.singleton(adminRole));
        usuarioRepository.save(admin);
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}