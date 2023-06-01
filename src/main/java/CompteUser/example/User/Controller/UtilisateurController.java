package CompteUser.example.User.Controller;

import CompteUser.example.User.models.Utilisateur;
import CompteUser.example.User.repository.RoleRepository;
import CompteUser.example.User.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    RoleRepository roleRepository;



    @GetMapping(value = "/utilisateur")
    public List<Utilisateur> getFindAll(){
       return utilisateurRepository.findAll();
    }

    @GetMapping(value = "/utilisateur/{id}")
    public Optional<Utilisateur> getFindById(@PathVariable ("id") Integer id){
       return utilisateurRepository.findById(id);
    }

    @PostMapping(value = "/utilisateur")
    public void create(@RequestBody Utilisateur utilisateur){


            utilisateurRepository.save(utilisateur);

    }

    @DeleteMapping(value = "/utilisateur/{id}")
    public void delete(@PathVariable ("id") Integer id){
        utilisateurRepository.deleteById(id);
    }

    @PutMapping(value = "/utilisateur/{id}")
    public void update(@PathVariable ("id") Integer id, @RequestBody Utilisateur utilisateur){

        var user = utilisateurRepository.findById(id);
        if(user.isPresent()){
            utilisateur.setRole();
            utilisateurRepository.save(utilisateur);
        }
    }
}