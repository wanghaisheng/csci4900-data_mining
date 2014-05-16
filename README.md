Data Mining - Athens, GA Arrest Logs
====================

###Home of the 2010 #1 Party School by [PrincetonReview.com](http://www.princetonreview.com/)


##Description
This project was made possible by [Mitch Rice](https://github.com/ricemitc). He provided 90% of the arrest logs our group used to mine with and came up with the initial idea. The [Athens-Clark County Unified Government](http://athensclarkecounty.com/) Police Force enforces a ~~Adolf Hitler Nazzi Style~~ more strict version of the law when it comes to underage individuals. In surrounding County's, a ticket is given for underage consumption of alcohol, but ACC books people into their jail. This is the reason why we choose this county to mine on. ACC provides two types of logging when it comes to prisoners: [Arrests from the Last 7 Days](http://athensclarkecounty.com/1298/Arrests-from-the-Last-7-Days) and [Current List of Inmates (Clarke County Jail) ](http://athensclarkecounty.com/1299/Current-List-of-Inmates-Clarke-County-Ja).

##Proposal
Our plan was to create a script which would download the booking log each day and parse the HTML which would subsequently be loaded into a ~~[Oracle Exadata Appliance](http://www.oracle.com/us/products/database/exadata/overview/index.html)~~ MySQL Database. Then, normal mining would occur providing relations between: charges, arresting agencies, bond amounts, misdemeanor or felony, etc. Also we wanted to mine associations between the UGA population, Students and Faculty & Staff, vs the local residents.



We plan on downloading and processing historical arrest records from Athens, Georgia on a weekly 
basis. After parsing the HTML, we will store the data in a database (MySQL) and then use tools like 
Weka to look for different association rules.

We also plan on downloading records from arrest cases within The University of Georgia. Information 
from the UGA Directory is in PDF files so we will also need to parse these before putting it into a 
database, and besides looking for association rules we will also try to connect the data with the 
information collected from Athens arrest records to see if there are any relations with people who attend 
UGA.

Athens JAIL BOOKING RECAP REPORT


