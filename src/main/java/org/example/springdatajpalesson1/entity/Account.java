package org.example.springdatajpalesson1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 6, max = 20,message = "Логин должен быть от 6 до 20 символов")
    @Column(unique = true, nullable = false)
    private String login;

    @Size(min = 6, max = 20, message = "Пароль должен быть от 6 до 20 символов")
    @Column(nullable = false)
    private String password;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Min(0)
    private int level = 1;
}
