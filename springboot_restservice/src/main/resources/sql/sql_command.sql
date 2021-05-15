-- associates table
CREATE TABLE associates (
                            id SERIAL PRIMARY KEY,
                            code VARCHAR NOT NULL,
                            fullName VARCHAR NOT NULL,
                            address VARCHAR NULL,
                            dateOfBirth Date NULL,
                            resourceManager VARCHAR NULL,
                            metadata VARCHAR NULL,
                            role VARCHAR NULL,
                            created timestamp default current_timestamp,
                            updated timestamp default current_timestamp
);
