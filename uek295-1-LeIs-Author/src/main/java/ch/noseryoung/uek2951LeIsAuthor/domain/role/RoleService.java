package ch.noseryoung.uek2951LeIsAuthor.domain.role;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository repository;
}
