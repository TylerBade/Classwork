SELECT c.Car_ID, b.Branch_Name, c.Price_Per_Day, c.CarTypeID
FROM Car c WITH (INDEX(CarDex))
JOIN Branch b ON c.Branch_ID = b.Branch_ID
WHERE c.CarTypeID = 2;
GO
