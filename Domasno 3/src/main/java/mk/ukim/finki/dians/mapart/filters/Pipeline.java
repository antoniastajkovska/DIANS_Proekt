package mk.ukim.finki.dians.mapart.filters;

public class Pipeline <I,O>{
    private Filter<I,O> current;

    public Pipeline(Filter<I, O> current) {
        this.current = current;
    }
    public <P> Pipeline<I,P> pipe(Filter<O,P> next){
        return new Pipeline<>(new Pipe<>(current,next));
    }
    public O process(I input){
        return current.execute(input);
    }
}
