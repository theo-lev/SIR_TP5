package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Fiche;

public class FicheDao extends AbstractJpaDao<Long, Fiche> {
    public FicheDao() {
        this.setClazz(Fiche.class);
    }
}
