package org.vtb.edu.database.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vtb.edu.database.dto.Product;

import java.util.List;

@Repository
public class ProductDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveProduct(Product product) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public Product getProductById(Long id) {
        Product product = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            product = session.find(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }

    public List<Product> getAllProducts() {
        List products = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            products = session.createQuery("Select u FROM Product u")
                    .getResultList();
            session.getTransaction().commit();
        }
        return products;
    }

}
