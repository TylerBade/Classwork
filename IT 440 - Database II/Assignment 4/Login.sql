USE [master]
GO
DROP LOGIN [JohnSmith]
CREATE LOGIN [JohnSmith] WITH PASSWORD = 'default'
GO

CREATE SERVER ROLE [datareader];
ALTER SERVER ROLE [datareader] ADD MEMBER [JohnSmith]
GO