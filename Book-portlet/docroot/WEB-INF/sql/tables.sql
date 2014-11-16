create table Book (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	bookName VARCHAR(75) null,
	author VARCHAR(75) null,
	price DOUBLE,
	bookType VARCHAR(75) null
);