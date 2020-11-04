package com.springfive.HuntClub.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.springfive.HuntClub.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
