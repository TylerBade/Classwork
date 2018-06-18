DECLARE @Customer_ID AS INT;
DECLARE @FName AS NVARCHAR(20);
DECLARE @LName AS NVARCHAR(20)

DECLARE @CustomerCursor AS CURSOR;
SET @CustomerCursor = CURSOR FOR
SELECT Customer_ID, FName, LName
FROM Customer;

OPEN @CustomerCursor;
FETCH NEXT FROM  @CustomerCursor INTO
@Customer_ID, @FName, @LName;

WHILE @@FETCH_STATUS = 0
BEGIN
PRINT cast(@Customer_ID AS NVARCHAR(2)) + ' ' + @FName + ' ' + @LName;
FETCH NEXT FROM @CustomerCursor INTO @Customer_ID, @FName, @LName;
END

CLOSE @CustomerCursor;
DEALLOCATE @CustomerCursor;