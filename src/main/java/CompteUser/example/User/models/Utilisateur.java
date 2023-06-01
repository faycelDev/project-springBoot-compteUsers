package CompteUser.example.User.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtilisateur;
    private String nom;
    private String prenom;
    private String adresse;


    @ManyToMany
    private List<Role> role;

    public void setUtilisateur(Integer id) {
    }

    public void setRole() {
    }
}
