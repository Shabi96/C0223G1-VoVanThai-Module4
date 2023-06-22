package com.example.nang_cap_quan_ly_san_pham.repository.impl;

import com.example.nang_cap_quan_ly_san_pham.model.Product;
import com.example.nang_cap_quan_ly_san_pham.repository.ConnectionUtils;
import com.example.nang_cap_quan_ly_san_pham.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private static final String SELECT_ALL_PRODUCT_QUERY = "FROM Product";

    @Override
    public List<Product> getProductList() {
        return ConnectionUtils.getEntityManager().createQuery(SELECT_ALL_PRODUCT_QUERY).getResultList();
    }

    @Override
    public void addNewProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product getProductById(Integer id) {
        Session session = ConnectionUtils.getSessionFactory().openSession();
        TypedQuery<Product> query = session.createQuery("from Product where id= :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void updateProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
            ConnectionUtils.getEntityManager().clear();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Product product = getProductById(id);
            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        Session session = ConnectionUtils.getSessionFactory().openSession();
        TypedQuery<Product> typedQuery = session.createQuery
                ("FROM Product where name like concat('%',:name,'%')");
        typedQuery.setParameter("name", name);
        return typedQuery.getResultList();
    }

    @Override
    public boolean findIdProduct(Integer id) {
        Session session = ConnectionUtils.getSessionFactory().openSession();
        TypedQuery<Integer> typedQuery = session.createQuery("select id from Product");
        for (Integer p : typedQuery.getResultList()) {
            if (p.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
