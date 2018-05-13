package pokemonassignment;

public class Eevee extends Pokemon implements Runnable{
	private static final int maxGroupHealth = 200;
	public Eevee(){
		super("Eevee", 80.00, 45.00, 750.00);

		this.attackSkill = PokemonSkill.getPokemonSkill("QuickAttack");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("Tackle");
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
