package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Sondage;

public class SondageDao extends AbstractJpaDao<Long, Sondage> {
    public SondageDao() {
        this.setClazz(Sondage.class);
    }
}
