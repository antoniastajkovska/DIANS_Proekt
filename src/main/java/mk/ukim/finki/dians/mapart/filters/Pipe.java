package mk.ukim.finki.dians.mapart.filters;

// Define a class for creating a pipeline of filters
public class Pipe<I, O, P> implements Filter<I, P> {

    // The current filter in the pipeline
    private Filter<I, O> current;

    // The next filter in the pipeline
    private Filter<O, P> next;

    // Constructor to initialize the Pipe with current and next filters
    Pipe(Filter<I, O> current, Filter<O, P> next) {
        this.current = current;
        this.next = next;
    }

    // Implementation of the execute method from the Filter interface
    @Override
    public P execute(I input) {
        // Execute the current filter on the input, then pass the result to the next filter
        return next.execute(current.execute(input));
    }
}
