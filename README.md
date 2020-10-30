# Tutorial
How to use the ticket order processing program.

This program has 5 separate classes, with different functions which will process ticket orders inputed by machine or user, ticket orders will be put in
the Values.txt file and everything should be handled automatically. If any errors occur, an error message will be printed out on the system and will
be outputed in the Log.txt file, where will be able to know the date where the input occured, what line of the Values.txt file an error occured, what the
program was supposed to recieved, and what the program recieved.

The classes are ordered on what the programs runs from first to last.

Main.java class - 
  This class will tell the other classes what to do, first it tells the read file class to read the input file, store the values in an array
  which contains other customer order information, and tells the output file what to output. 
  Do not edit anything in this file other than the number of inputs.

ReadFile.java class - 
  This class contains the Scan file method which gets the number of inputs that are supposed to be read, 
  and the number of customers that it's supposed to register. 
  First the method gets the input file (Values.txt), reads the first line of the code, which is the number of customer orders. 
  Then from there, It begins to read the input file, storing all customer information (email, standard ticket orders, vip ticket orders)
  into an 2d array, where it will be sent to another 2d array in Main.java, where new Customer objects would be created. 
  This is also where input errors are checked, if there are any input errors, a message will be printed out on the system and 
  the error will be logged in ErrorLog.txt.
  
CustomerInformation.java class -
  This class contains the Customerinformation constructor, containing customer ticket orders, VIP ticket orders and email. This class
  helps order customers and makes sure their orders and processed through our program.

Lotter.java class -
  This class contains the Randomize order method, this method gets the customer queue from main,
  scambles it and returns it.

WriteFile.java class -
  This class contains the OutputFile method, this is where all of the customer infromation will be printed in the
  Output.txt file.
  
ErrorLog.java class -
  If there are any errors in the program, the Output log method will log the errors with a time stamp.
