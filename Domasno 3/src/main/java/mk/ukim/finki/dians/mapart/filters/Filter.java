package mk.ukim.finki.dians.mapart.filters;

public interface Filter<I, O>{
    O execute(I i);
}
