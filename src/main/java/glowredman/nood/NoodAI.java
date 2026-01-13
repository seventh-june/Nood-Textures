package glowredman.nood;

import java.util.Random;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;

/*
 * NOTE: Although this "AI" is artificial, it is not intelligent. In fact it is really stupid. Also: no AI whatsoever
 * has been used in the creation of this thing (this is also true for the responses). All bugs and mistakes were proudly
 * introduced by me. - glowredman, January 2026
 */
public class NoodAI implements IResourceManagerReloadListener {

    private static NoodAI instance;

    private int numResponsesText;
    private int numResponsesMood;

    public NoodAI() {
        ((IReloadableResourceManager) Minecraft.getMinecraft()
            .getResourceManager()).registerReloadListener(this);
    }

    static void init() {
        instance = new NoodAI();
    }

    /**
     * {@code null} if called before pre-init or on the server side
     */
    @Nullable
    public static NoodAI getInstance() {
        return instance;
    }

    @Nonnegative
    public int getNumResponsesText() {
        return this.numResponsesText;
    }

    public IChatComponent getRandomText(@Nonnull String prompt) {
        Random rng = new Random();
        if (rng.nextFloat() >= NoodConfig.aiRandomness) {
            rng.setSeed(prompt.hashCode());
        }
        return new ChatComponentTranslation("commands.nood.noodai.response.text." + rng.nextInt(this.numResponsesText));
    }

    public IChatComponent getRandomMood() {
        return new ChatComponentTranslation(
            "commands.nood.noodai.response.mood." + new Random().nextInt(this.numResponsesMood));
    }

    @Nonnegative
    public int getNumResponsesMood() {
        return this.numResponsesMood;
    }

    @Override
    public void onResourceManagerReload(IResourceManager manager) {
        try {
            this.numResponsesText = Integer
                .parseInt(StatCollector.translateToLocal("commands.nood.noodai.response.text.num"));
        } catch (NumberFormatException e) {
            Nood.LOGGER.error("Failed to parse number of text responses", e);
            this.numResponsesText = 0;
        }
        try {
            this.numResponsesMood = Integer
                .parseInt(StatCollector.translateToLocal("commands.nood.noodai.response.mood.num"));
        } catch (NumberFormatException e) {
            Nood.LOGGER.error("Failed to parse number of mood responses", e);
            this.numResponsesMood = 0;
        }
    }

}
