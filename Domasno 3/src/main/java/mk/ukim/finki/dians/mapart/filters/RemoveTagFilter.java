package mk.ukim.finki.dians.mapart.filters;

// Define a class for removing a specific substring from a string
public class RemoveTagFilter implements Filter<String, String> {

    // Implement the execute method to remove the specified substring from the input string
    @Override
    public String execute(String s) {
        // Replace the specified substring ("<node ") with an empty string
        return s.replace("<node ", "");
    }
}
