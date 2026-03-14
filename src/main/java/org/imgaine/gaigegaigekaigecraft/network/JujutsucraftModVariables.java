package org.imgaine.gaigegaigekaigecraft.network;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Supplier;
import org.imgaine.gaigegaigekaigecraft.JujutsucraftMod;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftModVariables {
   public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
   });

   public JujutsucraftModVariables() {
   }

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      JujutsucraftMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
      JujutsucraftMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
   }

   @SubscribeEvent
   public static void init(RegisterCapabilitiesEvent event) {
      event.register(PlayerVariables.class);
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
   }

   @EventBusSubscriber
   public static class EventBusVariableHandlers {
      public EventBusVariableHandlers() {
      }

      @SubscribeEvent
      public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            for(Entity entityiterator : new ArrayList(event.getEntity().m_9236_().m_6907_())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            for(Entity entityiterator : new ArrayList(event.getEntity().m_9236_().m_6907_())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            for(Entity entityiterator : new ArrayList(event.getEntity().m_9236_().m_6907_())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void clonePlayer(PlayerEvent.Clone event) {
         event.getOriginal().revive();
         PlayerVariables original = (PlayerVariables)event.getOriginal().getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables());
         PlayerVariables clone = (PlayerVariables)event.getEntity().getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables());
         clone.flag_sukuna = original.flag_sukuna;
         clone.FlagSixEyes = original.FlagSixEyes;
         clone.noChangeTechnique = original.noChangeTechnique;
         clone.PlayerFlag_A = original.PlayerFlag_A;
         clone.friend_num_keep = original.friend_num_keep;
         clone.PlayerCursePower = original.PlayerCursePower;
         clone.PlayerCursePowerFormer = original.PlayerCursePowerFormer;
         clone.PlayerCursePowerMAX = original.PlayerCursePowerMAX;
         clone.PlayerCurseTechnique = original.PlayerCurseTechnique;
         clone.PlayerCurseTechnique2 = original.PlayerCurseTechnique2;
         clone.PlayerExperience = original.PlayerExperience;
         clone.PlayerFame = original.PlayerFame;
         clone.PlayerLevel = original.PlayerLevel;
         clone.PlayerProfession = original.PlayerProfession;
         clone.PlayerSelectCurseTechnique = original.PlayerSelectCurseTechnique;
         clone.PlayerSelectCurseTechniqueCost = original.PlayerSelectCurseTechniqueCost;
         clone.PlayerSelectCurseTechniqueCostOrgin = original.PlayerSelectCurseTechniqueCostOrgin;
         clone.PlayerTechniqueUsedNumber = original.PlayerTechniqueUsedNumber;
         clone.OverlayCost = original.OverlayCost;
         clone.OverlayCursePower = original.OverlayCursePower;
         clone.PlayerSelectCurseTechniqueName = original.PlayerSelectCurseTechniqueName;
         clone.BodyItem = original.BodyItem;
         if (!event.isWasDeath()) {
            clone.flag_shift = original.flag_shift;
            clone.PassiveTechnique = original.PassiveTechnique;
            clone.PhysicalAttack = original.PhysicalAttack;
            clone.PlayerFlag_B = original.PlayerFlag_B;
            clone.SecondTechnique = original.SecondTechnique;
            clone.cnt_curse1 = original.cnt_curse1;
            clone.PlayerCharge = original.PlayerCharge;
            clone.PlayerCursePowerChange = original.PlayerCursePowerChange;
            clone.OVERLAY1 = original.OVERLAY1;
            clone.OVERLAY2 = original.OVERLAY2;
            clone.use_mainSkill = original.use_mainSkill;
         }

         if (!event.getEntity().m_9236_().m_5776_()) {
            for(Entity entityiterator : new ArrayList(event.getEntity().m_9236_().m_6907_())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            SavedData mapdata = JujutsucraftModVariables.MapVariables.get(event.getEntity().m_9236_());
            SavedData worlddata = JujutsucraftModVariables.WorldVariables.get(event.getEntity().m_9236_());
            if (mapdata != null) {
               JujutsucraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new SavedDataSyncMessage(0, mapdata));
            }

            if (worlddata != null) {
               JujutsucraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new SavedDataSyncMessage(1, worlddata));
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            SavedData worlddata = JujutsucraftModVariables.WorldVariables.get(event.getEntity().m_9236_());
            if (worlddata != null) {
               JujutsucraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new SavedDataSyncMessage(1, worlddata));
            }
         }

      }
   }

   public static class WorldVariables extends SavedData {
      public static final String DATA_NAME = "jujutsucraft_worldvars";
      static WorldVariables clientSide = new WorldVariables();

      public WorldVariables() {
      }

      public static WorldVariables load(CompoundTag tag) {
         WorldVariables data = new WorldVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
      }

      public CompoundTag m_7176_(CompoundTag nbt) {
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.m_77762_();
         if (world instanceof Level level) {
            if (!level.m_5776_()) {
               SimpleChannel var10000 = JujutsucraftMod.PACKET_HANDLER;
               PacketDistributor var10001 = PacketDistributor.DIMENSION;
               Objects.requireNonNull(level);
               var10000.send(var10001.with(level::m_46472_), new SavedDataSyncMessage(1, this));
            }
         }

      }

      public static WorldVariables get(LevelAccessor world) {
         if (world instanceof ServerLevel level) {
            return (WorldVariables)level.m_8895_().m_164861_((e) -> load(e), WorldVariables::new, "jujutsucraft_worldvars");
         } else {
            return clientSide;
         }
      }
   }

   public static class MapVariables extends SavedData {
      public static final String DATA_NAME = "jujutsucraft_mapvars";
      public boolean BlastGame = false;
      public double DomainExpansionRadius = 22.0;
      public double STRONGEST_PLAYER = 0.0;
      public double BlastGameDistance = 0.0;
      public double BlastGameXCenter = 0.0;
      public double BlastGameYCenter = 0.0;
      public double BlastGameZCenter = 0.0;
      public boolean config_doVanillaMobSpawning = false;
      static MapVariables clientSide = new MapVariables();

      public MapVariables() {
      }

      public static MapVariables load(CompoundTag tag) {
         MapVariables data = new MapVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
         if (nbt == null) {
            nbt = this.m_7176_(new CompoundTag());
         }

         this.BlastGame = nbt.m_128471_("BlastGame");
         this.DomainExpansionRadius = nbt.m_128459_("DomainExpansionRadius");
         this.STRONGEST_PLAYER = nbt.m_128459_("STRONGEST_PLAYER");
         this.BlastGameDistance = nbt.m_128459_("BlastGameDistance");
         this.BlastGameXCenter = nbt.m_128459_("BlastGameXCenter");
         this.BlastGameYCenter = nbt.m_128459_("BlastGameYCenter");
         this.BlastGameZCenter = nbt.m_128459_("BlastGameZCenter");
         this.config_doVanillaMobSpawning = nbt.m_128471_("config_doVanillaMobSpawning");
      }

      public CompoundTag m_7176_(CompoundTag nbt) {
         nbt.m_128379_("BlastGame", this.BlastGame);
         nbt.m_128347_("DomainExpansionRadius", this.DomainExpansionRadius);
         nbt.m_128347_("STRONGEST_PLAYER", this.STRONGEST_PLAYER);
         nbt.m_128347_("BlastGameDistance", this.BlastGameDistance);
         nbt.m_128347_("BlastGameXCenter", this.BlastGameXCenter);
         nbt.m_128347_("BlastGameYCenter", this.BlastGameYCenter);
         nbt.m_128347_("BlastGameZCenter", this.BlastGameZCenter);
         nbt.m_128379_("config_doVanillaMobSpawning", this.config_doVanillaMobSpawning);
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.m_77762_();
         if (world instanceof Level && !world.m_5776_()) {
            JujutsucraftMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
         }

      }

      public static MapVariables get(LevelAccessor world) {
         if (world instanceof ServerLevelAccessor serverLevelAcc) {
            return (MapVariables)serverLevelAcc.m_6018_().m_7654_().m_129880_(Level.f_46428_).m_8895_().m_164861_((e) -> load(e), MapVariables::new, "jujutsucraft_mapvars");
         } else {
            return clientSide;
         }
      }
   }

   public static class SavedDataSyncMessage {
      private final int type;
      private SavedData data;

      public SavedDataSyncMessage(FriendlyByteBuf buffer) {
         this.type = buffer.readInt();
         CompoundTag nbt = buffer.m_130260_();
         if (nbt != null) {
            this.data = (SavedData)(this.type == 0 ? new MapVariables() : new WorldVariables());
            SavedData var5 = this.data;
            if (var5 instanceof MapVariables) {
               MapVariables mapVariables = (MapVariables)var5;
               mapVariables.read(nbt);
            } else {
               var5 = this.data;
               if (var5 instanceof WorldVariables) {
                  WorldVariables worldVariables = (WorldVariables)var5;
                  worldVariables.read(nbt);
               }
            }
         }

      }

      public SavedDataSyncMessage(int type, SavedData data) {
         this.type = type;
         this.data = data;
      }

      public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeInt(message.type);
         if (message.data != null) {
            buffer.m_130079_(message.data.m_7176_(new CompoundTag()));
         }

      }

      public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
         NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
               if (message.type == 0) {
                  JujutsucraftModVariables.MapVariables.clientSide = (MapVariables)message.data;
               } else {
                  JujutsucraftModVariables.WorldVariables.clientSide = (WorldVariables)message.data;
               }
            }

         });
         context.setPacketHandled(true);
      }
   }

   @EventBusSubscriber
   private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
      private final PlayerVariables playerVariables = new PlayerVariables();
      private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> this.playerVariables);

      private PlayerVariablesProvider() {
      }

      @SubscribeEvent
      public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
         if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer)) {
            event.addCapability(new ResourceLocation("jujutsucraft", "player_variables"), new PlayerVariablesProvider());
         }

      }

      public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
         return cap == JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY ? this.instance.cast() : LazyOptional.empty();
      }

      public Tag serializeNBT() {
         return this.playerVariables.writeNBT();
      }

      public void deserializeNBT(Tag nbt) {
         this.playerVariables.readNBT(nbt);
      }
   }

   public static class PlayerVariables {
      public boolean flag_shift = false;
      public boolean flag_sukuna = false;
      public boolean FlagSixEyes = false;
      public boolean noChangeTechnique = false;
      public boolean PassiveTechnique = false;
      public boolean PhysicalAttack = false;
      public boolean PlayerFlag_A = false;
      public boolean PlayerFlag_B = false;
      public boolean SecondTechnique = false;
      public double cnt_curse1 = 0.0;
      public double friend_num_keep = 0.0;
      public double PlayerCharge = 0.0;
      public double PlayerCursePower = 10.0;
      public double PlayerCursePowerChange = 0.0;
      public double PlayerCursePowerFormer = 10.0;
      public double PlayerCursePowerMAX = 10.0;
      public double PlayerCurseTechnique = 0.0;
      public double PlayerCurseTechnique2 = 0.0;
      public double PlayerExperience = 0.0;
      public double PlayerFame = 0.0;
      public double PlayerLevel = 1.0;
      public double PlayerProfession = 0.0;
      public double PlayerSelectCurseTechnique = 0.0;
      public double PlayerSelectCurseTechniqueCost = 0.0;
      public double PlayerSelectCurseTechniqueCostOrgin = 0.0;
      public double PlayerTechniqueUsedNumber = 0.0;
      public String OVERLAY1 = "";
      public String OVERLAY2 = "";
      public String OverlayCost = "Cost";
      public String OverlayCursePower = "Curse Power";
      public String PlayerSelectCurseTechniqueName = "";
      public ItemStack BodyItem;
      public boolean use_mainSkill;

      public PlayerVariables() {
         this.BodyItem = ItemStack.f_41583_;
         this.use_mainSkill = false;
      }

      public void syncPlayerVariables(Entity entity) {
         if (entity instanceof ServerPlayer serverPlayer) {
            SimpleChannel var10000 = JujutsucraftMod.PACKET_HANDLER;
            PacketDistributor var10001 = PacketDistributor.DIMENSION;
            Level var10002 = entity.m_9236_();
            Objects.requireNonNull(var10002);
            var10000.send(var10001.with(var10002::m_46472_), new PlayerVariablesSyncMessage(this, entity.m_19879_()));
         }

      }

      public Tag writeNBT() {
         CompoundTag nbt = new CompoundTag();
         nbt.m_128379_("flag_shift", this.flag_shift);
         nbt.m_128379_("flag_sukuna", this.flag_sukuna);
         nbt.m_128379_("FlagSixEyes", this.FlagSixEyes);
         nbt.m_128379_("noChangeTechnique", this.noChangeTechnique);
         nbt.m_128379_("PassiveTechnique", this.PassiveTechnique);
         nbt.m_128379_("PhysicalAttack", this.PhysicalAttack);
         nbt.m_128379_("PlayerFlag_A", this.PlayerFlag_A);
         nbt.m_128379_("PlayerFlag_B", this.PlayerFlag_B);
         nbt.m_128379_("SecondTechnique", this.SecondTechnique);
         nbt.m_128347_("cnt_curse1", this.cnt_curse1);
         nbt.m_128347_("friend_num_keep", this.friend_num_keep);
         nbt.m_128347_("PlayerCharge", this.PlayerCharge);
         nbt.m_128347_("PlayerCursePower", this.PlayerCursePower);
         nbt.m_128347_("PlayerCursePowerChange", this.PlayerCursePowerChange);
         nbt.m_128347_("PlayerCursePowerFormer", this.PlayerCursePowerFormer);
         nbt.m_128347_("PlayerCursePowerMAX", this.PlayerCursePowerMAX);
         nbt.m_128347_("PlayerCurseTechnique", this.PlayerCurseTechnique);
         nbt.m_128347_("PlayerCurseTechnique2", this.PlayerCurseTechnique2);
         nbt.m_128347_("PlayerExperience", this.PlayerExperience);
         nbt.m_128347_("PlayerFame", this.PlayerFame);
         nbt.m_128347_("PlayerLevel", this.PlayerLevel);
         nbt.m_128347_("PlayerProfession", this.PlayerProfession);
         nbt.m_128347_("PlayerSelectCurseTechnique", this.PlayerSelectCurseTechnique);
         nbt.m_128347_("PlayerSelectCurseTechniqueCost", this.PlayerSelectCurseTechniqueCost);
         nbt.m_128347_("PlayerSelectCurseTechniqueCostOrgin", this.PlayerSelectCurseTechniqueCostOrgin);
         nbt.m_128347_("PlayerTechniqueUsedNumber", this.PlayerTechniqueUsedNumber);
         nbt.m_128359_("OVERLAY1", this.OVERLAY1);
         nbt.m_128359_("OVERLAY2", this.OVERLAY2);
         nbt.m_128359_("OverlayCost", this.OverlayCost);
         nbt.m_128359_("OverlayCursePower", this.OverlayCursePower);
         nbt.m_128359_("PlayerSelectCurseTechniqueName", this.PlayerSelectCurseTechniqueName);
         nbt.m_128365_("BodyItem", this.BodyItem.m_41739_(new CompoundTag()));
         nbt.m_128379_("use_mainSkill", this.use_mainSkill);
         return nbt;
      }

      public void readNBT(Tag tag) {
         if (tag == null) {
            tag = this.writeNBT();
         }

         CompoundTag nbt = (CompoundTag)tag;
         if (nbt == null) {
            nbt = (CompoundTag)this.writeNBT();
         }

         this.flag_shift = nbt.m_128471_("flag_shift");
         this.flag_sukuna = nbt.m_128471_("flag_sukuna");
         this.FlagSixEyes = nbt.m_128471_("FlagSixEyes");
         this.noChangeTechnique = nbt.m_128471_("noChangeTechnique");
         this.PassiveTechnique = nbt.m_128471_("PassiveTechnique");
         this.PhysicalAttack = nbt.m_128471_("PhysicalAttack");
         this.PlayerFlag_A = nbt.m_128471_("PlayerFlag_A");
         this.PlayerFlag_B = nbt.m_128471_("PlayerFlag_B");
         this.SecondTechnique = nbt.m_128471_("SecondTechnique");
         this.cnt_curse1 = nbt.m_128459_("cnt_curse1");
         this.friend_num_keep = nbt.m_128459_("friend_num_keep");
         this.PlayerCharge = nbt.m_128459_("PlayerCharge");
         this.PlayerCursePower = nbt.m_128459_("PlayerCursePower");
         this.PlayerCursePowerChange = nbt.m_128459_("PlayerCursePowerChange");
         this.PlayerCursePowerFormer = nbt.m_128459_("PlayerCursePowerFormer");
         this.PlayerCursePowerMAX = nbt.m_128459_("PlayerCursePowerMAX");
         this.PlayerCurseTechnique = nbt.m_128459_("PlayerCurseTechnique");
         this.PlayerCurseTechnique2 = nbt.m_128459_("PlayerCurseTechnique2");
         this.PlayerExperience = nbt.m_128459_("PlayerExperience");
         this.PlayerFame = nbt.m_128459_("PlayerFame");
         this.PlayerLevel = nbt.m_128459_("PlayerLevel");
         this.PlayerProfession = nbt.m_128459_("PlayerProfession");
         this.PlayerSelectCurseTechnique = nbt.m_128459_("PlayerSelectCurseTechnique");
         this.PlayerSelectCurseTechniqueCost = nbt.m_128459_("PlayerSelectCurseTechniqueCost");
         this.PlayerSelectCurseTechniqueCostOrgin = nbt.m_128459_("PlayerSelectCurseTechniqueCostOrgin");
         this.PlayerTechniqueUsedNumber = nbt.m_128459_("PlayerTechniqueUsedNumber");
         this.OVERLAY1 = nbt.m_128461_("OVERLAY1");
         this.OVERLAY2 = nbt.m_128461_("OVERLAY2");
         this.OverlayCost = nbt.m_128461_("OverlayCost");
         this.OverlayCursePower = nbt.m_128461_("OverlayCursePower");
         this.PlayerSelectCurseTechniqueName = nbt.m_128461_("PlayerSelectCurseTechniqueName");
         this.BodyItem = ItemStack.m_41712_(nbt.m_128469_("BodyItem"));
         this.use_mainSkill = nbt.m_128471_("use_mainSkill");
      }
   }

   public static class PlayerVariablesSyncMessage {
      private final int target;
      private final PlayerVariables data;

      public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
         this.data = new PlayerVariables();
         this.data.readNBT(buffer.m_130260_());
         this.target = buffer.readInt();
      }

      public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
         this.data = data;
         this.target = entityid;
      }

      public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
         buffer.m_130079_((CompoundTag)message.data.writeNBT());
         buffer.writeInt(message.target);
      }

      public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
         NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer()) {
               PlayerVariables variables = (PlayerVariables)Minecraft.m_91087_().f_91074_.m_9236_().m_6815_(message.target).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables());
               variables.flag_shift = message.data.flag_shift;
               variables.flag_sukuna = message.data.flag_sukuna;
               variables.FlagSixEyes = message.data.FlagSixEyes;
               variables.noChangeTechnique = message.data.noChangeTechnique;
               variables.PassiveTechnique = message.data.PassiveTechnique;
               variables.PhysicalAttack = message.data.PhysicalAttack;
               variables.PlayerFlag_A = message.data.PlayerFlag_A;
               variables.PlayerFlag_B = message.data.PlayerFlag_B;
               variables.SecondTechnique = message.data.SecondTechnique;
               variables.cnt_curse1 = message.data.cnt_curse1;
               variables.friend_num_keep = message.data.friend_num_keep;
               variables.PlayerCharge = message.data.PlayerCharge;
               variables.PlayerCursePower = message.data.PlayerCursePower;
               variables.PlayerCursePowerChange = message.data.PlayerCursePowerChange;
               variables.PlayerCursePowerFormer = message.data.PlayerCursePowerFormer;
               variables.PlayerCursePowerMAX = message.data.PlayerCursePowerMAX;
               variables.PlayerCurseTechnique = message.data.PlayerCurseTechnique;
               variables.PlayerCurseTechnique2 = message.data.PlayerCurseTechnique2;
               variables.PlayerExperience = message.data.PlayerExperience;
               variables.PlayerFame = message.data.PlayerFame;
               variables.PlayerLevel = message.data.PlayerLevel;
               variables.PlayerProfession = message.data.PlayerProfession;
               variables.PlayerSelectCurseTechnique = message.data.PlayerSelectCurseTechnique;
               variables.PlayerSelectCurseTechniqueCost = message.data.PlayerSelectCurseTechniqueCost;
               variables.PlayerSelectCurseTechniqueCostOrgin = message.data.PlayerSelectCurseTechniqueCostOrgin;
               variables.PlayerTechniqueUsedNumber = message.data.PlayerTechniqueUsedNumber;
               variables.OVERLAY1 = message.data.OVERLAY1;
               variables.OVERLAY2 = message.data.OVERLAY2;
               variables.OverlayCost = message.data.OverlayCost;
               variables.OverlayCursePower = message.data.OverlayCursePower;
               variables.PlayerSelectCurseTechniqueName = message.data.PlayerSelectCurseTechniqueName;
               variables.BodyItem = message.data.BodyItem;
               variables.use_mainSkill = message.data.use_mainSkill;
            }

         });
         context.setPacketHandled(true);
      }
   }
}
