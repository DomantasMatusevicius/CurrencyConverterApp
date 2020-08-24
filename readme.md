1. This project is using MySQL to store locally the currencies convertion rates. So after installing MySQL. You'll need to:

Open the currencies.sql text file in your MySQL Local Instance and execute the script to create the currencies schema
and currency table.

2. The project is using locally stored xml file to consume currency exchange rates provided by Lietuvos bankas. Accordingly,
you will need to:

Change the pathname of getCurrentFxRates.xml in com.example.CurrencyConverterApp.tasks.GetCurrenciesJaxb class.


The project will run on a custom port 8999.

