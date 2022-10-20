This project aims to discuss some java API design and implementations tips (only java APIs, no Spring, no Hibernate....), 
it will be divided into parts(represented by packages) and each part will be divided into items.
I'll do my best to discuss one and only one thing per item, but sometimes, I have to discuss more than one in order to show similarities 
and differences between discussed subject. let's get started. 

Part A:
  In this part, we are going to see some tips about using Java Collections Framework.

Item 1: Arrays.asList
 - This utility method gives us a view on the original Array which can be used as List. The term view here is very important because 
 any chage in the original Object (the Array in this case) is reflected in the resulted Object (the List in this case). 
 - Changes in the resulted List are reflected in the intiial array. the purpose of this API is to make easy manipulating an array by viewing
  it as List, note that same rules applied to Arrays are applied to resulted List: updating objects of the resulted List in the array range is allowed 
  and resizing the List is not allowed (the code compiles but we get UnsupportedOperaionException on the execution)
  
 Item 2: Collections.unmodifiableList
  - This utility method gives us a view ( any chage in the original List is reflected in the resulted List) on the original List.
  - The resulted List is unmodifiable ie: updating objects of the resulted List or resizing it is not allowed (the code compiles but we get 
  UnsupportedOperaionException on the execution)