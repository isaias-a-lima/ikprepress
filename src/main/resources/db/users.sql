--2025-05-01 17:48 - Portugal - Katia Lima - Users table creation
CREATE TABLE users (
user_id BIGINT NOT NULL COMMENT 'Database user identification',
id_doc VARCHAR(100) NOT NULL COMMENT 'User identification document',
user_name VARCHAR(100) NOT NULL COMMENT 'User name',
user_email VARCHAR(100) NOT NULL COMMENT 'User email',
user_password VARCHAR(255) NOT NULL COMMENT 'User password to allow system access',
creation_date DATE NOT NULL COMMENT 'Creation date',
actived BOOLEAN NOT NULL COMMENT 'Flag to identify if the user is active',
PRIMARY KEY(user_id)
)COMMENT = 'Users registration';