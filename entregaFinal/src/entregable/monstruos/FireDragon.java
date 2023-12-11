package entregable.monstruos;

import java.util.Arrays;
import java.util.List;

import entregable.ataques.FireBreath;
import entregable.ataques.Wind;
import entregable.ataques.Wings;
import game.attacks.Attack;
import game.attacks.Fire;
import game.components.Monster;
import game.components.PathBox;
import game.types.Type;

public class FireDragon extends Monster {
	
	private List<Attack> skills = Arrays.asList(new FireBreath(), new Wind()); //POSIBLE ERROR POR SER DE TIPOS DIFERENTES
	
	public FireDragon(String name) {
        this.life = 800;
        this.monsterName = name;
        this.activeSkill = skills.get(0);
        this.types = Arrays.asList(Type.BEAST, Type.FIRE, Type.WINGS);
    }

    @Override
    public void attack(Monster enemy) {
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }
    
    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        super.move(oldPathBox, newPathBox);
        if(activeSkill instanceof FireBreath) {
            this.activeSkill = skills.get(1);
        } else {
            this.activeSkill = skills.get(0);
        }
    }
}
