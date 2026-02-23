CREATE TABLE employees_audit(
    id BIGINT not null auto_increment,
    name VARCHAR(150),
    old_name VARCHAR(150),
    salary decimal(10,2),
    old_salary decimal(10,2),
    birthday timestamp NULL DEFAULT NULL,
    old_birthday timestamp NULL DEFAULT NULL,
    operation CHAR(1),
    created_at timestamp default current_timestamp,
    PRIMARY KEY(id)
)engine=InnoDB default charset=utf8;