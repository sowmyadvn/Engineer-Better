## How are maps stored in memory?
https://stackoverflow.com/questions/10894558/how-hashtable-and-hashmap-key-value-are-stored-in-the-memory
The basic idea of HashMap is this:

A HashMap is really an array of special objects that hold both Key and Value.
The array has some amount of buckets (slots), say 16.
The hashing algorithm is provided by the hashCode() method that every object has. Therefore, when you are writing a new Class, you should take care of proper hashCode() and equals() methods implementation. The default one (of the Object class) takes the memory pointer as a number. But that's not good for most of the classes we would like to use. For example, the String class uses an algorithm that makes the hash from all the characters in the string - think of it like this: hashCode = 1.char + 2.char + 3.char... (simplified). Therefore, two equal Strings, even though they are on a different location in the memory, have the same hashCode().


The result of hashCode(), say "132", is then the number of bucket where the object should be stored if we had an array that big. But we don't, ours is only 16 buckets long. So we use the obvious calculation 'hashcode % array.length = bucket' or '132 mod 16 = 4' and store the Key-Value pair in a bucket number 4.

If there's no other pair yet, it's ok.
If there's one with Key equal to the Key we have, we remove the old one.
If there's another Key-Value pair (collision), we chain the new one after the old one into a linked list.
If the backing array becomes too full, so we would have to make too many linked lists, we make a new array with doubled length, rehash all the elements and add them into the new array, then we dispose the old one. This is most likely the most expensive operation on HashMap, so you want to tell your Maps how many buckets you'll use if you know it in before.
If somebody tries to get a value, he provides a key, we hash it, mod it, and then go through the potential linked list for the exact match.

In this case,
there is an array with 256 buckets (numbered, of course, 0-255)
there are five people. Their hashcodes, after being put through mod 256, point to four different slots in the array.
you can see Sandra Dee didn't have a free slot, so she has been chained after John Smith.
Now, if you tried to look up a telephone number of Sandra Dee, you would hash her name, mod it by 256, and look into the bucket 152. There you'd find John Smith. That's no Sandra, look further ... aha, there's Sandra chained after John.


## How is lookup time O(1) in hash maps?
