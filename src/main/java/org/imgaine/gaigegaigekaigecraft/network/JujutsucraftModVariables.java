package org.imgaine.gaigegaigekaigecraft.network;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Supplier;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
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
      Gaigegaigekaigecraft.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
      Gaigegaigekaigecraft.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
   }

   @SubscribeEvent
   public static void init(RegisterCapabilitiesEvent event) {
      event.register(PlayerVariables.class);
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      Gaigegaigekaigecraft.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
   }

   @EventBusSubscriber
   public static class EventBusVariableHandlers {
      public EventBusVariableHandlers() {
      }

      @SubscribeEvent
      public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            for(Entity entityiterator : new ArrayList<Entity>(event.getEntity().level().players())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            for(Entity entityiterator : new ArrayList<Entity>(event.getEntity().level().players())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            for(Entity entityiterator : new ArrayList<Entity>(event.getEntity().level().players())) {
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

         if (!event.getEntity().level().isClientSide()) {
            for(Entity entityiterator : new ArrayList<Entity>(event.getEntity().level().players())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            SavedData mapdata = JujutsucraftModVariables.MapVariables.get(event.getEntity().level());
            SavedData worlddata = JujutsucraftModVariables.WorldVariables.get(event.getEntity().level());
            if (mapdata != null) {
               Gaigegaigekaigecraft.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new SavedDataSyncMessage(0, mapdata));
            }

            if (worlddata != null) {
               Gaigegaigekaigecraft.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new SavedDataSyncMessage(1, worlddata));
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
         if (!event.getEntity().level().isClientSide()) {
            SavedData worlddata = JujutsucraftModVariables.WorldVariables.get(event.getEntity().level());
            if (worlddata != null) {
               Gaigegaigekaigecraft.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new SavedDataSyncMessage(1, worlddata));
            }
         }

      }
   }

   public static class WorldVariables extends SavedData {
      public static final String DATA_NAME = "gaigegaigekaigecraft_worldvars";
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

      public CompoundTag save(CompoundTag nbt) {
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.setDirty();
         if (world instanceof Level level) {
            if (!level.isClientSide()) {
               SimpleChannel var10000 = Gaigegaigekaigecraft.PACKET_HANDLER;
               PacketDistributor var10001 = PacketDistributor.DIMENSION;
               Objects.requireNonNull(level);
               var10000.send(var10001.with(level::dimension), new SavedDataSyncMessage(1, this));
            }
         }

      }

      public static WorldVariables get(LevelAccessor world) {
         if (world instanceof ServerLevel level) {
            return (WorldVariables)level.getDataStorage().computeIfAbsent((e) -> load(e), WorldVariables::new, "gaigegaigekaigecraft_worldvars");
         } else {
            return clientSide;
         }
      }
   }

   public static class MapVariables extends SavedData {
      public static final String DATA_NAME = "gaigegaigekaigecraft_mapvars";
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
            nbt = this.save(new CompoundTag());
         }

         this.BlastGame = nbt.getBoolean("BlastGame");
         this.DomainExpansionRadius = nbt.getDouble("DomainExpansionRadius");
         this.STRONGEST_PLAYER = nbt.getDouble("STRONGEST_PLAYER");
         this.BlastGameDistance = nbt.getDouble("BlastGameDistance");
         this.BlastGameXCenter = nbt.getDouble("BlastGameXCenter");
         this.BlastGameYCenter = nbt.getDouble("BlastGameYCenter");
         this.BlastGameZCenter = nbt.getDouble("BlastGameZCenter");
         this.config_doVanillaMobSpawning = nbt.getBoolean("config_doVanillaMobSpawning");
      }

      public CompoundTag save(CompoundTag nbt) {
         nbt.putBoolean("BlastGame", this.BlastGame);
         nbt.putDouble("DomainExpansionRadius", this.DomainExpansionRadius);
         nbt.putDouble("STRONGEST_PLAYER", this.STRONGEST_PLAYER);
         nbt.putDouble("BlastGameDistance", this.BlastGameDistance);
         nbt.putDouble("BlastGameXCenter", this.BlastGameXCenter);
         nbt.putDouble("BlastGameYCenter", this.BlastGameYCenter);
         nbt.putDouble("BlastGameZCenter", this.BlastGameZCenter);
         nbt.putBoolean("config_doVanillaMobSpawning", this.config_doVanillaMobSpawning);
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.setDirty();
         if (world instanceof Level && !world.isClientSide()) {
            Gaigegaigekaigecraft.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
         }

      }

      public static MapVariables get(LevelAccessor world) {
         if (world instanceof ServerLevelAccessor serverLevelAcc) {
            return (MapVariables)serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent((e) -> load(e), MapVariables::new, "gaigegaigekaigecraft_mapvars");
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
         CompoundTag nbt = buffer.readNbt();
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
            buffer.writeNbt(message.data.save(new CompoundTag()));
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
            event.addCapability(new ResourceLocation("gaigegaigekaigecraft", "player_variables"), new PlayerVariablesProvider());
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
      public String OverlayCursePower = "Cursed Energy";
      public String PlayerSelectCurseTechniqueName = "";
      public ItemStack BodyItem;
      public boolean use_mainSkill;

      public PlayerVariables() {
         this.BodyItem = ItemStack.EMPTY;
         this.use_mainSkill = false;
      }

      public void syncPlayerVariables(Entity entity) {
         if (entity instanceof ServerPlayer serverPlayer) {
            SimpleChannel var10000 = Gaigegaigekaigecraft.PACKET_HANDLER;
            PacketDistributor var10001 = PacketDistributor.DIMENSION;
            Level var10002 = entity.level();
            Objects.requireNonNull(var10002);
            var10000.send(var10001.with(var10002::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
         }

      }

      public Tag writeNBT() {
         CompoundTag nbt = new CompoundTag();
         nbt.putBoolean("flag_shift", this.flag_shift);
         nbt.putBoolean("flag_sukuna", this.flag_sukuna);
         nbt.putBoolean("FlagSixEyes", this.FlagSixEyes);
         nbt.putBoolean("noChangeTechnique", this.noChangeTechnique);
         nbt.putBoolean("PassiveTechnique", this.PassiveTechnique);
         nbt.putBoolean("PhysicalAttack", this.PhysicalAttack);
         nbt.putBoolean("PlayerFlag_A", this.PlayerFlag_A);
         nbt.putBoolean("PlayerFlag_B", this.PlayerFlag_B);
         nbt.putBoolean("SecondTechnique", this.SecondTechnique);
         nbt.putDouble("cnt_curse1", this.cnt_curse1);
         nbt.putDouble("friend_num_keep", this.friend_num_keep);
         nbt.putDouble("PlayerCharge", this.PlayerCharge);
         nbt.putDouble("PlayerCursePower", this.PlayerCursePower);
         nbt.putDouble("PlayerCursePowerChange", this.PlayerCursePowerChange);
         nbt.putDouble("PlayerCursePowerFormer", this.PlayerCursePowerFormer);
         nbt.putDouble("PlayerCursePowerMAX", this.PlayerCursePowerMAX);
         nbt.putDouble("PlayerCurseTechnique", this.PlayerCurseTechnique);
         nbt.putDouble("PlayerCurseTechnique2", this.PlayerCurseTechnique2);
         nbt.putDouble("PlayerExperience", this.PlayerExperience);
         nbt.putDouble("PlayerFame", this.PlayerFame);
         nbt.putDouble("PlayerLevel", this.PlayerLevel);
         nbt.putDouble("PlayerProfession", this.PlayerProfession);
         nbt.putDouble("PlayerSelectCurseTechnique", this.PlayerSelectCurseTechnique);
         nbt.putDouble("PlayerSelectCurseTechniqueCost", this.PlayerSelectCurseTechniqueCost);
         nbt.putDouble("PlayerSelectCurseTechniqueCostOrgin", this.PlayerSelectCurseTechniqueCostOrgin);
         nbt.putDouble("PlayerTechniqueUsedNumber", this.PlayerTechniqueUsedNumber);
         nbt.putString("OVERLAY1", this.OVERLAY1);
         nbt.putString("OVERLAY2", this.OVERLAY2);
         nbt.putString("OverlayCost", this.OverlayCost);
         nbt.putString("OverlayCursePower", this.OverlayCursePower);
         nbt.putString("PlayerSelectCurseTechniqueName", this.PlayerSelectCurseTechniqueName);
         nbt.put("BodyItem", this.BodyItem.save(new CompoundTag()));
         nbt.putBoolean("use_mainSkill", this.use_mainSkill);
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

         this.flag_shift = nbt.getBoolean("flag_shift");
         this.flag_sukuna = nbt.getBoolean("flag_sukuna");
         this.FlagSixEyes = nbt.getBoolean("FlagSixEyes");
         this.noChangeTechnique = nbt.getBoolean("noChangeTechnique");
         this.PassiveTechnique = nbt.getBoolean("PassiveTechnique");
         this.PhysicalAttack = nbt.getBoolean("PhysicalAttack");
         this.PlayerFlag_A = nbt.getBoolean("PlayerFlag_A");
         this.PlayerFlag_B = nbt.getBoolean("PlayerFlag_B");
         this.SecondTechnique = nbt.getBoolean("SecondTechnique");
         this.cnt_curse1 = nbt.getDouble("cnt_curse1");
         this.friend_num_keep = nbt.getDouble("friend_num_keep");
         this.PlayerCharge = nbt.getDouble("PlayerCharge");
         this.PlayerCursePower = nbt.getDouble("PlayerCursePower");
         this.PlayerCursePowerChange = nbt.getDouble("PlayerCursePowerChange");
         this.PlayerCursePowerFormer = nbt.getDouble("PlayerCursePowerFormer");
         this.PlayerCursePowerMAX = nbt.getDouble("PlayerCursePowerMAX");
         this.PlayerCurseTechnique = nbt.getDouble("PlayerCurseTechnique");
         this.PlayerCurseTechnique2 = nbt.getDouble("PlayerCurseTechnique2");
         this.PlayerExperience = nbt.getDouble("PlayerExperience");
         this.PlayerFame = nbt.getDouble("PlayerFame");
         this.PlayerLevel = nbt.getDouble("PlayerLevel");
         this.PlayerProfession = nbt.getDouble("PlayerProfession");
         this.PlayerSelectCurseTechnique = nbt.getDouble("PlayerSelectCurseTechnique");
         this.PlayerSelectCurseTechniqueCost = nbt.getDouble("PlayerSelectCurseTechniqueCost");
         this.PlayerSelectCurseTechniqueCostOrgin = nbt.getDouble("PlayerSelectCurseTechniqueCostOrgin");
         this.PlayerTechniqueUsedNumber = nbt.getDouble("PlayerTechniqueUsedNumber");
         this.OVERLAY1 = nbt.getString("OVERLAY1");
         this.OVERLAY2 = nbt.getString("OVERLAY2");
         this.OverlayCost = nbt.getString("OverlayCost");
         this.OverlayCursePower = nbt.getString("OverlayCursePower");
         this.PlayerSelectCurseTechniqueName = nbt.getString("PlayerSelectCurseTechniqueName");
         this.BodyItem = ItemStack.of(nbt.getCompound("BodyItem"));
         this.use_mainSkill = nbt.getBoolean("use_mainSkill");
      }
   }

   public static class PlayerVariablesSyncMessage {
      private final int target;
      private final PlayerVariables data;

      public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
         this.data = new PlayerVariables();
         this.data.readNBT(buffer.readNbt());
         this.target = buffer.readInt();
      }

      public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
         this.data = data;
         this.target = entityid;
      }

      public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeNbt((CompoundTag)message.data.writeNBT());
         buffer.writeInt(message.target);
      }

      public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
         NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer()) {
               PlayerVariables variables = (PlayerVariables)Minecraft.getInstance().player.level().getEntity(message.target).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables());
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
