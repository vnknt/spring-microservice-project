package com.ingbootcamp.accountservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Table("accounts")
public class Account {
    @Column(value = "id")
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Column(value = "name")
    private String name;

    @Column(value = "surname")
    private String surname;

    @Column(value = "uname")
    private String username;

    @Column(value = "passw")
    private String password;

    @Column(value = "created_at")
    private Date created_at;
}
