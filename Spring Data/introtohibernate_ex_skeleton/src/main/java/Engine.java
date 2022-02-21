import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Select ex number:");
        try {
            int exNumber = Integer.parseInt(bufferedReader.readLine());

            switch (exNumber) {
                case 2:
                    exTwo();
                    break;
                case 3:
                    exThree();
                    break;
                case 4:
                    exFour();
                    break;
                case 5:
                    exFive();
                    break;
                case 6:
                    exSix();
                    break;
                case 7:
                    exSeven();
                    break;
                case 8:
                    exEight();
                    break;
                case 9:
                    exNine();
                    break;
                case 10:
                    exTen();
                    break;
                case 11:
                    exEleven();
                    break;
                case 12:
                    exTwelve();
                    break;
                case 13:
                    exThirteen();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid task number");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    private void exThirteen() throws IOException {

        System.out.println("Enter town name:");
        String townName = bufferedReader.readLine();

        Town town = entityManager
                .createQuery("SELECT t FROM Town t WHERE t.name = :t_name"
                        , Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();

        int affectedRows = removeAddressByTownId(town.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.printf("%d address in %s deleted", affectedRows, townName);
    }

    @SuppressWarnings("uncheked")
    private void exTwelve() {
        List<Object[]> list= entityManager
                .createNativeQuery("SELECT d.name,MAX(e.salary) AS `m_salary` " +
                        "FROM departments d " +
                        "join employees e on d.department_id = e.department_id group by d.name" +
                        " HAVING m_salary NOT BETWEEN  30000 AND 70000;")
                .getResultList();
        System.out.println();
        for (Object[] objects : list) {
            System.out.printf("%s %s%n",objects[0],objects[1]);
        }


    }

    private void exEleven() throws IOException {
        System.out.println("Please enter pattern:");
        String pattern = bufferedReader.readLine();
        entityManager.createQuery
                        ("SELECT e FROM Employee e " +
                                "WHERE e.firstName LIKE :parm", Employee.class)
                .setParameter("parm", pattern + "%")
                .getResultStream()
                .forEach(e->{
                    System.out.printf("%s %s - %s - ($%.2f)%n",
                            e.getFirstName(),e.getLastName(),e.getJobTitle(),e.getSalary());
                });

    }

    private void exTen() {
        List<Integer> ids = List.of(1, 2, 4, 11);
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Employee e " +
                        "SET e.salary = e.salary * 1.12 " +
                        "where e.department.id IN :ids ")
                .setParameter("ids", ids)
                .executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.id IN :ids ", Employee.class)
                .setParameter("ids", ids)
                .getResultStream()
                .forEach(e -> {
                    System.out.printf("%s %s ($%.2f)%n",
                            e.getFirstName(), e.getLastName(),
                            e.getSalary());
                });
    }

    private void exNine() {
        List<Project> projects = entityManager.createQuery
                        ("SELECT p FROM Project p " +
                                "ORDER BY p.startDate DESC ", Project.class)
                .setMaxResults(10)
                .getResultList();
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss'.0'");

        projects.stream()
                .sorted(Comparator.comparing(Project::getName))
                        .forEach(p->{
                            System.out.printf("Project name:%s%n\tProject Description:%s%n\tProject Start Date:%s%n\tProject End Date: null%n"
                                    ,p.getName(),p.getDescription(),FOMATTER.format(p.getStartDate()));

                        });

        System.out.println();

    }

    private void exEight() throws IOException {
        System.out.println("Please enter id:");
        int id = Integer.parseInt(bufferedReader.readLine());
        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.id = :id ", Employee.class)
                .setParameter("id", id)
                .getSingleResult();

        System.out.printf("%s %s - %s%n"
                , employee.getFirstName(), employee.getLastName(),
                employee.getJobTitle());
        employee.getProjects().stream()
                .map(p -> p.getName())
                .sorted(Comparator.comparing(n -> n))
                .forEach(System.out::println);


        System.out.println();
    }

    private void exSeven() {
        List<Address> addresses = entityManager
                .createQuery("SELECT a from Address a " +
                        "order by a.employees.size DESC ", Address.class)
                .setMaxResults(10)
                .getResultList();
        addresses
                .forEach(address -> {
                    System.out.printf("%s , %s - %d employees%n",
                            address.getText(),
                            address.getTown() == null
                                    ? "Unknown"
                                    : address.getTown().getName(),
                            address.getEmployees().size());
                });
    }

    private void exSix() throws IOException {
        System.out.println("Please enter employee's last name:");
        String lastName = bufferedReader.readLine();

        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :l_name", Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();

        Address address = createAddress("Vitoshka 15");

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private void exFive() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = :d_name " +
                        "order by e.salary,e.id", Employee.class)
                .setParameter("d_name", "Research and Development")
                .getResultStream()
                .forEach(e -> {
                    System.out.printf("%s %s from Research and Development - $%.2f%n",
                            e.getFirstName(), e.getLastName(), e.getSalary());
                });
    }

    private void exFour() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "Where e.salary > :min_salary", Employee.class)
                .setParameter("min_salary", BigDecimal.valueOf(50000L))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);


    }

    private void exThree() throws IOException {
        System.out.println("Enter employee full name:");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult = entityManager.createQuery
                        ("SELECT count(e) FROM Employee AS e WHERE e.firstName = :f_name " +
                                        "AND e.lastName = :l_name",
                                Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();
        System.out.println(singleResult == 0 ? "No" : "Yes");
    }

    private void exTwo() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery
                ("UPDATE Town AS t SET t.name = upper(t.name) " +
                        "WHERE length(t.name) <= 5 ");
        System.out.println(query.executeUpdate());

        entityManager.getTransaction().commit();

    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    private int removeAddressByTownId(Integer id) {

        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "where a.town.id = :p_id", Address.class)
                .setParameter("p_id", id)
                .getResultList();

        entityManager.getTransaction().begin();

        addresses.forEach(entityManager::remove);

        entityManager.getTransaction().commit();

        return addresses.size();
    }
}
