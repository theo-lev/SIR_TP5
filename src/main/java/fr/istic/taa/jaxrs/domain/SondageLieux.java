package fr.istic.taa.jaxrs.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class SondageLieux extends Sondage{

    @OneToMany(mappedBy = "sondage")
    private List<Lieu> choix_lieux;
    
    public List<Lieu> getChoix_lieux() { return choix_lieux; }

    public void setChoix_dates(List<Lieu> choix_lieux) {
        this.choix_lieux = choix_lieux;
    }
}
