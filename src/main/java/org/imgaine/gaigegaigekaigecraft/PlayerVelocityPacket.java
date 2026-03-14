package org.imgaine.gaigegaigekaigecraft;

import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

public class PlayerVelocityPacket {
   private final double vx;
   private final double vy;
   private final double vz;

   public PlayerVelocityPacket(double vx, double vy, double vz) {
      this.vx = vx;
      this.vy = vy;
      this.vz = vz;
   }

   public PlayerVelocityPacket(FriendlyByteBuf buf) {
      this.vx = buf.readDouble();
      this.vy = buf.readDouble();
      this.vz = buf.readDouble();
   }

   public static void encode(PlayerVelocityPacket message, FriendlyByteBuf buf) {
      buf.writeDouble(message.vx);
      buf.writeDouble(message.vy);
      buf.writeDouble(message.vz);
   }

   public static PlayerVelocityPacket decode(FriendlyByteBuf buf) {
      return new PlayerVelocityPacket(buf);
   }

   public static void handle(PlayerVelocityPacket message, Supplier<NetworkEvent.Context> ctx) {
      ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> {
         Minecraft mc = Minecraft.m_91087_();
         LocalPlayer player = mc.f_91074_;
         if (player != null) {
            player.m_20256_(new Vec3(message.vx, message.vy, message.vz));
         }

      });
      ((NetworkEvent.Context)ctx.get()).setPacketHandled(true);
   }
}
