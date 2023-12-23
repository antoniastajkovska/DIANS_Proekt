package mk.ukim.finki.dians.mapart.filters;

// Define a generic interface for filters with input type I and output type O
public interface Filter<I, O> {

    // Method signature for the execute method, which processes input and produces output
    // Implementing classes will provide specific logic for data transformation
    O execute(I input);
}
