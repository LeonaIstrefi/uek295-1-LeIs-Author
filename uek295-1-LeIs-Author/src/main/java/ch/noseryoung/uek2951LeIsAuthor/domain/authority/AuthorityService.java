package ch.noseryoung.uek2951LeIsAuthor.domain.authority;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

   @Autowired
    AuthorityRepository repository;
}
