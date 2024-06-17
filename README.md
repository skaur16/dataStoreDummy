# DataStore 

## Objective
To save a list of data using datastore.
It is mostly needed to save the data list in local device, yet the data is not usually very huge. 
Using Room DB for smaller data can be unnecessary chaos whereas datastore only saves a single object.
Here is the code snippet to find a mid way solution to such problems.

## Steps to be followed
1. Create a DataStore class (StoreData) which contains the method definitions for get and set method.
2. Create a data class to save the data in desired object form.
3. Another data class containing a list of the object.
4. Keep adding values to the latter list variable.
5. Then, using GSon converter, set the data in datastore.
6. And, using JSon converter, fetch the data from datastore.
7. Display the data as per requirement.
