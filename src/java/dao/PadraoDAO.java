package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import util.ExceptionDAO;

/**
 *
 * @author paulohenrique
 * @param <T>
 */
public class PadraoDAO<T> {

    protected Session sessao;

    public PadraoDAO(Session sessao) {
        this.sessao = sessao;
    }
    

    public void salvar(T object) throws Exception {
        this.sessao.save(object);
    }

    public void salvarOuAtualizar(T object) throws Exception {
        this.sessao.saveOrUpdate(object);
    }

    public void atualizar(T object) throws Exception {
        this.sessao.update(object);
    }

    public void excluir(T object) throws Exception {
        this.sessao.delete(object);
    }

    public T carregarPorId(Class<T> clazz, long id) throws Exception {
        return (T) this.sessao.get(clazz, id);
    }

    /**
     * Lista todos os objetos de uma tabela escolhendo um campo para ordenamento
     * asc
     *
     * @param clazz
     * @param order
     * @return
     * @throws ExceptionDAO
     */
    public List<T> listar(Class<T> clazz, String order) throws Exception {
        Criteria criterio = this.sessao.createCriteria(clazz);
        criterio.addOrder(Order.asc(order));
        return criterio.list();
    }

    /**
     * Método para fechar sessão em caso de erro.
     *
     *
     * @throws Exception
     */
    public void fecharSessao() throws Exception {

        if (this.sessao.isOpen()) {
            this.sessao.close();
        }

    }

    /**
     * Imprime uma exceção no log do servidor.
     *
     * @param clazz Classe geradora do erro.
     * @param level Level do erro.
     * @param msg Mensagem informativa.
     * @param ex Exceção gerada.
     */
    public static void printLogger(Class<?> clazz, Level level, String msg, Exception ex) {
        Logger.getLogger(clazz.getName()).log(level, msg, ex);
    }

}
