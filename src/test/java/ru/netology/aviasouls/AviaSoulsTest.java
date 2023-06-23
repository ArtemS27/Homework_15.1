package ru.netology.aviasouls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("London", "Berlin", 500, 14, 17);
    Ticket ticket2 = new Ticket("London", "Berlin", 550, 23, 1);
    Ticket ticket3 = new Ticket("London", "Berlin", 600, 9, 10);
    Ticket ticket4 = new Ticket("London", "Berlin", 400, 7, 11);
    Ticket ticket5 = new Ticket("Rome", "Paris", 600, 2, 4);

    @Test
    void findTicketsByPriceFromLessToHigh() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);

        Ticket[] expected = {ticket4, ticket1, ticket2, ticket3};
        Ticket[] actual = aviaSouls.search("London", "Berlin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findSomeTicketsAndSortByFlyingTime() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket3, ticket2, ticket1, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("London", "Berlin", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findOneTicket() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket5};
        Ticket[] actual = aviaSouls.searchAndSortBy("Rome", "Paris", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void ticketsNotFound() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Paris", "London", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
