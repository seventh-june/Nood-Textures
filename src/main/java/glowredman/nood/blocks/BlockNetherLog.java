package glowredman.nood.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNetherLog extends BlockLog {

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        this.field_150167_a = new IIcon[] { reg.registerIcon(this.getTextureName()) };
        this.field_150166_b = new IIcon[] { reg.registerIcon(this.getTextureName() + "_top") };
    }
}
