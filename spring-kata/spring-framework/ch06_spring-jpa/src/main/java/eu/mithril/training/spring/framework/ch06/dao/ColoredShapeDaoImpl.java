package eu.mithril.training.spring.framework.ch06.dao;

import eu.mithril.training.spring.framework.ch06.model.ColoredShape;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ColoredShapeDaoImpl implements ColoredShapeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ColoredShape findById(final Long id) {

        return (ColoredShape) em
                .createQuery("SELECT c FROM ColoredShape c WHERE c.id LIKE :id")
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList().get(0);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void save(final ColoredShape coloredShape) {
        em.merge(coloredShape);
    }
}