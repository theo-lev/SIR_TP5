package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Tableau;

public class TableauDao extends AbstractJpaDao<Long, Tableau> {
    public TableauDao () {
        this.setClazz(Tableau.class);
    }
}
