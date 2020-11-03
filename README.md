# Training Guide
About the program:

This program has 5 separate classes, with different functions which will process ticket requests read from the Values.txt file. 
There is no user input required and the only thing that needs to be changed by the user is the data stored in the Values.txt file 
or the pathway for the filereader, if the user wants to use their own file and do not want to place their data in the already made 
Value.txt file. The steps as to how to change the data in the Values.txt file or change the pathway of the filereader will be 
explained later in the steps for the “How to Use the Program” section of this guide. The steps will also include how to access 
the Output.txt file, if you wish to do so. If any errors occur in the program, an error message will be printed out to the console 
and will also be recorded in the Log.txt file. The error message will include the date in which the error occurred, what line of the 
Values.txt file caused the error, what the program was expecting to receive, and what the program actually received.

  ----------------------------------------------------------------------------------------------------------

Main.java class - 

  This class will call the other classes in order to calculate or output information. This class calls the other classes in the order 
  of which it requires them. The classes that the Main class will call include: the ReadFile class, the Lottery class, the CustomerInformation 
  class, and the WriteFile class, which are all of the other classes in the program excluding the ErrorLog class. All of these classes will be 
  explained in their respective sections of this guide.

  ----------------------------------------------------------------------------------------------------------

ReadFile.java class - 

  The ReadFile class is the class which reads the input file, and stores the emails as well as each of the emails’ associated ticket requests. 
  This class also calls a method from the ErrorLog class, to output to the ErrorLog.txt file if an input error occurs. To further explain how 
  the process works, the program reads the first line from the Values.txt file (Or whatever input file that the user chooses to read from, if 
  the user chooses to change the file) to find out how many ticket requests are in the file. The program then continues to read the input file 
  for the ticket requests which are stored in a 2D array.
  
  ----------------------------------------------------------------------------------------------------------
  
CustomerInformation.java class -

  The CustomerInformation class is used so that each email with its ticket request is created as a new customer. The data stored includes the 
  email address, the number of requested standard tickets, and the number of requested VIP tickets. The Main class stores all of the customers 
  from this class individually in an array.

  ----------------------------------------------------------------------------------------------------------

Lottery.java class -

  The lottery class is for performing the lottery to randomly order the ticket requests. It includes the RandomizeOrder method which does the 
  calculations for the lottery and determines the order in which the ticket requests will be fulfilled, if there are enough tickets available 
  to fulfill the ticket request. It then stores the randomized order back in the array of customers.

  ----------------------------------------------------------------------------------------------------------

WriteFile.java class -

  The WriteFile class matches the ticket requests with tickets, if there are enough tickets available to fulfill the request, and generates email 
  text depending on if the ticket request could be matched with tickets or not. Then, this class writes the email text produced for each ticket 
  request to the Output.txt file.
  
  ----------------------------------------------------------------------------------------------------------
  
ErrorLog.java class -

  The ErrorLog class tests any errors that occurred from the input file, if any, and writes them to the ErrorLog.txt file, and also outputs them to the console.
  
  
  ----------------------------------------------------------------------------------------------------------

How to use the program:
  1. Put inputs in the Values.txt file, and make sure the input file is connected to the program.
  
    Before explaining how to format the input file you first need to make sure that you have 
    the right file connected to the program. There are 2 options here, use the already created 
    input file called Values.txt, or use your own input file.
    
    To use the already created Values.txt file follow these steps:
    Look inside the file in which the program is stored in and find the file called Values.txt
    Open this file and follow the formatting instructions discussed in the “Formatting Instructions” section.
    
    To use your own file
    Open the program in your IDE
    Open the ReadFile.java class
    On line 70, where it says “Values.txt” change it so that it says “YourFileName.txt” (YourFileName being the name of your file)
    Make sure that your file is located in the same location where the Values.txt file was located, 
    or specify the pathway within the quotations as well. For example: "C:/Users/arian/Desktop/TicketPoll4-main/Values.txt"
    
    Proceed to the formatting instructions in the following section
    
    
    Formatting Instructions:
    
    The first line must be the number of customers that have requested tickets, if 6 customers have requested tickets, 
    the first line must be 6, or the program will not work. The format for each of the customers will be the email address in one line, 
    the number of standard tickets requested in the following line, and the number of VIP tickets requested in the line after that. 
    
    An example of the input file is:
    
    3
    sampleemail1@tdsb.on.ca
    2
    1
    sampleemail2@tdsb.on.ca
    3
    0
    sampleemail3@tdsb.on.ca
    1
    3
    
    In this example there are 3 customers requesting tickets. The first line is the number of customers. 
    Then, each of the lines are following the format stated above. 
    In the 2nd line is the first customers email, in the third line is the number of standard tickets they are 
    requesting and in the fourth line is the number of VIP tickets         
    they are requesting. Each following customer follows the same format.

  
  2. Just wait for the program to run, the output will be found in Output.txt file, in this file,
  it will contain the customer's email and and email text message.
  
    To run the program open the program in your IDE and after it has finished loading open the main class and locate the run option. 
    The instructions can not get much more specific here, as many IDEs have different formats and locations for running classes, 
    or the run class button. If you can not locate the run button or need further instruction on how to run a class, 
    it is suggested to search up something similar to the following example on your favourite search engine: 
    
    “How to run a class on MyIDE” (MyIDE being whichever IDE you are using).
    
    Once you have run the program, you should be able to locate the Output.txt file on your IDE and in the file 
    that the program is stored in (The same file which the Values.txt, if you have chosen to use that input file 
    instead of another one, and all of the classes are stored in). In this file you will be able to see all of 
    the emails of the ticket requests, and email text stating whether they were fulfilled or not. An example of this, 
    using the same example used in step 1 for formatting an input file is:
    
    <<EMAIL>>
    sampleemail3@tdsb.on.ca
    Your ticket order of 1 standard ticket(s) and 3 VIP ticket(s) has been fulfilled...
    Enter your email and password and you will be sent to our secure payment system to finish your transaction.
    <<END EMAIL>>
    <<EMAIL>>
    sampleemail2@tdsb.on.ca
    Your ticket order of 3 standard ticket(s) and 0 VIP ticket(s) has been fulfilled...
    Enter your email and password and you will be sent to our secure payment system to finish your transaction.
    <<END EMAIL>>
    <<EMAIL>>
    sampleemail1@tdsb.on.ca
    Your ticket order of 2 standard ticket(s) and 1 VIP ticket(s) has been fulfilled...
    Enter your email and password and you will be sent to our secure payment system to finish your transaction.
    <<END EMAIL>>
