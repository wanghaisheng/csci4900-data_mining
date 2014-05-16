Data Mining - Athens, GA Arrest Logs
====================

###Home of the 2010 #1 Party School by [PrincetonReview.com](http://www.princetonreview.com/)


##Description
This project was made possible by [Mitch Rice](https://github.com/ricemitc). He provided 90% of the arrest logs our group used to mine with and came up with the initial idea. The [Athens-Clark County Unified Government](http://athensclarkecounty.com/) Police Force enforces a ~~Adolf Hitler Nazzi Style~~ more strict version of the law when it comes to underage individuals. In surrounding County's, a ticket is given for underage consumption of alcohol, but ACC books people into their jail. This is the reason why we choose this county to mine on. ACC provides two types of logging when it comes to prisoners: [Arrests from the Last 7 Days](http://athensclarkecounty.com/1298/Arrests-from-the-Last-7-Days) and [Current List of Inmates (Clarke County Jail)](http://athensclarkecounty.com/1299/Current-List-of-Inmates-Clarke-County-Ja).


##Proposal
Our plan was to create a script which would download the booking log each day and parse the HTML which would subsequently be loaded into a ~~[Oracle Exadata Appliance](http://www.oracle.com/us/products/database/exadata/overview/index.html)~~ MySQL Database. Then, normal mining would occur providing relations between: charges, arresting agencies, bond amounts, misdemeanor or felony, etc. Also we wanted to mine associations between the UGA population, Students and Faculty & Staff, vs the local residents.


##Implementation
We used a CRON job scheduler to pdl the latest copy of the arrest log from the [Athens-Clark County](http://athensclarkecounty.com/1298/Arrests-from-the-Last-7-Days) website. More information is in our scripts directory with the tricky way of faking it. Next, we had a Chinaman write some [Oracle Java](http://www.oracle.com/technetwork/java/index.html) code to parse the ASP/HTML into Objects. Luckily, we had some help from the open source project [jsoup: Java HTML Parser](http://jsoup.org/). The name does exactly what it advertises. From here we use the [Java Database Connectivity (JDBC)](http://www.oracle.com/technetwork/java/javase/jdbc/index.html) to interface with our MySQL instance. We ended up simplifying our database to just two connected tables for the booking logs. If you are interested in how our resident Chinaman extracted the text from the U-G-A Student and Faculty & Staff listings, send a email provided on this.users page.


##Mining
We used [Weka](http://www.cs.waikato.ac.nz/ml/weka/) and [RapidMiner](http://rapidminer.com/) as our main miners. We also had our Chinaman's "SQLMiner" which consisted of complicated SQL statements for counting events inside the dataset. RapidMiner created some descent looking trees, but we found out that many charges in the legal system are very specific or can be written in multiple ways. For example traffic violations, i.e. speeding, improper driving, too fast/conditions, just to name a few are combined into Vehicle category. All in all the Vehicle categories flattens 54 vehicle related charges. Another example is the Public Intoxication category. This category includes: ped under influence, open containers, public intoxication, intoxication, and public drunkenness. One last example would be the Contempt of Court category. The charges are very specific to each court: contempt of court, contempt of mun ct, contempt/sup court.  In the end we were able to create 35 categories which more than one unique charge fell under.  Comparing to before we were mining on 213 different charges which did not produce any useful results.


##Results
We preformed data mining as a group of 3 undergraduate students. Many of our results contain personal information which we cannot release, but feel free to preform your own mining on your Thursday, Friday, and Saturday nights bc Computer Science students always have time during these hours. Joking aside, most of our test sets and tools are in this repo, except the data files form the listings, but if you look hard enough you can find a pre-processed set.


#Lets get start.

