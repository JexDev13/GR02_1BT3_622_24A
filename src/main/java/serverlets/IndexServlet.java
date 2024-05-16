package serverlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.Habitacione;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            // Obtener una lista de todas las habitaciones
            List<Habitacione> habitaciones = em.createQuery("SELECT h FROM Habitacione h", Habitacione.class).getResultList();

            // Pasar la lista de habitaciones a la JSP
            req.setAttribute("habitaciones", habitaciones);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } finally {
            em.close();
            emf.close();
        }
    }
}
