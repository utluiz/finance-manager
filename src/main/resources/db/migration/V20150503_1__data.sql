--user
merge into user (email, password, name) key (email) 
	values ('utluiz@gmail.com', '123', 'Luiz Ricardo');
merge into user (email, password, name) key (email) 
	values ('fernandaregiane@gmail.com', '123', 'Fernanda Regiane');
set @id = IDENTITY();

--balance
merge into balance (title, owner_id) key (title) 
	values ('Finanças Pessoais', @id);
set @id = IDENTITY();

--account
merge into account (title, balance_id) key (title) 
	values ('Dinheiro em Mãos', @id);
set @id1 = IDENTITY();
merge into account (title, balance_id) key (title) 
	values ('Banco do Brasil', @id);
set @id2 = IDENTITY();
merge into account (title, balance_id) key (title) 
	values ('Itaú', @id);
set @id3 = IDENTITY();
merge into account (title, balance_id) key (title) 
	values ('Cartão de Crédito', @id);

--movement
merge into movement (description, movement_date, value, type, account_id) key (description) 
	values ('Salário', '2015-05-01 00:00:00', 2000.00, 'C', @id3);
merge into movement (description, movement_date, value, type, account_id) key (description) 
	values ('Aluguel', '2015-05-01 00:00:00', 700.00, 'D', @id3);
	
merge into movement (description, movement_date, value, type, account_id) key (description) 
	values ('Saque', '2015-05-01 00:00:00', 200.00, 'D', @id3);
merge into movement (description, movement_date, value, type, account_id) key (description) 
	values ('Saque', '2015-05-01 00:00:00', 200.00, 'C', @id1);
merge into movement (description, movement_date, value, type, account_id) key (description) 
	values ('Padaria', '2015-05-02 00:00:00', 25.75, 'D', @id1);
	
merge into movement (description, movement_date, value, type, account_id) key (description) 
	values ('Depósito Poupança', '2015-01-01 00:00:00', 1000.00, 'C', @id2);
merge into movement (description, movement_date, value, type, account_id) key (description) 
	values ('Juros Poupança', '2015-05-10 00:00:00', 15.00, 'C', @id2);
