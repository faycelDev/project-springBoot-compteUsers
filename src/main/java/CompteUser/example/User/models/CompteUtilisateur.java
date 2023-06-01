package CompteUser.example.User.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "compteUtilisateur")
public class CompteUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompteUtilisateur;
    private String pseudo;
    private String motDePass;



    @OneToOne(cascade = CascadeType.ALL)
    private Utilisateur utilisateur;

    public void setUtilisateur() {
    }
}
