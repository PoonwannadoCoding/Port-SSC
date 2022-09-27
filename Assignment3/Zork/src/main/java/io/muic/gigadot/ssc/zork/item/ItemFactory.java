package io.muic.gigadot.ssc.zork.item;

import io.muic.gigadot.ssc.zork.item.armor.Armor;
import io.muic.gigadot.ssc.zork.item.armor.ChestArmor;
import io.muic.gigadot.ssc.zork.item.armor.Helmet;
import io.muic.gigadot.ssc.zork.item.armor.PantArmor;
import io.muic.gigadot.ssc.zork.item.potion.HealPotion;
import io.muic.gigadot.ssc.zork.item.potion.Potion;
import io.muic.gigadot.ssc.zork.item.potion.SuperPotion;
import io.muic.gigadot.ssc.zork.item.shield.IronShield;
import io.muic.gigadot.ssc.zork.item.shield.Shield;
import io.muic.gigadot.ssc.zork.item.shield.WoodenShield;
import io.muic.gigadot.ssc.zork.item.weapon.Axe;
import io.muic.gigadot.ssc.zork.item.weapon.Sword;
import io.muic.gigadot.ssc.zork.item.weapon.Weapon;

import java.util.Locale;

public class ItemFactory {

    public Weapon createWeapon(String input){
        String weapon = input.toLowerCase(Locale.ROOT).trim();
        if(weapon.equals("sword")){
            return new Sword();
        }
        if(weapon.equals("axe")){
            return new Axe();
        }
        return null;
    }

    public Potion createPotion(String input){
        String potion = input.toLowerCase(Locale.ROOT).trim();
        if(potion.equals("healing potion")){
            return new HealPotion();
        }

        if(potion.equals("super potion")){
            return new SuperPotion();
        }
        return null;
    }

    public Shield createShield(String input){
        String shield = input.toLowerCase(Locale.ROOT).trim();
        if(shield.equals("wooden shield")){
            return new WoodenShield();
        }

        if(shield.equals("iron shield")){
            return new IronShield();
        }
        return null;
    }

    public Armor createArmor(String input){
        String armor = input.toLowerCase(Locale.ROOT).trim();
        if(armor.equals("chest armor")){
            return new ChestArmor();
        }
        if(armor.equals("helmet")){
            return new Helmet();
        }
        if(armor.equals("pant armor")){
            return new PantArmor();
        }
        return null;
    }




}
