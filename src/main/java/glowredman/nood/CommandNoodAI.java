package glowredman.nood;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentTranslation;

public class CommandNoodAI extends CommandBase {

    @Override
    public String getCommandName() {
        return "noodai";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "commands.nood.noodai.usage";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            throw new CommandException("commands.nood.noodai.usage");
        }

        NoodAI ai = NoodAI.getInstance();

        if ("text".equals(args[0])) {
            if (args.length == 1) {
                throw new CommandException("commands.nood.noodai.failed.noprompt");
            }
            if (ai.getNumResponsesText() < 1) {
                throw new CommandException("commands.nood.noodai.failed.noresponses");
            }

            String prompt = String.join(" ", args)
                .substring(5);

            sender.addChatMessage(new ChatComponentTranslation("commands.nood.noodai.prompt", prompt));
            sender.addChatMessage(
                new ChatComponentTranslation("commands.nood.noodai.response.text.prefix", ai.getRandomText(prompt)));
            return;
        }
        if (!"mood".equals(args[0])) {
            throw new CommandException("commands.nood.noodai.usage");
        }
        if (ai.getNumResponsesMood() < 1) {
            throw new CommandException("commands.nood.noodai.failed.noresponses");
        }
        sender.addChatMessage(
            new ChatComponentTranslation("commands.nood.noodai.response.mood.prefix", ai.getRandomMood()));
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args.length != 1) {
            return null;
        }
        return getListOfStringsMatchingLastWord(args, "text", "mood");
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
