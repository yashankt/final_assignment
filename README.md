# Java File Handling Project


Find the occurence of the given word and if not specified then
of all the words in the given document. Document path and the
word should be consumed from the config file only.




## Important points:

- If the word is specified - return the frequency of that word.  
- If no word is specified - print the frequency of all the words in
  given document.  
- Handle exceptions wherever applicable.  
- Logging should be there.




## Sample Test Cases:

### Document:  
gemi mini gini gemi mine gini  
gemi mini gini gemi mine gini

### Test 1: When no word is given:
**Output:**  
gemi - 4  
mini - 2  
mine - 2  
gini - 4

### Test 2: When the word given is: "gemi"
**Output:**  
gemi - 4  

### Test 2: When the word given is: "Gemini"
**Output:**  
Gemini - 0  





## Tech Stack

**Language:** Java

**Classes:** Scanner, Logger, File Handler, File Reader, File Writer, 
Log Manager

**Data Structure:** Hashmap<String, Integer>

## Contributions

**Contributor:** Yashank Tiwari
