INSERT INTO users(username,password,enabled)
VALUES ('jan','{noop}jan123', true);

INSERT INTO users(username,password,enabled)
VALUES ('ania','{noop}Asdf1234', true);

INSERT INTO authorities (username, authority)
VALUES ('jan', 'ROLE_USER');

INSERT INTO authorities (username, authority)
VALUES ('jan', 'ROLE_ADMIN');

INSERT INTO authorities (username, authority)
VALUES ('ania', 'ROLE_USER');