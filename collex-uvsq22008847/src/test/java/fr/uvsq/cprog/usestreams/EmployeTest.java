package fr.uvsq.cprog.usestreams;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Test;

public class EmployeTest {
    @Test
    public void testConstructeur() {
        Employe e = new Employe("Alice", 20, sexe.female, BigDecimal.valueOf(9000), LocalDate.of(2020, 6, 1), Service.SERVICE_ONE);
        assertEquals("Alice", e.getNom());
        assertEquals(20, e.getAge());
        assertEquals(sexe.female, e.getSex());
        assertEquals(9000, e.getSalaire().intValue());
        assertEquals(Service.SERVICE_ONE, e.getSerRattachement());
    }
}
