package lorien.legacies.legacies;

import org.lwjgl.input.Keyboard;

import lorien.legacies.core.LorienLegacies;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public abstract class Legacy {
	
	public String LEGACY_NAME = "[legacy name not set]";
	public String DESCRIPTION = "[description not set]";
	
	protected boolean toggled = false;
	
	//protected static boolean HAS_LEVELS;
	
	
	
	// Called every tick
	public abstract void computeLegacyTick(EntityPlayer player);
	
	public void blessedMessage(EntityPlayer player)
	{
		player.sendMessage(new TextComponentString(LEGACY_NAME + " - " + DESCRIPTION).setStyle(new Style().setColor(TextFormatting.YELLOW)));
	}
	
	public void toggle(EntityPlayer player)
	{
		if (!player.world.isRemote)
			player.sendMessage(new TextComponentString(LEGACY_NAME + " legacy toggled - set to " + !toggled).setStyle(new Style().setColor(TextFormatting.RED)));
		toggled = !toggled;
	}
	
	public void sendMessageClientside(EntityPlayer player, String message)
	{
		if (player.world.isRemote)
			player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.RED)));
	}
	
	public boolean getToggled() { return toggled; }
	
}
