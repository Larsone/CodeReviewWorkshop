# Code Review Workshop

## Introduction

Code Reviews are apart of the Software Lifecycle; this exercise is designed to introduce you to the process. The code itself is the worst thing I’ve ever written, it has some some nightmare inducing situations, multiple standards and the less said about the comments the better. The code can be used as baseline, an instructor can lead a team through the code, allowing them to run the exercise to best match the approach the team wants to enforce.

## Suggested Run
* Introduction (2 mins)
* Explain (5 mins)
  * How a code-review functions
  * That most errors are caught in a code review
  * That the goal is not pass judgement but to improve the code and in turn the author
* Show the class the code (FileChecker.java) and explain the exercise (3 minutes to explain, 20 minutes to review)
  * “You will have 20 minutes in your pairs to review this code, the scenario is a follows: A merge request has been raised and author wants it merged into the master branch. You have been assigned to review the code and approve that merge: What feedback would you give? What issues can you find? Feel free to be as critical as you like, though remember you have to give this feedback to the author so try to be constructive! You likely won’t find everything and that’s ok, as you hopefully will never have to review anything quite like this… The code is written in Java, don’t worry if you don’t know Java, focus on aspects common to whatever language you do know that you feel you could feed back.”
  * Split the class into pairs or small groups
  * They will then have 20 minutes to review the code
* Come back together and go around the room, asking each group to feedback one of their points; ideally each group should raise different points (15mins)
* Show the class a review checklist, one is included as a generic template, and talk through how this can help in the process (5 mins)
  * It may help at this point to raise any potential changes or inclusions the team may want to this checklist
* Show any [Advanced](#adv) points, below that were missed (5 mins)
* Conclusion and wrap up (5 mins)

The run should come in under an hour with room for questions and interaction.

## Issues Within the Code

This is a list of some of the issues within in the code that those doing the workshop may find (don't cheat):
### Basics
* There is no testing
   * I toyed with the idea of adding some assertTrue(true) statements but ultimately the complete lack of tests speaks more
* Comments are inapropriate 
   * Comments mocking product owners
   * Console prints in if statements, even if they should be unreachable
   * Commented out code, despite this being merged to master
   * TODO still in code
   * Pointless comments
* Code convention (includes variable naming etc.)
   * Convention is always changing
   * Company likely has an agreed code convention:
      * In Java this is likely to be Camel Case:
         * Variable: myVariable
         * Function: myFunction()
         * Class: MyClass
         * Constant: MYCONSTANT
         * etc.
      * In Python this is likely to be Snake Case:
         * Variable: my_variable
         * Function: my_function()
         * Class: My_Class
         * Constant: MY_CONSTANT
         * etc.
   * Some names are meaningless, for example _59998r is a 'return' vale
   * Some are needlessly long and overdone, a_single_item_in_my_list_of_things_i_want_to_check would be fine as 'item'
* Obtuse code
   * Some code is very complicated, shifted into "contractor style" one liners
   * As a rule, if it takes more than a quick glance to understand what is happening the line is too complicated
* Data type misuse
   * Why return a String for "yep" or "nope" when what is really needed is a Boolean

<a name="adv"></a>
### Advanced 
Some may notice more advanced points around this implementation; here are a couple of things they may notice:
 
* It doesn't work...
   * Hopefuly you don't need to be a Java developer to see that the outline at the top is not what this code does, all you would see in Kafka is yeps...
* Terrible exception handling
   * Exception are thrown multiple times then never handled, code will silently fail
* Hard coded variables
   * The comment indicates that the check list is often changed, why is it hard coded?
* File is read multiple times
   * For every word in the array we re-open the file to read
   * The file is never closed
   * It should be read into memory and inspected there