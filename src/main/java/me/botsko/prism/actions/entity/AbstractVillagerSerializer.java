package me.botsko.prism.actions.entity;

import org.bukkit.entity.AbstractVillager;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created for the Prism-Bukkit Project.
 * Created by Narimm on 20/10/2020.
 */
public class AbstractVillagerSerializer extends EntitySerializer {

    protected List<PrismItemStack> inventory = new ArrayList<>();


    @Override
    protected void serializer(Entity entity) {
        super.serializer(entity);
        ((AbstractVillager) entity).getInventory().forEach(itemStack -> {
            if (itemStack != null) {
                inventory.add(PrismItemStack.fromBukkit(itemStack));
            }
        });
    }

    @Override
    protected void deserializer(Entity entity) {
        super.deserializer(entity);
        List<ItemStack> items = new ArrayList<>();
        inventory.forEach(prismItemStack -> items.add(prismItemStack.toBukkit()));
        ((AbstractVillager) entity).getInventory().setContents(items.toArray(new ItemStack[0]));

    }

}