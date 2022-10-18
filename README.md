This project aims to discuss some java API design and implementations tips (only java APIs, no Spring, no Hibernate....), 
it will be divided into parts(represented by packages) and each part will be divided into items.
I'll do my best to discuss one and only one thing per item, but sometimes, I have to discuss more than one in order to show similarities 
and differences between discussed subject. let's get started. 

Part a:
  In this part, we are going to see some tips about using Java Collections Framework.

Item 1: Arrays.asList
 - This utility method gives us a view on the original Array which can be used as List. The term view here is very important because 
 any chages in the original Object (the Array in this case) is reflected in the resulted Object (the List in this case). 
 - Changes in the resulted List are reflected in the intiial array. the purpose of this API is to make easy manipulating an array by viewing
  it as List, note that same rules applied to Arrays are applied to resulted List: updating objects in the array range is allowed and resizing is forbidden