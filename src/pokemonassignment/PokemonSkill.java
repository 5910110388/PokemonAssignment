package pokemonassignment;

public class PokemonSkill{
	private String name;
	private float damage;

	public PokemonSkill(String name, float damage){
		this.name = name;
		this.damage = damage;
	}

	public String getName(){
		return this.name;
	}

	public float getDamage(){
		return this.damage;
	}

	public static PokemonSkill getPokemonSkill(String name){
		PokemonSkill skill = null;
		switch(name.toLowerCase()){
			case "thunder shock":
				skill = new PokemonSkill("Thunder Shock", 20);
				break;
			case "thunderbolt":
				skill = new PokemonSkill("Thunderbolt", 10);
				break;
			case "tail whip":
				skill = new PokemonSkill("Tail Whip", 10);
				break;
			case "water pulse":
				skill = new PokemonSkill("Water Pulse", 12);
				break;
                        case "quickattack":
                                skill = new PokemonSkill("QuickAttack", 8);
                                break;
                        case "tackle":
                                skill = new PokemonSkill("Tackle", 8);
                                break;
                        case "ember":
                                skill = new PokemonSkill("Ember", 10);
                                break;
                        case "firefang":
                                skill = new PokemonSkill("FireFang", 11);
                                break;
		}
		return skill;
	}
}
