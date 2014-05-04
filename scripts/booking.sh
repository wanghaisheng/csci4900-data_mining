#!/bin/bash
NOW=$(date +"%Y%m%d")

wget http://api.athensclarkecounty.com/sheriff/jail/jailcurrent.asp --referer=http://athensclarkecounty.com/1299/Current-List-of-Inmates-Clarke-County-Ja -O ~/Booking/booking.asp-$NOW
