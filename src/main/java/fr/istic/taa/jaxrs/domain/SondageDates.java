package fr.istic.taa.jaxrs.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class SondageDates extends Sondage {

    @OneToMany(mappedBy = "sondage")
    private List<DateSondage> choix_dates;

    public List<DateSondage> getChoix_dates() {
        return choix_dates;
    }

    public void setChoix_dates(List<DateSondage> choix_dates) {
        this.choix_dates = choix_dates;
    }
}
