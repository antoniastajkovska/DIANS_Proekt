package mk.ukim.finki.dians.mapart.filters;

// Define a class for splitting a string using the equals sign as the delimiter
public class SplitStringFilter implements Filter<String, String> {

    // Implement the execute method to split the input string and return the second part
    @Override
    public String execute(String s) {
        // Split the input string using "=" as the delimiter and return the second part (index 1)
        return s.split("=")[1];
    }
}
