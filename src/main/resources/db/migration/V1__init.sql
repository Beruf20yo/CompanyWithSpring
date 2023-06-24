CREATE TABLE company(
                        id_company serial primary key,
                        name_company varchar(100),
                        income_company numeric default 0
);
CREATE TABLE employee(
                         id_employee serial primary key,
                         id_company int references company(id_company) on delete cascade,
                         type_employee varchar(20),
                         mounth_salary numeric,
                         income_for_company numeric default 0
);
