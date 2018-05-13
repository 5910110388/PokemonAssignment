package pokemonassignment;

public class Pikachu extends Pokemon implements Runnable{
	private static final int maxGroupHealth = 200;
	public Pikachu(){
		super("Picachu", 155.00, 50.00, 1250.00);

		this.attackSkill = PokemonSkill.getPokemonSkill("Thunder Shock");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("Thunderbolt");
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
