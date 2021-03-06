package net.tslat.aoa3.utils;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.tslat.aoa3.advent.AdventOfAscension;
import net.tslat.aoa3.client.gui.GuiManager;
import net.tslat.aoa3.common.packet.*;
import net.tslat.aoa3.common.packet.leaderboard.PacketLeaderboardStats;

public class PacketUtil {
	public static SimpleNetworkWrapper network;

	public static void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(AdventOfAscension.instance(), new GuiManager());
		network = NetworkRegistry.INSTANCE.newSimpleChannel("AoAPackets");

		registerPackets();
	}

	private static void registerPackets() {
		network.registerMessage(PacketResourceData.Handler.class, PacketResourceData.class, 0, Side.CLIENT);
		network.registerMessage(PacketExpeditionToggle.Handler.class, PacketExpeditionToggle.class, 1, Side.SERVER);
		network.registerMessage(PacketHealthMod.Handler.class, PacketHealthMod.class, 2, Side.CLIENT);
		network.registerMessage(PacketScreenOverlay.Handler.class, PacketScreenOverlay.class, 3, Side.CLIENT);
		network.registerMessage(PacketRecoil.Handler.class, PacketRecoil.class, 4, Side.CLIENT);
		network.registerMessage(PacketSkillData.Handler.class, PacketSkillData.class, 5, Side.CLIENT);
		network.registerMessage(PacketTributeData.Handler.class, PacketTributeData.class, 6, Side.CLIENT);
		network.registerMessage(PacketLongReachWeaponHit.Handler.class, PacketLongReachWeaponHit.class, 7, Side.SERVER);
		network.registerMessage(PacketXpGain.Handler.class, PacketXpGain.class, 8, Side.CLIENT);
		network.registerMessage(PacketLeaderboardStats.Handler.class, PacketLeaderboardStats.class, 9, Side.CLIENT);
		network.registerMessage(PacketChangedHalo.Handler.class, PacketChangedHalo.class, 10, Side.SERVER);
		network.registerMessage(PacketPlayerHaloInfo.Handler.class, PacketPlayerHaloInfo.class, 11, Side.CLIENT);
		network.registerMessage(PacketToastPopup.Handler.class, PacketToastPopup.class, 12, Side.CLIENT);
		network.registerMessage(PacketGuiData.Handler.class, PacketGuiData.class, 13, Side.SERVER);
	}
}
