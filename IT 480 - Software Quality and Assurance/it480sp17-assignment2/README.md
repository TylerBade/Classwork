# Assignment 2 - Test Plan
You will do this assignment in teams of two. There will be time in class to create teams. You must get explicit permission from me to have any other size of team.  

For this assignment, your group will create a test plan for the simple game Coffee Maker Quest, based on the requirements listed. There are several known defects in the software; you will need to find and report on at least three. Additionally, you must create a *traceability matrix* showing the mapping of test cases to requirements.  

There should be at least as many test cases as requirements. A general rule of thumb is that if you have less than 2x as many test cases as requirements, you're probably doing too little, but if you have more than 4x as many test cases as requirements, consider whether you are over-testing.  

Each requirement should have AT LEAST one test case associated with it, and each test should have EXACTLY ONE requirement associated with it. This can easily be checked via a traceability matrix, which you should also deliver. If you don't like the format in the book, you can use e.g. the table format shown in https://en.wikipedia.org/wiki/Traceability_matrix  

Test cases should mention all necessary preconditions, input values, execution steps, output values, and postconditions.  

It is NOT necessary to make multiple test plans inside a test suite; it is enough for there to be one test plan.  

I expect you to test several edge cases as part of the test plan.  

It is expected that you actually execute the test plan in order to find the defects. There are AT LEAST three defects. Full credit will be given only to those who properly find and describe at least three.  

## Format

Hand me a printed document whose first page shows:

- The name of the project under test
- The names of the people in the group
- The title "IT 480/580 Test Plan and Traceability Matrix"

The first page should also include a short introduction in which you may note any concerns or difficulties you may have had or anticipate with the testing process. You could also note why you considered certain test cases, how you thought of edge cases, etc.  

ON A NEW PAGE, include a list of test cases. You may name or number them any way you wish, but be consistent. Here is a sample format: 

    IDENTIFIER:
    TEST CASE:
    PRECONDITIONS:
    INPUT VALUES:
    EXECUTION STEPS:
    OUTPUT VALUES:
    POSTCONDITIONS:
    
ON A NEW PAGE, provide a traceability matrix which maps the test cases and their associated requirements. Remember that all requirements should map to AT LEAST ONE test case, and all test cases should map to EXACTLY ONE requirement.  

ON A NEW PAGE, list at least three defects found. The defects should follow the following defect reporting template:  

    TITLE:
    DESCRIPTION:
    REPRODUCTION STEPS:
    EXPECTED BEHAVIOR:
    OBSERVED BEHAVIOR:
    
Other attributes of a defect (e.g., SEVERITY or IMPACT) are not necessary. The test case which found the defect should be listed as part of the SUMMARY.  

## Grading

- Introduction: 10% of grade
- Test Plan: 40% of grade
- Traceability Matrix: 20% of grade
- Defects Found and Described: 30% of grade

## Tips

Be as precise as possible. Don't say "Ensure that you see the correct value"; say that "You should see the text 'A Smart door leads South'". Don't say that you should "go north"; say "Type n ".  

Remember to put down all the necessary steps and preconditions!  

The "Test Case" label is for a description of the test case in plain English. For example, "Ensure that user can go North from the starting room."  

You do not need to exhaustively test the application! If you find yourself with more than four test cases per requirement, you may be over-testing. This is admirable in software where human life is at stake, but this is only your grade. 

This is a test plan, not a test run - remember the difference.  

Note that if you find yourself in a magical land - even if you get transported back to where you came from - you may have gone through a door which did not exist. Think about if that meets the requirements or not.  

Remember that tests should be reproducible - starting with all preconditions met, anybody should be able to reproduce the same steps and get the same results. If they can't, rethink your preconditions!  

If anything is unclear, please post on Piazza and use the "Assignment 2" tag. This ensures that the entire class can see any clarifications.  

## Coffee Maker Quest

Coffee Maker Quest is a simple game. The goal is to get coffee, sugar, and cream, and then drink it so that you can stay up and study. In order to do so, you need to visit several rooms in a house and look around. Once you have obtained all the necessary elements, you win. If you decide to drink before getting all of the necessary elements, you lose.  

You can run it from the associated coffeemaker.jar file:

```bash
java -jar coffeemaker.jar
```

## Requirements

- FUN-ITERATION - At each iteration of the game, the user shall be able enter one of six commands - "N" to go North, "S" to go South, "L" to Look for items, "I" for Inventory, "H" for Help, or "D" to Drink.
- FUN-UNKNOWN-COMMAND - If a player enters a command not specified by FUN-ITERATION, the system shall respond with the phrase "What?".
- FUN-INPUT-CAPS - The system shall be case-insensitive in regards to input values; that is, it shall accept capital and lower-case letters and treat them as equivalent.
- FUN-MOVE - The system shall allow a player to move North only if a door exists going North, and South only if a door exists going South.
- FUN-WIN - The player shall win the game if and only if Coffee, Sugar, and Cream have been collected by the player and then drunk.
- FUN-LOSE - The player shall lose the game if and only if the player Drinks but has not collected all of the items (Coffee, Sugar, and Cream).
- FUN-INVENTORY - Upon entering "I" for inventory, the player shall be informed of the items that he/she has collected (consisting of Coffee, Sugar, and Cream).
- FUN-LOOK - Upon entering "L" for Look, the player shall collect any items in the room and those items will be added to the player's inventory.
- FUN-HELP - Upon entering "H" for Help, the player shall be shown a listing of possible commands and what their effects are.
- FUN-UNIQ-ROOM - Each room in the house shall have a unique adjective describing it.
- FUN-UNIQ-ROOM-FURNISHING - Each room in the house shall have one and only one unique furnishing visible to the user upon entering the room.
