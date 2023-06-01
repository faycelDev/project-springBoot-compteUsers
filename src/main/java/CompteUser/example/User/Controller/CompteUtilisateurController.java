package CompteUser.example.User.Controller;

import CompteUser.example.User.models.CompteUtilisateur;
import CompteUser.example.User.models.Utilisateur;
import CompteUser.example.User.repository.CompteUtilisateurRepository;
import CompteUser.example.User.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CompteUtilisateurController {

    @Autowired
    private CompteUtilisateurRepository compteUtilisateurRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping(value = "/compte")
    public void getFindAll(){

           compteUtilisateurRepository.findAll();
    }

    @GetMapping(value = "/compte/{id}")
    public void getFindById(@PathVariable ("id") Integer id){

        compteUtilisateurRepository.findById(id);
    }

    @PostMapping(value = "/compte")
    public void create (@RequestBody CompteUtilisateur compteUtilisateur){
        compteUtilisateurRepository.save(compteUtilisateur);
    }

    @PutMapping(value = "/compte/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody CompteUtilisateur compteUtilisateur){

        var compte = compteUtilisateurRepository.findById(id);
        if(compte.isPresent()){
            compteUtilisateur.setUtilisateur();
            compteUtilisateurRepository.save(compteUtilisateur);

        }
    }
}
