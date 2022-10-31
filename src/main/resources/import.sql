---- Category
--insert into category(value) values
--('Biography & Autobiography'),
--('Body, Mind & Spirit'), ('Business & Economics'), ('Comics & Graphic Novels'), ('Computers'),
--('Cooking'), ('Crafts & Hobbies'), ('Design'), ('Drama'), ('Education'), ('Family & Relationships'),
--('Fiction'), ('Nonfiction'), ('Foreign Language Study'), ('Games & Activities'), ('Gardening'), ('Health & Fitness'),
--('History'), ('House & Home'), ('Humor'), ('Juvenile Fiction'), ('Juvenile Nonfiction'),
--('Language Arts & Disciplines'), ('Law'), ('Literary Collections'), ('Literary Critisism'),
--('Mathematics'), ('Medical'), ('Music'), ('Nature'), ('Performing Arts'), ('Pets'), ('Philosophy'),
--('Photography'), ('Poetry'), ('Political Science'), ('Psychology'), ('Reference'), ('Religion'),
--('Science'), ('Self-help'), ('Social Science'), ('Sports & Recreation'), ('Study Aids'),
--('Technology & Engineering'), ('Transportation'), ('Travel'), ('True Crime'),
--('Young Adult Fiction'), ('Young Adult Nonfiction');
--
--
---- Publisher
--select * from publisher;
--insert into publisher(location, value, url) values
--('US','Simon & Schuster','https://www.simonandschuster.com/'),
--('UK','Pearson','https://www.pearson.com/'),
--('US','Springer','http://www.springerpub.com/'),
--('US','Basic Books','http://www.basicbooks.com/');
--
--
---- Language
--insert into language(code, value) values
--('ar','Arabic'),
--('de','German'),
--('en','English'),
--('es','Spanish'),
--('fr','French'),
--('it','Italian'),
--('ja','Japanese'),
--('vi','Vietnamese');
--
--
---- Ebook
--insert into ebook (description, published_year, title, category_id, language_id, publisher_id) values
--('A novel by Junichi Watanabe. English title: Light and Shadow', 1843, 'Đèn Không Hắt Bóng', 1, 5, 1),
--('A novella by Charles Dickens', 1843, 'A Christmas Carol', 2, 1, 1),
--('The thirteenth novel by Charles Dickens', 1861, 'Great Expectations', 3, 1, 1),
--('A collection of short stories', 1843, 'The Winds of Hua Tat', 4, 1, 1),
--('The story of a soldier', 1994, 'The Sorrow of War', 5, 1, 1),
--('A children''s novel written by British author Roald Dahl', 1970, 'Fantastic Mr Fox', 6, 1, 1);


-- Author
insert into author(date_of_birth, first_name, last_name, status)
values ('1870-06-09', 'Charles', 'Dickens', 'INACTIVE');
insert into author(date_of_birth, first_name, last_name, status)
values ('1952-10-18', 'Ninh', 'Bao', 'ACTIVE');
insert into author(date_of_birth, first_name, last_name, status)
values ('1956-03-09', 'Huy Thiep', 'Nguyen', 'INACTIVE');
insert into author(date_of_birth, first_name, last_name, status)
values ('1933-10-24', 'Junichi', 'Watanabe', 'INACTIVE');
insert into author(date_of_birth, first_name, last_name, status)
values ('1930-07-30', 'Xuan Hao', 'Cao', 'INACTIVE');
insert into author(date_of_birth, first_name, last_name, status)
values ('1916-09-13', 'Roald', 'Dahl', 'INACTIVE');
insert into author(date_of_birth, first_name, last_name, status)
values ('1924-10-09', 'Donald', 'Chaffin', 'INACTIVE');


---- Contributor
--insert into contributor(type, author_id, ebook_id) values
--('TRANSLATOR', 3, 1),
--('AUTHOR', 1, 1),
--('AUTHOR', 4, 2),
--('ILLUSTRATOR', 2, 2);
