function days(month,year){

  
   var lastDayOfMonth = new Date(year, month, 0);
   console.log(lastDayOfMonth.getDate());

}

days(2, 2021);