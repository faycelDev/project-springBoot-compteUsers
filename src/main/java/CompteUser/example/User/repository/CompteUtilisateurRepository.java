package CompteUser.example.User.repository;

import CompteUser.example.User.models.CompteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteUtilisateurRepository extends JpaRepository<CompteUtilisateur, Integer> {
}
