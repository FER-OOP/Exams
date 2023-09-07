package hr.fer.oop.shopping;

import java.time.LocalDate;

public record Transaction(String town, LocalDate dateOfTransaction, int amount) {}
