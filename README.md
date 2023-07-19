# GatorRaider - StudentAttackerController

## Project Overview
GatorRaider is a version of PacMan, developed by UF students. I created a controller to allow the game attacker or PacMan to eat all the dots inside a closed maze while avoiding four defenders.

## Obtaining the Existing Code Base
This project requires students to work with an existing code base. The original GatorRaider code base can be obtained from the official Git repository hosted at: [https://github.com/uf-cise-cs1/gatorraider](https://github.com/uf-cise-cs1/gatorraider). Clone or download the repository to access the existing code and resources necessary for the project.

Certainly! Here's an example of a README file focusing on the `StudentAttackerController` class:

## Controller Implementation - StudentAttackerController
The `StudentAttackerController` class implements the `AttackerController` interface, which defines the methods required for controlling the attacker character. The `StudentAttackerController` class provides the following methods:

1. `public void init(Game game)`: This method is called once at the beginning of the game for initialization. In the provided implementation, the method is left empty.

2. `public int update(Game game, long timeDue)`: This method is called to update the actions of the attacker character based on the current game state. It takes the `game` object representing the game state and the `timeDue` parameter indicating the time limit for the update. The method returns an integer value representing the next direction for the attacker to move.

3. `public void shutdown(Game game)`: This method is called once at the end of the game for cleanup. In the provided implementation, the method is left empty.

### Implementation Logic
The `StudentAttackerController` implementation follows a specific logic to control the attacker character. Here is a summary of the key steps taken by the controller:

1. Initializing Variables: The implementation declares and initializes variables used for decision-making and tracking the game state.

2. Obtaining Game Objects: The implementation retrieves relevant game objects, such as the attacker (`gator`) and the closest vulnerable defender (`targetDefender`).

3. Updating Target: The implementation determines the target for the attacker based on the availability of power pills and regular pills. If power pills are available, the target is set to the closest power pill node; otherwise, it is set to the closest regular pill node.

4. Checking Vulnerable Defenders: The implementation checks if there are any vulnerable defenders by iterating over the defenders and setting a flag (`flag`) accordingly.

5. Decision-Making:

   - If the closest defender is vulnerable, the attacker attempts to eat it by setting the `actions` variable to the next direction towards the defender.
   
   - If the closest defender is not vulnerable but is within a certain distance, the attacker attempts to run away from the defender.
   
   - If there are no vulnerable defenders and power pills are available, the attacker focuses on getting the power pills. It tries to stay close to the power pill if it is already close but not close to the defender. Otherwise, it moves towards the power pill.
   
   - If there are no power pills available and no vulnerable defenders, the attacker focuses on eating regular pills. It moves towards the closest regular pill node and runs away from the closest defender if it is within a certain distance.

6. Resetting Flag: After decision-making, the `flag` variable is reset to false.

7. Returning Action: The implementation returns the final value of the `actions` variable, which represents the next direction for the attacker to move.

## Additional Resources
For a deeper understanding of the GatorRaider project and the provided code base, refer to the following resources:

- Explore the provided code base, including the model, view, and other controllers.
- Review the provided interfaces and classes related to the game state, such as `Game`, `Node`, `Maze`, `Actor`, `Attacker`, and `Defender` interfaces.


