package glowredman.nood.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import glowredman.nood.Nood;
import glowredman.nood.NoodItems;

public class ItemQuartzArmor extends ItemArmor {

    public ItemQuartzArmor(int armorType) {
        super(NoodItems.ARMOR_MATERIAL_QUARTZ, 0, armorType);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (slot == 2) {
            return Nood.MODID + ":textures/models/armor/quartz_layer_2.png";
        }
        return Nood.MODID + ":textures/models/armor/quartz_layer_1.png";
    }
}
