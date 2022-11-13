This project aims to discuss some java API design and implementations tips (only java APIs, no Spring, no Hibernate....), 
it will be divided into parts(represented by packages) and each part will be divided into items.
I'll do my best to discuss one and only one thing per item, but sometimes, I have to discuss more than one in order to show similarities 
and differences between discussed subject. let's get started.

Part A:
  The main lack in Java Collections Framework is a clear separation between mutable and immutable collections in the API level,
  this separation is left to implementation details. This lack has the following consequences: we have to dig in implementation details to 
  know what is collection's type, worst, a code that works fine in a given version may break at execution time in a next version (it still 
  compiles). In this part, we are going to see some tips about Collections and ways to avoid bugs like those mentioned earlier.

Item 1: Arrays.asList:
 - This utility method gives us a view on the original Array which can be used as List. The term view here is very important because 
 any chage in the original Object (the Array in this case) is reflected in the resulted Object (the List in this case).
 - Changes in the resulted List are reflected in the intiial array. the purpose of this API is to make easy manipulating an array by viewing
  it as List, note that same rules applied to Arrays are applied to resulted List: updating objects of the resulted List in the array range is allowed 
  and resizing the List is not allowed (the code compiles but we get UnsupportedOperaionException on the execution).
  
 Item 2: Collections.unmodifiableList, Collections.unmodifiableSet, Collections.unmodifiableMap:
  - This utility method gives us a view ( any chage in the original Collection is reflected in the resulted Collection) on the original Collection.
  - The resulted Collection is unmodifiable ie: updating objects of the resulted Collection or resizing it is not allowed (the code compiles but we get 
  UnsupportedOperaionException on the execution).
  
 Item 3: List.of, Set.of, Map.of:
  - This utility method allows to create an immutable Collection. An immutable Collection, unlike unmodifiable Collection, cannot be modified (updated or resized) once created 
  either we have a reference to it or not(see the item 2 to understand how to modify an unmodifiableList by holding a reference to the initial object). Any attempt of modifying the Collection 
  will result in UnsupportedOperaionException at execution time.
  
  Item 4: List.copyOf, Set.copyOf, Map.copyOf:
  - This utility method allows to create an immutable Collection. unlike List.of, Set.of and Map.of which always create a new Collection, copyOf is optimized in the sense that: if the passed Collection is mutable, 
  it creates a new Collection and copy all the elements of the passed Collection into the new one, if the passed Collection is immutable, copyOf does not create a new Collection it just returns a reference
  to the passed Collection. Any attempt of modifying the Collection created by copyOf will result in UnsupportedOperaionException at execution time.