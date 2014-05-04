SELECT * FROM booking_charge;

-- remove NULL charge_category tuples
DELETE FROM booking_charge WHERE charge_category IS NULL;
SELECT * FROM booking_charge WHERE charge_category IS NULL;

-- delete duplicates by how many there are
DELETE FROM booking_charge 
WHERE charge_category IN  (
SELECT charge_category FROM (
		SELECT * , COUNT(*) FROM booking_charge 
		GROUP BY charge_category
		-- could add a WHERE clause here to further filter
		HAVING count(*) = 23 )
AS youmybitch
);