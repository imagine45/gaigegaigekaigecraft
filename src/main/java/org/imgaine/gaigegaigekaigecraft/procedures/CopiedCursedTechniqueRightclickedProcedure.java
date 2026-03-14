package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CopiedCursedTechniqueRightclickedProcedure {
   public CopiedCursedTechniqueRightclickedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean used = false;
         double NUM1 = 0.0;
         double skill = 0.0;
         entity.getPersistentData().m_128379_("PRESS_Z", false);
         if (itemstack.m_41784_().m_128459_("skill") > 0.0 && !itemstack.m_41784_().m_128471_("Used")) {
            label111: {
               if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 5.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5.0) {
                  label110: {
                     if (!LocateRikaProcedure.execute(world, entity)) {
                        if (!(entity instanceof LivingEntity)) {
                           break label110;
                        }

                        LivingEntity _livEnt5 = (LivingEntity)entity;
                        if (!_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) || entity.getPersistentData().m_128471_("Failed")) {
                           break label110;
                        }
                     }

                     if (entity.getPersistentData().m_128459_("skill") == 0.0) {
                        itemstack.m_41784_().m_128379_("used_item", true);
                        StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
                        if (entity.getPersistentData().m_128459_("skill") > 0.0) {
                           skill = entity.getPersistentData().m_128459_("skill");
                           used = true;
                        }

                        itemstack.m_41784_().m_128379_("used_item", false);
                     }
                     break label111;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.dont_use").getString()), true);
                  }
               }
            }
         }

         NUM1 = -230.0 - Math.random();
         if (used && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = EntityType.f_20549_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), NUM1, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
            }
         }

         used = false;
         Vec3 _center = new Vec3(entity.m_20185_(), NUM1, entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entityiterator instanceof Bat && entityiterator.m_6084_()) {
               used = true;
               if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                  entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
               }

               if (!entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }
               break;
            }
         }

         if (used) {
            entity.getPersistentData().m_128347_("skill", skill);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
               }
            }

            itemstack.m_41784_().m_128379_("Used", true);
            entity.getPersistentData().m_128379_("PRESS_Z", true);
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(itemstack.m_41611_().getString()), true);
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_36335_().m_41524_(itemstack.m_41720_(), 5);
            }
         }

      }
   }
}
