import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static EntityManager entityManager;

    public static void main(String[] args) {
        entityManager = Persistence
                .createEntityManagerFactory("code_first")
                .createEntityManager();


        entityManager.getTransaction().begin();


        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
