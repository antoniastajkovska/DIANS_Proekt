package mk.ukim.finki.dians.mapart.filters;

// Define a class for creating a data processing pipeline
public class Pipeline<I, O> {

    // The current filter in the pipeline
    private Filter<I, O> current;

    // Constructor to initialize the Pipeline with a starting filter
    public Pipeline(Filter<I, O> current) {
        this.current = current;
    }

    // Method to add a new filter to the pipeline and create a new pipeline
    public <P> Pipeline<I, P> pipe(Filter<O, P> next) {
        // Create a new pipeline with the current and next filters connected in a sequence
        return new Pipeline<>(new Pipe<>(current, next));
    }

    // Method to process the input data through the pipeline and get the final result
    public O process(I input) {
        // Execute the entire pipeline on the input data and return the result
        return current.execute(input);
    }
}
