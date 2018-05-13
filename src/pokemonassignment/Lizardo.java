package pokemonassignment;

public class Lizardo extends Pokemon implements Runnable{
	private static final int maxGroupHealth = 200;
	public Lizardo(){
		super("Lizardo", 120.00, 65.00, 250.00);

		this.attackSkill = PokemonSkill.getPokemonSkill("Ember");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("FireFang");
	}

	public void move(){
		this.run();
	}

	public void run(){
		this.reduceWeight(5);
                this.increaseHealth(2);
	}

	public void walk(){
		this.increaseHealth(0.5);
                this.increaseStepLength(1);
	}
}
