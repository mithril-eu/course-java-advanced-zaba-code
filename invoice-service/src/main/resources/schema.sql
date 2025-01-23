create table if not exists invoices (
    id uuid default random_uuid() primary key,
    amount int,
    user_id varchar(255),
    pdf_url varchar(255)
);