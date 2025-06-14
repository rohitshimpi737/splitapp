package com.rohit.splitapp.persistence.dto.expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseListDTO {
    @NotNull
    UUID expenseId;

    @NotNull
    double amount;

    private String description;

    @NotNull
    @NotBlank
    private String expenseCreatedAt;

}
