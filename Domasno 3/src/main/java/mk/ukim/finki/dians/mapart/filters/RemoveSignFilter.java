package mk.ukim.finki.dians.mapart.filters;

// Define a class for removing a specific character from a string
public class RemoveSignFilter implements Filter<String, String> {

    // Implement the execute method to remove the specified character from the input string
    @Override
    public String execute(String s) {
        // Replace the specified character (">") with an empty string
        return s.replace(">", "");
    }
}
