package com.ingbootcamp.accountservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Getter
@Table("accounts")
public class Account {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Column(value = "name")
    @Setter
    private String name;

    @Column(value = "surname")
    @Setter
    private String surname;

    @Column(value = "uname")
    @Setter
    private String username;

    @Column(value = "passw")
    @Setter
    private String password;

    @Column(value = "created_at")
    private Date created_at;
}
