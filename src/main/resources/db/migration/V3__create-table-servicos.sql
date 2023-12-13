create table servicos
(
    id           bigint       not null auto_increment,
    descricao    varchar(255) not null,
    tempoDuracao varchar(255) not null,
    tipo         varchar(255) not null,
    valor        decimal(10, 2),
    primary key (id)

);