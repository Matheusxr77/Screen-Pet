package br.edu.ufape.screenpet.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.screenpet.business.basic.Appointment;
import br.edu.ufape.screenpet.business.basic.Schedule;

@SpringBootTest
class InterfaceCollectionAppointmentTest {

    @Autowired
    private InterfaceCollectionAppointment collectionAppointment;

    @Test
    void test() {
        long qtdAppointment = collectionAppointment.count();
        Date data = new Date();
        Appointment a = new Appointment("anamnese", data);
        Schedule s = new Schedule(1, "tipo", data);
        a.setSchedule(s);
        collectionAppointment.save(a);
        long qtdAppointment2 = collectionAppointment.count();
        assertEquals(qtdAppointment + 1, qtdAppointment2);
    }
}
