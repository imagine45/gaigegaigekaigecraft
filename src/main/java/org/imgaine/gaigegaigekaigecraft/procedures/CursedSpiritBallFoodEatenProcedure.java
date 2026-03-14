package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class CursedSpiritBallFoodEatenProcedure {
   public CursedSpiritBallFoodEatenProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         String STR1 = "";
         double NUM1 = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         boolean logic_a = false;
         itemstack.m_41774_(1);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 10, 0, false, false));
            }
         }

         if (itemstack.m_41784_().m_128461_("owner_name_data").equals(entity.m_5446_().getString()) && (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 18.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18.0)) {
            x_pos = 0.0;
            z_pos = 0.0;
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               Commands var10000 = entity.m_20194_().m_129892_();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               long var10002 = Math.round(x_pos);
               var10000.m_230957_(var10001, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
            }

            if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _origLevel = (ServerLevel)world;
               LevelAccessor var26 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
               if (var26 != null) {
                  Vec3 _center = new Vec3(x_pos, itemstack.m_41784_().m_128459_("y_data"), z_pos);

                  for(Entity entityiterator : var26.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entity != entityiterator && itemstack.m_41784_().m_128461_("name_data").equals(entityiterator.m_5446_().getString()) && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") != entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                        NUM1 = 0.0;

                        for(int index0 = 0; index0 < 10000; ++index0) {
                           ++NUM1;
                           STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                           if (entity.getPersistentData().m_128459_(STR1) == 0.0 || entity.getPersistentData().m_128461_(STR1 + "_name").equals(itemstack.m_41784_().m_128461_("name_data"))) {
                              entity.getPersistentData().m_128347_(STR1, itemstack.m_41784_().m_128459_("y_data"));
                              entity.getPersistentData().m_128359_(STR1 + "_name", itemstack.m_41784_().m_128461_("name_data"));
                              break;
                           }
                        }

                        entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                        entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                        break;
                     }
                  }

                  logic_a = false;
                  entity.getPersistentData().m_128347_(STR1 + "_num", 0.0);
                  _center = new Vec3(x_pos, itemstack.m_41784_().m_128459_("y_data"), z_pos);

                  for(Entity entityiterator : var26.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entity != entityiterator && itemstack.m_41784_().m_128461_("name_data").equals(entityiterator.m_5446_().getString()) && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                        entity.getPersistentData().m_128347_(STR1 + "_num", entity.getPersistentData().m_128459_(STR1 + "_num") + 1.0);
                     }
                  }
               }

               world = world;
            }

            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         } else if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 0.0 && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19614_, 299, 19));
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.NEUTRAL, 1.0F, 0.5F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
            }
         }

         Item var44 = itemstack.m_41720_();
         ItemStack var46;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var46 = _livEnt.m_21205_();
         } else {
            var46 = ItemStack.f_41583_;
         }

         if (var44 == var46.m_41720_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }
         } else {
            var44 = itemstack.m_41720_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var46 = _livEnt.m_21206_();
            } else {
               var46 = ItemStack.f_41583_;
            }

            if (var44 == var46.m_41720_() && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.OFF_HAND, true);
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_36335_().m_41524_(itemstack.m_41720_(), 1);
         }

      }
   }
}
