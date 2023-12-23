package mk.ukim.finki.dians.mapart.filters;

public class SplitStringFilter implements Filter<String,String>{

    @Override
    public String execute(String s) {
        return s.split("=")[1];
    }
}
