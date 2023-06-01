package CompteUser.example.User.Controller;

import CompteUser.example.User.models.Role;
import CompteUser.example.User.models.Utilisateur;
import CompteUser.example.User.repository.RoleRepository;
import CompteUser.example.User.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class RoleConttroller {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping(value = "/role")
    public List<Role> getFindAll(){
      return roleRepository.findAll();
    }

    @GetMapping(value = "/role/{id}")
    public Optional<Role> getFindById(@PathVariable ("id") Integer id){

       return roleRepository.findById(id);
    }

    @PostMapping(value = "/role")
    public void create(@RequestBody Role role){

          roleRepository.save(role);


        }

        @DeleteMapping("/role/{id}")
    public void delete(@PathVariable ("id") Integer id){

                roleRepository.deleteById(id);
        }

        @PutMapping("/role/{id}")
        public void update(@PathVariable ("id") Integer id, @RequestBody Role role){

                var r2 = roleRepository.findById(id);
                if(r2.isPresent()){
                    role.setUtilisateur();
                    roleRepository.save(role);
                }
        }

    }

