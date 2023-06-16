package ru.netology.aviasouls;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getFlyingTime() < o2.getFlyingTime()) {
            return -1;
        } else if (o1.getFlyingTime() > o2.getFlyingTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}
