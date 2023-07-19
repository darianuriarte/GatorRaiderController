package edu.ufl.cise.cs1.controllers;
import game.controllers.AttackerController;
import game.models.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class StudentAttackerController implements AttackerController {


	boolean flag = true; // Tells if there are vulnerable Defenders

	public void init(Game game) {
	}

	public void shutdown(Game game) {
	}

	public int update(Game game, long timeDue) {


		//Main Actors
		Attacker gator = game.getAttacker();
		Defender targetDefender = (Defender) gator.getTargetActor(game.getDefenders(), true);

		//Variables
		int actions = 3;
		Node target = gator.getTargetNode(game.getPillList(), true); //Pills Target

		//Update Target when Power Pills Are Available
		if (game.getPowerPillList().size() != 0) {
			target = gator.getTargetNode(game.getPowerPillList(), true);
		}

		//Execution
		//Check if there are vulnerable Defenders
		for (int i = 0; i < 4; i ++) {
			if (game.getDefender(i).isVulnerable() == true) {
				flag = true;
			}
		}

		// If Closest Defender is vulnerable then eat it. Else run away
		if (targetDefender.isVulnerable() == true) {
			actions = gator.getNextDir(targetDefender.getLocation(), true);
		} else if (targetDefender.getLocation().getPathDistance(gator.getLocation()) < 8 ) {
			actions = gator.getNextDir(targetDefender.getLocation(), false);
		}


		//If no vulnerable defenders and Power Pills Available. Get Power Pills
		if (flag == false && game.getPowerPillList().size() != 0 ){

			//Wait until Defender is close to eat powerpills
			if (gator.getLocation().getPathDistance(target) < 5 && gator.getLocation().getPathDistance(targetDefender.getLocation())
					> 5){
				actions = gator.getNextDir(target, false); //Stay close
			} else {
				actions = gator.getNextDir(target, true);
			}

			//Watch out for close Defenders
			if (targetDefender.getDirection() == gator.getDirection()) {
				actions = gator.getNextDir(targetDefender.getLocation(), false);
			}
		}

		//If no PowerPills Available and No Vulnerable Defenders. Eat regular pills
		if(game.getPowerPillList().size() == 0 && flag == false) {
			actions = gator.getNextDir(target, true);

			//Run Away if close Defender
			if (gator.getLocation().getPathDistance(targetDefender.getLocation()) < 7) {
				actions = gator.getNextDir(targetDefender.getLocation(), false);
			}
		}

		// Reset variable
		flag = false;

		//Return Next Action
		return actions;
	}

}

