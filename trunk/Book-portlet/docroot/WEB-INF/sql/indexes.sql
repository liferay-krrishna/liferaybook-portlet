create index IX_76E7A0D7 on Book (bookName);
create index IX_3C3DA645 on Book (uuid_);
create index IX_CD3A30C3 on Book (uuid_, companyId);
create unique index IX_520E0C05 on Book (uuid_, groupId);