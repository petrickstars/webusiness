package br.com.webusiness.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author aaoliveira
 * @param <T>
 */
public class Dao<T> {
    private static final Logger logger = Logger.getLogger(Dao.class);
    private final Class persistentClass;
    private final Session session;
    
    protected Dao(Session session, Class persistentClass) {
        this.session = session;
        this.persistentClass = persistentClass;
    }
    
    public T recuperarPorId(int id) {
        logger.info("getting " + persistentClass + " with id " + id);
        return (T) session.get(persistentClass, id);
    }
    
    public List<T> recuperarTodos() {
        logger.info("getting all " + persistentClass);
        Criteria c = session.createCriteria(persistentClass);        
        return c.list();
    }
    
    public void inserir(T t) {
        logger.info("saving " + t);
        session.save(t);
    }
    
    public void atualizar(T t) {
        logger.info("updating " + t);
        session.update(t);
    }
    
    public void excluir(T t) {
        logger.info("deleting " + t);
        session.delete(t);
    }
    
    public static <T> Dao<T> criarInstancia(Session session, Class<T> c) {
        return new Dao<>(session, c);
    }
    
    protected Session getSession() {
        return session;
    }
        
}