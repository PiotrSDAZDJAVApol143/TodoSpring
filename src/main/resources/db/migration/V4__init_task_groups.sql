create table tasks_groups(
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             description VARCHAR(100) NOT NULL,
                             done_check bit
);
alter table tasks add column task_group_id int null;
alter table tasks
    add foreign key (task_group_id) references tasks_groups (id);