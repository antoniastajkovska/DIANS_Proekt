package com.example.dians_proekt.filters;

public class RemoveSignFilter implements Filter<String,String>{
    @Override
    public String execute(String s) {
        return s.replace(">", "");
    }
}
