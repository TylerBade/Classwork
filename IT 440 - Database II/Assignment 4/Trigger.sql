CREATE TRIGGER MileCheck ON Invoice
AFTER INSERT
AS
IF EXISTS (SELECT *
			FROM Invoice
			WHERE Milage > 100
			)
BEGIN
RAISERROR ('Vehicles need to be checked when driven over 100 miles in a single rental', 16, 1);
RETURN
END;
GO