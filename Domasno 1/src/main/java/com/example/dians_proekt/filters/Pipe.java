package com.example.dians_proekt.filters;

public class Pipe<I,O, P> implements Filter<I,P>{
    private Filter<I,O> current;
    private Filter<O,P> next;

    Pipe(Filter<I,O> current, Filter<O,P> next){
        this.current = current;
        this.next = next;
    }

    @Override
    public P execute(I i) {
        return next.execute(current.execute(i));
    }
}
