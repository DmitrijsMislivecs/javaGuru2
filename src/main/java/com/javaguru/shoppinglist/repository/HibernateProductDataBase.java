package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

@Repository
@Profile("hibernate")
@Transactional
public class HibernateProductDataBase implements ProductDataBase {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateProductDataBase(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long insert(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product.getId();
    }

    @Override
    public Optional<Object> findProductById(Long id) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public boolean isExistingProductByName(String name) {
        String query = "select case when count(*) > 0 " +
                "then true else false end " +
                "from Product where name = " + name;
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setMaxResults(1)
                .uniqueResult();
    }
}
