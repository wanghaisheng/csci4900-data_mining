#!/bin/bash
NOW=$(date +"%Y%m%d")

wget http://api.athensclarkecounty.com/sheriff/jail/bookingreport.asp --referer=http://athensclarkecounty.com/1298/Arrests-from-the-Last-7-Days -O ~/Booking/booking.asp-$NOW
