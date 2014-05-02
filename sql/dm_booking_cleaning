USE dm;

SELECT * FROM booking LIMIT 20;
SELECT * FROM booking_charge LIMIT 20;

-- select all which are not misdemeanor or felony
SELECT * FROM booking_charge WHERE NOT grade_of_charge="FELONY" AND NOT grade_of_charge="MISDEMEANOR";

-- change F -> FELONY
UPDATE booking_charge SET grade_of_charge='FELONY' WHERE grade_of_charge="F";
-- change M -> MISDEMEANOR
UPDATE booking_charge SET grade_of_charge='MISDEMEANOR' WHERE grade_of_charge="M";
-- change B -> TO BE DETERMINED
UPDATE booking_charge SET grade_of_charge='TO BE DETERMINED' WHERE grade_of_charge="B";

-- arresting_agency
-- ACCPD Athens Clark County Police Department
-- UGAPD University of Georgia Police Department
-- GSP Georgia State Patrol
-- SO Sheriff's Office
-- WPD Winder Police Department
-- DIMV Department of Motor Vehicles
-- ACCDC Athens Clark Cooperative Development Council ?
-- DNR Department of Natural Resources
-- PROBO Probation
-- ROCSO Dash ?
-- DMVSD Special Division ?
-- APROB ?
SELECT * FROM booking_charge WHERE
	NOT arresting_agency="ACCPD" AND
	NOT arresting_agency="UGAPD" AND
	NOT arresting_agency="GSP" AND
	NOT arresting_agency="SO" AND
	NOT arresting_agency="WPD" AND
	NOT arresting_agency="DIMV" AND
	NOT arresting_agency="ACCDC" AND
	NOT arresting_agency="DNR" AND
	NOT arresting_agency="PROBO" AND
	NOT arresting_agency="ROCSO" AND
	NOT arresting_agency="DMVSD" AND
	NOT arresting_agency="APROB";

-- court_jurisdiction
-- SUPCT Supreme Court
-- MUNCT Municipal Court
-- STCRT State Court ?
-- MAGCT Magistrate Court
-- WINTV ?
-- WINCT ?
-- OAJUD ?
SELECT * FROM booking_charge WHERE
	NOT court_jurisdiction="SUPCT" AND
	NOT court_jurisdiction="MUNCT" AND
	NOT court_jurisdiction="STCRT" AND
	NOT court_jurisdiction="MAGCT" AND
	NOT court_jurisdiction="WINTV" AND
	NOT court_jurisdiction="WINCT" AND
	NOT court_jurisdiction="OAJUD";

UPDATE booking_charge SET charge_description=null WHERE charge_description="ERROR";


