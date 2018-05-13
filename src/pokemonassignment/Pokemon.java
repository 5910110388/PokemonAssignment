package pokemonassignment;

abstract class Pokemon{
	public final double maxHealth = 200;
	protected double health;
        protected double weight;
        protected double stepLength;
        protected double minWeight = 25;
	protected String name;
        
	protected PokemonSkill attackSkill;
	protected PokemonSkill untimatedSkill;
        

	public Pokemon(String name, double health, double weight, double stepLength){
		this.name = name;
		this.health = health;
                this.weight = weight;
                this.stepLength = stepLength;
	}

	public double getHealth(){
		return this.health;
	}

	public String getName(){
		return this.name;
	}
        
        public double getWeight(){
                return this.weight;
        }
        
        public double getStepLength(){
                return this.stepLength;
        }
	
	public void eat(Berry berry){
		this.health += berry.getRestoreValue();
		if(this.health > this.maxHealth)
			this.health = this.maxHealth;
                
	}

	public void attack(Pokemon rival){
		rival.injure(this.attackSkill);
	}

	public void untimate(Pokemon rival){
		rival.injure(this.untimatedSkill);
	}
        
	public void injure(PokemonSkill skill){
		this.reducedHealth(skill.getDamage());
	}

	public void reducedHealth(double value){
		this.health -= value;
		if(this.health < 0)
			this.health = 0;
	}
        
        public void reduceWeight(double value){
                this.weight -= value;
                if(this.weight < minWeight)
                        this.weight = minWeight;
        }
        
        public void increaseStepLength(double value){
                this.stepLength += value;
                if(this.health < 0)
			this.health = 0;
        }

        public void increaseHealth(double value){
                this.health += value;
		if(this.health >= maxHealth)
			this.health = maxHealth;
        }
        
	abstract public void move();
        
        abstract public void walk();

}
