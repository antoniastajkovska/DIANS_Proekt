package com.example.dians_proekt.filters;

public interface Filter<I, O>{
    O execute(I i);
}
