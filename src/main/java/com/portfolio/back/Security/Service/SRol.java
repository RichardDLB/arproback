
package com.portfolio.back.Security.Service;

import com.portfolio.back.Security.Entity.Rol;
import com.portfolio.back.Security.Enums.RolNombre;
import com.portfolio.back.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRol {
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre (RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
    
    
    
    
}
